package com.hernan.ppai.dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import com.hernan.ppai.sql.ConexionSql;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Llamada implements IAgregado<RespuestaCliente>{
    private int id;
    private int duracion;
    private boolean encuestaEnviada;
    private ArrayList<CambioEstado> listaCambioEstado = new ArrayList<>();
    private int cliente;
    private Cliente clienteLlamada;
    private String nombreClienteLlamada;
    private ArrayList<CambioEstado> listaCambioEstado2 = new ArrayList<>();
    private String estadoActual;
    ConexionSql conexion = new ConexionSql();
    

    @Override
    public String toString() {
        return "Llamada " + id + ' ';
    }

    public Llamada(int id, int duracion, boolean encuestaEnviada, int cliente) {
        this.id = id;
        this.duracion = duracion;
        this.encuestaEnviada = encuestaEnviada;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean tieneEncuestaRespondida() {
        return encuestaEnviada;
    }

    
    
    
    public boolean esDePeriodo(Date fechaInicio, Date fechaFin,int identificador){
        return this.determinarEstadoInicial(fechaInicio, fechaFin,identificador);

    }

public boolean determinarEstadoInicial(Date fechaInicio, Date fechaFin, int identificador) {
    Connection connection = conexion.conectar();

    if (connection != null) {
        try {
            // Crear una consulta preparada con un parámetro
            String sql = "SELECT * FROM cambioestado WHERE llamada = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Establecer el valor del parámetro
                preparedStatement.setInt(1, identificador);  // Reemplaza tuId con el valor real del ID

                // Ejecutar la consulta y obtener los resultados
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Iterar sobre los resultados y mostrar la información
                    while (resultSet.next()) {
                        Timestamp fechaHoraInicio = resultSet.getTimestamp("fechahorainicio");
                        int llamada = resultSet.getInt("llamada");
                        int id = resultSet.getInt("id");
                        int estado = resultSet.getInt("estado");
                        CambioEstado cambioEstado = new CambioEstado(fechaHoraInicio, llamada, id,estado);
                        

                        this.listaCambioEstado.add(cambioEstado);
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

    Timestamp fechaMasTemprana = null;

    // Verificar si listaCambioEstado no está vacía antes de intentar obtener la fechaMasTemprana
    if (!listaCambioEstado.isEmpty()) {
        for (CambioEstado cambioEstado : listaCambioEstado) {
            Timestamp fechaActual = (Timestamp) cambioEstado.getFechaHoraInicio();
            // Si la fechaMasTemprana aún no se ha establecido o la fechaActual es más temprana
            if (fechaMasTemprana == null || fechaActual.before(fechaMasTemprana)) {
                fechaMasTemprana = fechaActual;
            }
        }
    }

    // Verificar si fechaMasTemprana es null antes de intentar usarla
    if (fechaMasTemprana != null) {
        // Convertir Timestamp a Date
        Date fechaMasTempranaDate = new Date(fechaMasTemprana.getTime());

        // Verificar si fechaMasTempranaDate está entre fechaInicio y fechaFin
        return fechaMasTempranaDate.after(fechaInicio) && fechaMasTempranaDate.before(fechaFin);
    } else {
        // Manejar el caso cuando fechaMasTemprana es null
        return false;
    }
}

    public String getNombreClienteDeLlamada() {
        
        Connection connection = conexion.conectar();

            if (connection != null) {
                try {
                    // Crear una consulta preparada con un parámetro
                    String sql = "SELECT * FROM cliente WHERE id = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        // Establecer el valor del parámetro
                        preparedStatement.setInt(1, this.cliente);  // Reemplaza tuId con el valor real del ID

                        // Ejecutar la consulta y obtener los resultados
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Iterar sobre los resultados y mostrar la información
                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                String nombre = resultSet.getString("nombre");
                                this.clienteLlamada = new Cliente(id,nombre);
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
            this. nombreClienteLlamada = this.clienteLlamada.getNombre();
            this.estadoActual = this.determinarEstadoActual();
            return ""+ nombreClienteLlamada + estadoActual;
        
    }

    private String determinarEstadoActual() {
        
        Connection connection = conexion.conectar();

            if (connection != null) {
                try {
                    // Crear una consulta preparada con un parámetro
                    String sql = "SELECT * FROM cambioestado WHERE llamada = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        // Establecer el valor del parámetro
                        preparedStatement.setInt(1, this.id);  // Reemplaza tuId con el valor real del ID

                        // Ejecutar la consulta y obtener los resultados
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Iterar sobre los resultados y mostrar la información
                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                Timestamp fechaHoraInicio = resultSet.getTimestamp("fechahorainicio");
                                int llamada = resultSet.getInt("llamada");
                                int estado = resultSet.getInt("estado");
                                CambioEstado cambioEstado2 = new CambioEstado(fechaHoraInicio, llamada, id, estado);
                                this.listaCambioEstado2.add(cambioEstado2);
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
            
           CambioEstado cambioEstadoConFechaMasReciente = null;

            for (CambioEstado cambioEstado2 : listaCambioEstado2) {
                Timestamp fechaActual = cambioEstado2.getFechaHoraInicio();

                // Si cambioEstadoConFechaMasReciente es nulo o la fechaActual es más reciente
                if (cambioEstadoConFechaMasReciente == null || fechaActual.after(cambioEstadoConFechaMasReciente.getFechaHoraInicio())) {
                    cambioEstadoConFechaMasReciente = cambioEstado2;
                }
            }

            return cambioEstadoConFechaMasReciente.getNombreEstado();
    }

    @Override
    public IIterador<RespuestaCliente> crearIterador(ArrayList<RespuestaCliente> listaElementos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
/**
    public void getRespuestas() {
        this.crearIterador(listaElementos)
        //return respuestas;
    }


**/

} 



