package com.hernan.ppai.dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import com.hernan.ppai.sql.ConexionSql;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Llamada {
    private int id;
    private int duracion;
    private boolean encuestaEnviada;
    private ArrayList<CambioEstado> listaCambioEstado = new ArrayList<>();
    ConexionSql conexion = new ConexionSql();
    

    public Llamada(int id, int duracion, boolean encuestaEnviada) {
        this.id = id;
        this.duracion = duracion;
        this.encuestaEnviada = encuestaEnviada;
    }

    public int getId() {
        return id;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean isEncuestaEnviada() {
        return encuestaEnviada;
    }
    
    
    
    public boolean esDePeriodo(Date fechaInicio, Date fechaFin,int identificador){
        return this.determinarEstadoInicial(fechaInicio, fechaFin,identificador);

    }

    public boolean determinarEstadoInicial(Date fechaInicio, Date fechaFin,int identificador) {
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
                            CambioEstado cambioEstado = new CambioEstado(fechaHoraInicio,llamada,id);

                            this.listaCambioEstado.add(cambioEstado);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        Timestamp fechaMasTemprana = null;
        
        for (CambioEstado cambioEstado : listaCambioEstado) {
            Timestamp fechaActual = (Timestamp) cambioEstado.getFechaHoraInicio();
            // Si la fechaMasTemprana aún no se ha establecido o la fechaActual es más temprana
            if (fechaMasTemprana == null || fechaActual.before(fechaMasTemprana)) {
                fechaMasTemprana = fechaActual;
            }
        }

       
        
        // Convertir Timestamp a Date
        Date fechaMasTempranaDate = new Date(fechaMasTemprana.getTime());

        // Verificar si fechaMasTempranaDate está entre fechaInicio y fechaFin
        if (fechaMasTempranaDate.after(fechaInicio) && fechaMasTempranaDate.before(fechaFin)) {
            System.out.println("Fecha más temprana: " + fechaMasTemprana);
            return true;
             
        } else {
            return false;
        }
        
    }


} 



