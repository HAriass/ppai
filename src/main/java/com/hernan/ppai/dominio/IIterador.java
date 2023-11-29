
package com.hernan.ppai.dominio;

public interface IIterador {
    
    public void primero();
    public void siguiente();
    public Object actual();
    public boolean haTerminado();
    public boolean cumpleFiltro();
}
