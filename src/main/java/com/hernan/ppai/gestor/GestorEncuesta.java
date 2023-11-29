package com.hernan.ppai.gestor;

import com.hernan.ppai.dominio.IAgregado;
import com.hernan.ppai.dominio.IIterador;
import com.hernan.ppai.dominio.IteradorLlamada;
import com.hernan.ppai.dominio.Llamada;
import com.hernan.ppai.sql.ConexionSql;
import java.util.Date;
import com.hernan.ppai.vista.ConsultarEncuestaVista;
import com.hernan.ppai.vista.PantallaEncuesta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorEncuesta implements IAgregado{
    
    PantallaEncuesta pantalla;
    private Date fechaInicio;
    private Date fechaFin;
    private ArrayList<Llamada> listaLlamadas = new ArrayList<>();
    private ArrayList<Object> filtros = new ArrayList<>();
    
    ConexionSql conexion = new ConexionSql();
    
    private ArrayList<Llamada> llamadasPeriodo = new ArrayList<>();
    private IteradorLlamada iteradorLlamada;
    private ArrayList<Llamada> llamadasFiltradas = new ArrayList<>();

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
                    
                    Llamada llamada = new Llamada(id,duracion,encuestaEnviada);
                    
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
        if (fechaInicio!=null && fechaFin!=null){
            this.filtros.add(fechaInicio);
            this.filtros.add(fechaFin);
            this.iteradorLlamada = (IteradorLlamada) this.crearIterador(listaLlamadas);
            
        }
        iteradorLlamada.primero();
        while (iteradorLlamada.haTerminado()==false) {
            iteradorLlamada.haTerminado();
            System.out.println( iteradorLlamada.actual(filtros));
            iteradorLlamada.siguiente();
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
    
    
    
}