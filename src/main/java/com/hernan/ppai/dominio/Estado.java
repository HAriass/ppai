package com.hernan.ppai.dominio;


public class Estado extends SuperObjetoPersistente{
    private String nombre;
    private SuperObjetoPersistente persistencia = new SuperObjetoPersistente();
    
    public String getNombre(int id) {
        this.nombre = this.persistencia.consultaNombreEstado(id);
        return nombre;

    }
    


}
