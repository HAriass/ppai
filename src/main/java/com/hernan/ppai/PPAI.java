
package com.hernan.ppai;

import com.hernan.ppai.gestor.GestorEncuesta;
import com.hernan.ppai.vista.PantallaEncuesta;


public class PPAI {

    public static void main(String[] args) {
        PantallaEncuesta pantallaEncuesta = new PantallaEncuesta();
        GestorEncuesta gestorEncuesta = new GestorEncuesta();
        pantallaEncuesta.setGestor(gestorEncuesta);
        gestorEncuesta.setPantalla(pantallaEncuesta);  
    }
}
