package com.hernan.ppai.dominio;

import java.util.ArrayList;
import java.util.Date;

public class IteradorLlamada implements IIterador {

    private ArrayList<Llamada> llamadas; 

    public ArrayList<Llamada> getLlamadas() {
        return llamadas;
    }
 
    private int indice;

    public IteradorLlamada(ArrayList<Llamada> llamadas) {
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

    public Llamada actual(ArrayList<Object> filtros) {
        Llamada llamadaActual = llamadas.get(indice); 
        int id = indice+1;
        boolean siCumple = this.cumpleFiltro(filtros,llamadaActual,id);
        if (siCumple == true){
            return llamadaActual;
        }
        return null;
    }

    @Override
    public boolean haTerminado() {
        return indice >= llamadas.size();
    }

    public boolean cumpleFiltro(ArrayList<Object> filtros, Object llamadaActual, int id) {
        if (llamadaActual instanceof Llamada) {
            // Verificar si la llamada actual cumple con el período
            boolean cumplePeriodo = ((Llamada) llamadaActual).esDePeriodo((Date) filtros.get(0), (Date) filtros.get(1), id);

            // Verificar si la llamada actual tiene encuesta respondida
            boolean encuestaRespondida = ((Llamada) llamadaActual).tieneEncuestaRespondida();

            // Retornar true solo si cumple con ambos criterios
            return cumplePeriodo && encuestaRespondida;
        }
        // Manejar el caso en que llamadaActual no sea una instancia de Llamada
        return false;
    }




}
