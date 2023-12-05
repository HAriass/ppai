package com.hernan.ppai.dominio;

import java.util.ArrayList;

public class Encuesta extends SuperObjetoPersistente{
    private SuperObjetoPersistente persistencia = new SuperObjetoPersistente();
    private int id;
    private String descripcion;
    private int pregunta;
    ArrayList<Pregunta> preguntas = new ArrayList<>();
    ArrayList<String> encuestaPregunta = new ArrayList<>();
    
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
        this.preguntas = this.persistencia.consultaPreguntas();
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
