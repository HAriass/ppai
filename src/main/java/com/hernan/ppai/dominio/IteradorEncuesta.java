
package com.hernan.ppai.dominio;

import java.util.ArrayList;

public class IteradorEncuesta implements IIterador<Encuesta>{

    private int indice;
    private ArrayList<Encuesta> listaEncuestas;
    

    public IteradorEncuesta(ArrayList<Encuesta> listaEncuestas) {
        this.listaEncuestas = listaEncuestas;
        
    }

    @Override
    public void primero() {
        this.indice = 0;
    }

    @Override
    public void siguiente() {
        this.indice++;
    }

    @Override
    public Encuesta actual(ArrayList<Object> filtros) {
        Encuesta encuestaActual = listaEncuestas.get(indice);
        int id = indice + 1;
         boolean siCumple = this.cumpleFiltro(filtros,encuestaActual,id);
        
        if (siCumple) {
            return encuestaActual;
        }
        return null;
    }

    @Override
    public boolean haTerminado() {
        return indice >= this.listaEncuestas.size();
    }

    @Override
    public boolean cumpleFiltro(ArrayList<Object> filtros, Object objetoActual, int id) {
        return true;
    }
    
}
