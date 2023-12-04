package com.hernan.ppai.dominio;

import java.util.ArrayList;

public interface IAgregado<T extends Object> {
    IIterador<T> crearIterador(ArrayList<T> listaElementos);
}

