
package com.hernan.ppai.dominio;

import java.util.ArrayList;


public class IteradorRespuesta implements IIterador<RespuestaCliente>{


    private int indice;
    private ArrayList<RespuestaCliente> respuestas;

    public IteradorRespuesta(ArrayList<RespuestaCliente> respuestas) {
        this.respuestas = respuestas;
        this.indice = 0;
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
    public RespuestaCliente actual(ArrayList<Object> filtros ) {
        RespuestaCliente respuestaActual = respuestas.get(indice);
        int id = indice + 1;
         boolean siCumple = this.cumpleFiltro(filtros,respuestaActual,id);
        
        if (siCumple) {
            return respuestaActual;
        }
        return null;
    }

    @Override
    public boolean haTerminado() {
        return indice >= respuestas.size();
    }

    @Override
    public boolean cumpleFiltro(ArrayList<Object> filtros, Object respuestaActual, int id ) {
        if (respuestaActual instanceof RespuestaCliente){
            ((RespuestaCliente) respuestaActual).esDeLlamada(filtros);
        }
        return true;
    }


    
}
