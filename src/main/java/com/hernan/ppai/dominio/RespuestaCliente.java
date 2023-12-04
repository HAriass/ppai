package com.hernan.ppai.dominio;

import java.util.ArrayList;

public class RespuestaCliente {
    private int id;
    private String descripcion;
    private int llamada;
    private RespuestaPosible respuestaPosible = new RespuestaPosible();
    

    public RespuestaCliente(int id, String descripcion, int llamada) {
        this.id = id;
        this.descripcion = descripcion;
        this.llamada = llamada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getLlamada() {
        return llamada;
    }

    public void setLlamada(int llamada) {
        this.llamada = llamada;
    }
    
    public boolean esDeLlamada(ArrayList<Object> filtros) {
        if (filtros.get(0) instanceof Integer) {
            int filtroId = (int) filtros.get(0);
            return this.id == filtroId;
        } else {
            
            return false;
        }
    }

    public ArrayList<String> getRespuestaSeleccionada(int id) {
        return this.respuestaPosible.getDescripcionRespuestas(id);
    }


}
