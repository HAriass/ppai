package com.hernan.ppai.dominio;

import com.hernan.ppai.sql.ConexionSql;
import java.util.ArrayList;


public class RespuestaPosible extends SuperObjetoPersistente{
    private SuperObjetoPersistente persistencia = new SuperObjetoPersistente();
    ConexionSql conexion = new ConexionSql();
    private ArrayList<String> respuestasCliente = new ArrayList<>();

    public ArrayList<String> getDescripcionRespuestas(int id) {
        
        this.respuestasCliente = this.persistencia.consultaDescripcionRespuesta(id);
        return this.respuestasCliente;
    }


}
