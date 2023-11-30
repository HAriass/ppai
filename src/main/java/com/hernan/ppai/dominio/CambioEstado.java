package com.hernan.ppai.dominio;

import java.sql.Timestamp;

public class CambioEstado {
    
    private Timestamp fechaHoraInicio;
    private int llamada;
    private int id;
    private int estado;

    public CambioEstado(Timestamp fechaHoraInicio, int llamada, int id, int estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.llamada = llamada;
        this.id = id;
        this.estado = estado;
    }


    
    

    public Timestamp getFechaHoraInicio(){
        return fechaHoraInicio;
    }

    public String getNombreEstado() {
        Estado estado1 = new Estado();
        return estado1.getNombre(this.estado);
    }
}