package com.hernan.ppai.dominio;

import com.hernan.ppai.sql.ConexionSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


public class RespuestaPosible {
    ConexionSql conexion = new ConexionSql();
    private ArrayList<String> respuestasCliente = new ArrayList<>();

    public ArrayList<String> getDescripcionRespuestas(int id) {
        
        Connection connection = conexion.conectar();
            this.respuestasCliente.clear();
            if (connection != null) {
                try {
                    // Crear una consulta preparada con un parámetro
                    String sql = "SELECT * FROM respuestaCliente WHERE llamada = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        // Establecer el valor del parámetro
                        preparedStatement.setInt(1, id);  // Reemplaza tuId con el valor real del ID

                        // Ejecutar la consulta y obtener los resultados
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Iterar sobre los resultados y mostrar la información
                            while (resultSet.next()) {
                                String descripcion = resultSet.getString("descripcion");
                                this.respuestasCliente.add(descripcion);
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


}
