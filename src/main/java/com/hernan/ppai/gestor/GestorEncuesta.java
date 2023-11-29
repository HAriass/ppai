package com.hernan.ppai.gestor;

import java.util.Date;
import vista.PantallaEncuesta;

public class GestorEncuesta {
    
    PantallaEncuesta pantalla;

    public void consultarEncuesta() {
        this.buscarPeriodo();
    }
    public void buscarPeriodo(){
        pantalla.solicitarPeriodoLlamada();
    }
    
    public void tomarPeriodoLlamada(Date fechaInicio, Date fechaFin) {
        this.buscarLlamadaConEncuesta();
    }
    
    public void buscarLlamadaConEncuesta(){
        
    }

    public void setPantalla(PantallaEncuesta pantallaEncuesta) {
        this.pantalla = pantallaEncuesta;
    }
    
}