package com.hernan.ppai.gestor;

import com.hernan.ppai.dominio.Encuesta;
import com.hernan.ppai.dominio.IAgregado;
import com.hernan.ppai.dominio.IIterador;
import com.hernan.ppai.dominio.ImpresorArchivoCSV;
import com.hernan.ppai.dominio.IteradorEncuesta;
import com.hernan.ppai.dominio.IteradorLlamada;
import com.hernan.ppai.dominio.Llamada;
import com.hernan.ppai.dominio.RespuestaCliente;
import com.hernan.ppai.sql.ConexionSql;
import java.util.Date;
import com.hernan.ppai.vista.ConsultarEncuestaVista;
import com.hernan.ppai.vista.PantallaEncuesta;
import defaultPackages.Gestor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorEncuesta implements IAgregado<Llamada>{
    
    PantallaEncuesta pantalla;
    private Date fechaInicio;
    private Date fechaFin;
    private ArrayList<Llamada> listaLlamadas = new ArrayList<>();
    private ArrayList<Object> filtros = new ArrayList<>();
    private ArrayList<Object> filtrosEncuesta = new ArrayList<>();
    private Llamada seleccionLlamada;
    private String nombreClienteYEstado;
    
    ConexionSql conexion = new ConexionSql();
    
    private ArrayList<Llamada> llamadasPeriodo = new ArrayList<>();
    private IteradorLlamada iteradorLlamada;
    private ArrayList<Llamada> llamadasFiltradas = new ArrayList<>();
    private ArrayList<RespuestaCliente> respuestasCliente = new ArrayList<>();
    private ArrayList<Encuesta> listaEncuestas = new ArrayList<>();
    private Gestor gestor = new Gestor();
    private IteradorEncuesta iteradorEncuesta;
    private int duracionLlamadaSeleccionada;
    private ArrayList<String> encuestaPregunta;
    private ArrayList<String> respuestasDelCliente;
    private ImpresorArchivoCSV impresor;
    private ImpresorArchivoCSV instanciaCSV;
    

    public void consultarEncuesta() {
        this.buscarPeriodo();
    }
    public void buscarPeriodo(){
        pantalla.solicitarPeriodoLlamada();
    }
    
    public void tomarPeriodoLlamada(Date fechaInicio, Date fechaFin) {
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.buscarLlamadaConEncuesta();
    }
    
    public void buscarLlamadaConEncuesta(){
        
        Connection connection = conexion.conectar();
        if (connection != null) {
            try {
                // Crear una declaración SQL
                Statement statement = connection.createStatement();

                // Ejecutar la consulta SQL
                ResultSet resultSet = statement.executeQuery("SELECT * FROM llamada");

                // Iterar sobre los resultados y mostrar la información
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int duracion = resultSet.getInt("duracion");
                    boolean encuestaEnviada = resultSet.getBoolean("encuesta enviada");
                    int cliente = resultSet.getInt("cliente");

                    Llamada llamada = new Llamada(id, duracion, encuestaEnviada, cliente);

                    this.listaLlamadas.add(llamada);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Cerrar la conexión
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        filtros.clear();
        if (fechaInicio != null && fechaFin != null) {
            this.filtros.add(fechaInicio);
            this.filtros.add(fechaFin);
            this.iteradorLlamada = (IteradorLlamada) this.crearIterador(listaLlamadas);

            iteradorLlamada.primero();
            llamadasFiltradas.clear();
            while (!iteradorLlamada.haTerminado()) {
                Llamada llamadaActual = iteradorLlamada.actual(filtros);
                if (llamadaActual != null) {
                    llamadasFiltradas.add(llamadaActual);
                }
                iteradorLlamada.siguiente();
            }
            this.pantalla.mostrarDatosLlamada(llamadasFiltradas);
        }
        
    }

    
    
    public void setPantalla(PantallaEncuesta pantallaEncuesta) {
        this.pantalla = pantallaEncuesta;
    }
    public void setConsultarEncuestaVista(ConsultarEncuestaVista consultarEncuestaVista) {
        this.pantalla.setConsultarEncuestaVista(consultarEncuestaVista);
    }

    @Override
    public IIterador crearIterador(ArrayList<Llamada> listaElementos) {
        IteradorLlamada iteradorLlamada = new IteradorLlamada(listaLlamadas);
        return iteradorLlamada;
    } 

    public void tomarSeleccionLlamada(int llamadaSeleccionada) {
        this.buscarDatosLlamada(llamadaSeleccionada);

    }

    private void buscarDatosLlamada(int llamadaSeleccionada) {
        
        Connection connection = conexion.conectar();

            if (connection != null) {
                try {
                    // Crear una consulta preparada con un parámetro
                    String sql = "SELECT * FROM llamada WHERE id = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        // Establecer el valor del parámetro
                        preparedStatement.setInt(1, llamadaSeleccionada);  // Reemplaza tuId con el valor real del ID

                        // Ejecutar la consulta y obtener los resultados
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Iterar sobre los resultados y mostrar la información
                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                int duracion = resultSet.getInt("duracion");
                                boolean encuestaEnviada =resultSet.getBoolean("encuesta enviada");
                                int cliente = resultSet.getInt("cliente");
                                this.seleccionLlamada = new Llamada(id, duracion, encuestaEnviada,cliente);
                                
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // Cerrar la conexión en el bloque finally para asegurar que se cierre incluso en caso de excepción
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            
            
            this.nombreClienteYEstado = this.seleccionLlamada.getNombreClienteDeLlamada();
            this.duracionLlamadaSeleccionada = this.getDuracion();
            this.obtenerDatosEncuesta();
        
    }
    
    public int getDuracion(){
        return this.seleccionLlamada.getDuracion();  
    }

    private void obtenerDatosEncuesta() {
        respuestasCliente = this.buscarRespuestasBD();
        int idLlamada = seleccionLlamada.getId();
        this.respuestasDelCliente = this.seleccionLlamada.getRespuestas(respuestasCliente,idLlamada);
        this.buscarDescripcionEncuestas();
        
    }

    private ArrayList<RespuestaCliente> buscarRespuestasBD() {
        
        Connection connection = conexion.conectar();

            if (connection != null) {
                try {
                    // Crear una consulta preparada con un parámetro
                    String sql = "SELECT * FROM respuestacliente";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                        // Ejecutar la consulta y obtener los resultados
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Iterar sobre los resultados y mostrar la información
                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                String descripcion = resultSet.getString("descripcion");
                                int llamada = resultSet.getInt("llamada");
                                this.respuestasCliente.add(new RespuestaCliente(id, descripcion, llamada));
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // Cerrar la conexión en el bloque finally para asegurar que se cierre incluso en caso de excepción
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        
        return this.respuestasCliente;
        
    }

    public void buscarDescripcionEncuestas() {
        
        Connection connection = conexion.conectar();

            if (connection != null) {
                try {
                    // Crear una consulta preparada con un parámetro
                    String sql = "SELECT * FROM encuesta";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                        // Ejecutar la consulta y obtener los resultados
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Iterar sobre los resultados y mostrar la información
                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                String descripcion = resultSet.getString("descripcion");
                                this.listaEncuestas.add(new Encuesta(id, descripcion));
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // Cerrar la conexión en el bloque finally para asegurar que se cierre incluso en caso de excepción
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            
        this.iteradorEncuesta = (IteradorEncuesta) gestor.crearIterador(listaEncuestas);
        
        
        
        this.iteradorEncuesta.primero();
        while (!iteradorEncuesta.haTerminado()) {
            Encuesta encuestaActual = iteradorEncuesta.actual(filtrosEncuesta);
            this.encuestaPregunta = encuestaActual.getDescripcion();
            
            iteradorEncuesta.siguiente();
        }
        this.pantalla.mostrarDatosEncuestaLlamada(this.nombreClienteYEstado,this.duracionLlamadaSeleccionada,this.respuestasDelCliente,this.encuestaPregunta);
        
        this.getFormatoImpresion();
    }

    private void getFormatoImpresion() {
        this.pantalla.mostrarFormatoImpresionPSeleccion();
    }

    public void tomarFormato(Object formato) {
        // Verifica si el objeto no es nulo y es una instancia de String
        if (formato != null && formato instanceof String) {
            // Convierte el objeto a String y compara
            String formatoStr = formato.toString();

            // Compara la cadena
            if ("CSV".equals(formatoStr)) {
                this.imprimirResultadoEncuesta();
                JOptionPane.showMessageDialog(null, "Archivo CSV creado con exito", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

            }else{
                JOptionPane.showMessageDialog(null, "No hay impresora", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }



    private void imprimirResultadoEncuesta() {
        this.instanciaCSV = this.impresor.getInstancia();
        this.instanciaCSV.imprimir(this.nombreClienteYEstado,this.duracionLlamadaSeleccionada,this.respuestasDelCliente,this.encuestaPregunta);
    }
    
    
    
}

