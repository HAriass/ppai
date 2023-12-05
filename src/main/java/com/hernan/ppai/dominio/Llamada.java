package com.hernan.ppai.dominio;

import com.hernan.ppai.gestor.GestorEncuesta;
import java.util.Date;
import com.hernan.ppai.sql.ConexionSql;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Llamada extends SuperObjetoPersistente implements IAgregado<RespuestaCliente> {
    private SuperObjetoPersistente persistencia = new SuperObjetoPersistente();
    private int id;
    private int duracion;
    private boolean encuestaEnviada;
    private ArrayList<CambioEstado> listaCambioEstado = new ArrayList<>();
    private int cliente;
    private Cliente clienteLlamada;
    private String nombreClienteLlamada;
    private ArrayList<CambioEstado> listaCambioEstado2 = new ArrayList<>();
    private String estadoActual;
    private ArrayList<Object> filtros = new ArrayList<>();
    private GestorEncuesta gestor = new GestorEncuesta();
    
    ConexionSql conexion = new ConexionSql();
    private ArrayList<RespuestaCliente> respuestasCliente;
    private IteradorRespuesta iteradorRespuesta;
    private ArrayList<String> listaRespuestasCliente;
    

    @Override
    public String toString() {
        return "Llamada " + id + ' ';
    }

    public Llamada(int id, int duracion, boolean encuestaEnviada, int cliente) {
        this.id = id;
        this.duracion = duracion;
        this.encuestaEnviada = encuestaEnviada;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean tieneEncuestaRespondida() {
        return encuestaEnviada;
    }

    
    
    
    public boolean esDePeriodo(Date fechaInicio, Date fechaFin,int identificador){
        return this.determinarEstadoInicial(fechaInicio, fechaFin,identificador);

    }

    public boolean determinarEstadoInicial(Date fechaInicio, Date fechaFin, int identificador) {

        this.listaCambioEstado = this.persistencia.consultaEstadoInicial(identificador);

        Timestamp fechaMasTemprana = null;

        // Verificar si listaCambioEstado no está vacía antes de intentar obtener la fechaMasTemprana
        if (!listaCambioEstado.isEmpty()) {
            for (CambioEstado cambioEstado : listaCambioEstado) {
                Timestamp fechaActual = (Timestamp) cambioEstado.getFechaHoraInicio();
                // Si la fechaMasTemprana aún no se ha establecido o la fechaActual es más temprana
                if (fechaMasTemprana == null || fechaActual.before(fechaMasTemprana)) {
                    fechaMasTemprana = fechaActual;
                }
            }
        }

        // Verificar si fechaMasTemprana es null antes de intentar usarla
        if (fechaMasTemprana != null) {
            // Convertir Timestamp a Date
            Date fechaMasTempranaDate = new Date(fechaMasTemprana.getTime());

            // Verificar si fechaMasTempranaDate está entre fechaInicio y fechaFin
            return fechaMasTempranaDate.after(fechaInicio) && fechaMasTempranaDate.before(fechaFin);
        } else {
            // Manejar el caso cuando fechaMasTemprana es null
            return false;
        }
    }

    public String getNombreClienteDeLlamada() {
            this.clienteLlamada = this.persistencia.consultaNombreClienteLlamada(this.cliente);
            this. nombreClienteLlamada = this.clienteLlamada.getNombre();
            this.estadoActual = this.determinarEstadoActual();
            return "Nombre cliente: "+ nombreClienteLlamada+'\n'+"Estado de la llamada: " +estadoActual;
        
    }

    private String determinarEstadoActual() {
        
            this.listaCambioEstado2 = this.persistencia.consultaEstadoInicial(this.id);
            
            CambioEstado cambioEstadoConFechaMasReciente = null;

            for (CambioEstado cambioEstado2 : listaCambioEstado2) {
                Timestamp fechaActual = cambioEstado2.getFechaHoraInicio();

                // Si cambioEstadoConFechaMasReciente es nulo o la fechaActual es más reciente
                if (cambioEstadoConFechaMasReciente == null || fechaActual.after(cambioEstadoConFechaMasReciente.getFechaHoraInicio())) {
                    cambioEstadoConFechaMasReciente = cambioEstado2;
                }
            }

            return cambioEstadoConFechaMasReciente.getNombreEstado();
    }

    @Override
    public IIterador<RespuestaCliente> crearIterador(ArrayList<RespuestaCliente> listaElementos) {
        IteradorRespuesta iteradorRespuesta = new IteradorRespuesta(listaElementos);
        return iteradorRespuesta;
    }

    public ArrayList<String> getRespuestas(ArrayList<RespuestaCliente> respuestasCliente, int idLlamada) {
        this.filtros.add(idLlamada);
        this.respuestasCliente = respuestasCliente;
        this.iteradorRespuesta = (IteradorRespuesta) this.crearIterador(this.respuestasCliente);
        
        this.iteradorRespuesta.primero();
        
        while (!iteradorRespuesta.haTerminado()) {            
            RespuestaCliente respuestaActual = iteradorRespuesta.actual(filtros);
            this.listaRespuestasCliente = respuestaActual.getRespuestaSeleccionada(idLlamada);
            this.iteradorRespuesta.siguiente();
        }
        return this.listaRespuestasCliente;
    }

} 



