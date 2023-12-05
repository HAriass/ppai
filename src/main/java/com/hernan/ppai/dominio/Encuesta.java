package com.hernan.ppai.dominio;

import com.hernan.ppai.sql.ConexionSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Encuesta {
    private int id;
    private String descripcion;
    private int pregunta;
    ArrayList<Pregunta> preguntas = new ArrayList<>();
    ArrayList<String> encuestaPregunta = new ArrayList<>();
    
    
    ConexionSql conexion = new ConexionSql();
    
    public Encuesta(int id, String descripcion) {
        
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getDescripcion() {
        Connection connection = conexion.conectar();

            if (connection != null) {
                try {
                    // Crear una consulta preparada con un parámetro
                    String sql = "SELECT * FROM pregunta;";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                        // Ejecutar la consulta y obtener los resultados
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Iterar sobre los resultados y mostrar la información
                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                String descripcion = resultSet.getString("descripcion");
                                int encuesta = resultSet.getInt("encuesta");
                                Pregunta pregunta = new Pregunta(id, descripcion, encuesta);
                                this.preguntas.add(pregunta);
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
        this.encuestaPregunta.add(this.descripcion);
        for(Pregunta p : preguntas){
            this.encuestaPregunta.add(p.getDescripcion());
            
        }
        return this.encuestaPregunta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}