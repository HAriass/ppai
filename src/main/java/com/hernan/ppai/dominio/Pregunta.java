package com.hernan.ppai.dominio;



public class Pregunta {
    
    private int id;
    private String descripcion;
    private int encuesta;

    public Pregunta(int id, String descripcion, int encuesta) {
        this.id = id;
        this.descripcion = descripcion;
        this.encuesta = encuesta;
    }
    

    
    public String getDescripcion(){
        
        return descripcion;
    }
}
