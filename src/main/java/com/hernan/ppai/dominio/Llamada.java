package com.hernan.ppai.dominio;

import java.util.Date;

public class Llamada {
    private int id;
    private int duracion;
    private boolean encuestaEnviada;

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
    
    
    
    public void esDePeriodo(Date fechaInicio, Date fechaFin,Llamada LlamadaActual){
        this.determinarEstadoInicial(fechaInicio, fechaFin,LlamadaActual);

    }

    public void determinarEstadoInicial(Date fechaInicio, Date fechaFin, Llamada LlamadaActual) {
        
    }


} 



