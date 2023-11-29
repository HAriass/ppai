package com.hernan.ppai.dominio;

import java.util.ArrayList;

public class IteradorLlamada implements IIterador {

    private ArrayList<Object> llamadas; 

    public ArrayList<Object> getLlamadas() {
        return llamadas;
    }
 

    private int indice;

    public IteradorLlamada(ArrayList<Object> llamadas) {
        this.llamadas = llamadas;
        this.indice = 0;
    }

    @Override
    public void primero() {
        indice = 0;
    }

    @Override
    public void siguiente() {
        indice++;
    }

    @Override
    public Object actual() {
        if (haTerminado()) {
            return null;
        }
        return llamadas.get(indice); 
    }

    @Override
    public boolean haTerminado() {
        return indice >= llamadas.size();
    }

    @Override
    public boolean cumpleFiltro(ArrayList<Object> filtros) {
        this.actual().
        return true;
    }

}
