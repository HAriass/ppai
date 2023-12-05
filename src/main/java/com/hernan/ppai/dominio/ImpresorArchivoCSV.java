package com.hernan.ppai.dominio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ImpresorArchivoCSV {
    
    private static ImpresorArchivoCSV instancia;

    // Haciendo el constructor privado para evitar la creación de instancias fuera de la clase
    private ImpresorArchivoCSV() {
        // Constructor privado para evitar la creación directa de instancias
    }

    // Método para obtener la instancia única del Singleton
    public static ImpresorArchivoCSV getInstancia() {
        if (instancia == null) {
            // Si la instancia es nula, crea una nueva instancia
            instancia = new ImpresorArchivoCSV();
        }
        // Devuelve la instancia existente o recién creada
        return instancia;
    }

    // Método para imprimir los datos en un archivo CSV
    public void imprimir(String nombreClienteYEstado, int duracionLlamadaSeleccionada,
                         ArrayList<String> respuestasDelCliente, ArrayList<String> encuestaPregunta) {
        // Especifica la ruta completa del archivo
        String rutaCompleta = "C:\\Users\\coser\\Desktop\\";
        String nombreArchivo = rutaCompleta + "resultado_encuesta.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            // Escribir datos
            int indice = 1;

            // Campos "Nombre del Cliente y Estado" y "Duración de la Llamada"
            writer.println(nombreClienteYEstado);
            writer.println("Duración de la Llamada, " + duracionLlamadaSeleccionada+"seg."+'\n');

            // Título general de la encuesta
            writer.println(encuestaPregunta.get(0)+'\n');

            // Preguntas específicas de la encuesta intercaladas con respuestas
            for (int i = 1; i < encuestaPregunta.size(); i++) {
                writer.println(indice++ + ") Pregunta de la Encuesta, " + encuestaPregunta.get(i));
                writer.println(indice++ + ") Respuesta del Cliente, " + respuestasDelCliente.get(i - 1)+'\n');
            }

            System.out.println("Archivo CSV creado con éxito: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
