
package com.hernan.ppai.dominio;

import com.hernan.ppai.sql.ConexionSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class SuperObjetoPersistente {
    ConexionSql conexion = new ConexionSql();
    
    private ArrayList<Pregunta> preguntas = new ArrayList<>();
    private ArrayList<CambioEstado> listaCambioEstado = new ArrayList<>();
    private Cliente clienteLlamada;
    private ArrayList<CambioEstado> listaCambioEstado2 = new ArrayList<>();
    private ArrayList<String> respuestasCliente = new ArrayList<>();
    private ArrayList<RespuestaCliente> todasRespuestasCliente = new ArrayList<>();
    private ArrayList<Llamada> listaLlamadas = new ArrayList<>();
    private Llamada seleccionLlamada;
    private ArrayList<Encuesta> listaEncuestas = new ArrayList<>();
    
    public ArrayList<Pregunta> consultaPreguntas(){
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
        return this.preguntas;
    }
    
    public String consultaNombreEstado(int id){
        Connection connection = conexion.conectar();
        String nombre = null;

            if (connection != null) {
                try {
                    // Crear una consulta preparada con un parámetro
                    String sql = "SELECT nombre FROM estado WHERE id = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        // Establecer el valor del parámetro
                        preparedStatement.setInt(1, id);  // Reemplaza tuId con el valor real del ID

                        // Ejecutar la consulta y obtener los resultados
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Iterar sobre los resultados y mostrar la información
                            while (resultSet.next()) {
                                nombre = resultSet.getString("nombre");
                                
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
        return nombre; 
    }
    
    public ArrayList<CambioEstado> consultaEstadoInicial(int identificador){
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
        return this.listaCambioEstado;
    
    }
    
    public Cliente consultaNombreClienteLlamada(int cliente){
            Connection connection = conexion.conectar();
            if (connection != null) {
                try {
                    // Crear una consulta preparada con un parámetro
                    String sql = "SELECT * FROM cliente WHERE id = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        // Establecer el valor del parámetro
                        preparedStatement.setInt(1, cliente);  // Reemplaza tuId con el valor real del ID

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
        return this.clienteLlamada;
    }
    
    public ArrayList<CambioEstado> consultaEstadoActual(int identificador){
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
        return this.listaCambioEstado2;
    }
    
    public ArrayList<String> consultaDescripcionRespuesta(int id){
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
    
    public ArrayList<Llamada> consultaLlamadaConEncuesta(){
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
        return this.listaLlamadas;
    }
    
    
    public Llamada consultaBuscarDatosLlamada(int llamadaSeleccionada){
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
        return this.seleccionLlamada;
    }
    
    public ArrayList<RespuestaCliente> consultaTodasRespuestasCliente(){
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
                                this.todasRespuestasCliente.add(new RespuestaCliente(id, descripcion, llamada));
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
        return this.todasRespuestasCliente;
    }
    
    public ArrayList<Encuesta> consultaBuscarDescripcionEncuesta(){
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
        return this.listaEncuestas;
    }
}
