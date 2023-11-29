
package com.hernan.ppai.dominio;

import java.util.ArrayList;

public interface IIterador {
    
    public void primero();
    public void siguiente();
    public Object actual(ArrayList<Object> filtros);
    public boolean haTerminado();
    public boolean cumpleFiltro(ArrayList<Object> filtros, Object objetoActual,int id);
}
