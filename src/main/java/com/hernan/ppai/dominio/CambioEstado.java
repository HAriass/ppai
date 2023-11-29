package com.hernan.ppai.dominio;

import java.sql.Timestamp;
import java.util.Date;

public class CambioEstado {
    
    private Timestamp fechaHoraInicio;
    private int llamada;
    private int id;

    public CambioEstado(Timestamp fechaHoraInicio, int llamada, int id) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.llamada = llamada;
        this.id = id;
    }
    
    

    public Timestamp getFechaHoraInicio(){
        return fechaHoraInicio;
    }
}