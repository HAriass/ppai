package com.hernan.ppai.gestor;

import java.util.Date;
import vista.ConsultarEncuestaVista;
import vista.PantallaEncuesta;

public class GestorEncuesta {
    
    PantallaEncuesta pantalla;
    private Date fechaInicio;
    private Date fechaFin;

    public void consultarEncuesta() {
        this.buscarPeriodo();
    }
    public void buscarPeriodo(){
        pantalla.solicitarPeriodoLlamada();
    }
    
    public void tomarPeriodoLlamada(Date fechaInicio, Date fechaFin) {
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.buscarLlamadaConEncuesta();
    }
    
    public void buscarLlamadaConEncuesta(){
        if (fechaInicio!=null && fechaFin!=null){
            System.out.println(fechaInicio);
            System.out.println(fechaFin);
        }
    }
    
    public void setPantalla(PantallaEncuesta pantallaEncuesta) {
        this.pantalla = pantallaEncuesta;
    }
    public void setConsultarEncuestaVista(ConsultarEncuestaVista consultarEncuestaVista) {
        this.pantalla.setConsultarEncuestaVista(consultarEncuestaVista);
    }
    
}