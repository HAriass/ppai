package com.hernan.ppai.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionSql {
    Connection conn = null;
    String url = "jdbc:postgresql://127.0.0.1/ppai_disenio";
    String usuario = "postgres";
    String clave = "postgres";
    
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,usuario, clave);
            System.out.println("conexion exitosa");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al conectar" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    return conn;
    }
}
