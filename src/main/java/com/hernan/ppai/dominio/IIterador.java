
package com.hernan.ppai.dominio;

import java.util.ArrayList;

public interface IIterador<T> {
    
    public void primero();
    public void siguiente();
    public T actual(ArrayList<Object> filtros);
    public boolean haTerminado();
    public boolean cumpleFiltro(ArrayList<Object> filtros, Object objetoActual,int id);
}
