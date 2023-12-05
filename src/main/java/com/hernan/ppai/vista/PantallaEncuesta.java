
package com.hernan.ppai.vista;

import com.hernan.ppai.dominio.Llamada;
import com.hernan.ppai.dominio.RespuestaCliente;
import com.hernan.ppai.gestor.GestorEncuesta;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;

public class PantallaEncuesta extends javax.swing.JFrame {
    
    //Atributos
    GestorEncuesta gestor;
    ConsultarEncuestaVista consultarEncuestaVista = new ConsultarEncuestaVista();
    private Date fechaInicio;
    private Date fechaFin;
    private int llamadaSeleccionada;
    private Object formatoImpresion;
    
    //Constructor
    public PantallaEncuesta() {
        initComponents();
        this.personalizarInterfaz();
        this.habilitarPantalla();
    }

    private void personalizarInterfaz() {
    // Personalizar colores y estilos
    Color azulSuave = new Color(2, 117, 247);  // Un tono suave de azul
    Color negro = new Color(0, 0, 0);  // Un tono suave de azul
    Color grisOscuro = new Color(247, 247, 247);  // Un gris oscuro para el fondo
    Color textoBlanco = Color.WHITE;

    // Configurar colores de fondo
    this.getContentPane().setBackground(grisOscuro);
    // Configurar colores de texto
    jLabel1.setForeground(negro);

    // Configurar colores de botones
    btnconsultarencuesta.setBackground(azulSuave);
    // Configurar colores de texto en botones
    btnconsultarencuesta.setForeground(textoBlanco);

    int radioRedondeo = 10;

    // Configurar redondeo para los botones
    btnconsultarencuesta.setBorderPainted(false);
    btnconsultarencuesta.setFocusPainted(false);
    btnconsultarencuesta.setContentAreaFilled(false);
    btnconsultarencuesta.setOpaque(true);
    btnconsultarencuesta.setBackground(azulSuave);
    btnconsultarencuesta.setForeground(textoBlanco);

    // Agregar margen negro
    int margen = 2; // Puedes ajustar el tamaño del margen según tus preferencias
    btnconsultarencuesta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(azulSuave, 2), // Borde azul
            BorderFactory.createEmptyBorder(margen, margen, margen, margen) // Margen negro
    ));
    btnconsultarencuesta.setPreferredSize(new Dimension(150, 40));
}


    // Metodos netbeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnconsultarencuesta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta Encuestas");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Sistema de consulta de encuestas IVR");

        btnconsultarencuesta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnconsultarencuesta.setText("Consultar Encuesta");
        btnconsultarencuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarencuestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnconsultarencuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(btnconsultarencuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultarencuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarencuestaActionPerformed
       // ConsultarEncuestaVista vistaConsultar = new ConsultarEncuestaVista(); // Esto no es necesario
        consultarEncuestaVista.setPantallaEncuesta(this);  // Establecer la instancia correcta
        consultarEncuestaVista.setVisible(true);
        consultarEncuestaVista.setLocationRelativeTo(null);
        gestor.consultarEncuesta();
        this.dispose();
    }//GEN-LAST:event_btnconsultarencuestaActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsultarencuesta;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
    
    //Metodos propios
    public void habilitarPantalla(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }
    public void solicitarPeriodoLlamada() {
        this.tomarFechaInicioPeriodo();
        this.tomarFechaFinPeriodo();
    }

    public void tomarFechaInicioPeriodo() {
        this.fechaInicio =  consultarEncuestaVista.getFechainicio();
    }

    public void tomarFechaFinPeriodo() {
        this.fechaFin = consultarEncuestaVista.getFechafin();
        this.llamarMetodo();
    }

    public void setGestor(GestorEncuesta gestorEncuesta) {
        this.gestor = gestorEncuesta;
    }

    private void llamarMetodo() {
        this.gestor.tomarPeriodoLlamada(this.fechaInicio, this.fechaFin);

    }
    public void setConsultarEncuestaVista(ConsultarEncuestaVista consultarEncuestaVista) {
        this.consultarEncuestaVista = consultarEncuestaVista;
    }
    public void mostrarDatosLlamada(ArrayList<Llamada> llamadasFiltradas){
        this.consultarEncuestaVista.mostrarDatosLlamada(llamadasFiltradas);
        this.tomarSeleccionLlamada();
        
    }
    
    public void tomarSeleccionLlamada() {
        if(consultarEncuestaVista.tomarSeleccionLlamada()!=0){
            this.llamadaSeleccionada = consultarEncuestaVista.tomarSeleccionLlamada();
            gestor.tomarSeleccionLlamada(this.llamadaSeleccionada);
        }
        
    }

    public void mostrarDatosEncuestaLlamada(String nombreClienteYEstado, int duracionLlamadaSeleccionada, ArrayList<String> respuestasCliente, ArrayList<String> encuestaPregunta) {
        this.consultarEncuestaVista.mostrarDatosEncuesta(nombreClienteYEstado,duracionLlamadaSeleccionada,respuestasCliente,encuestaPregunta);
    }

    public void mostrarFormatoImpresionPSeleccion() {
        if (this.consultarEncuestaVista.mostrarFormatosImpresionPSeleccion() != null){
            this.formatoImpresion = this.consultarEncuestaVista.mostrarFormatosImpresionPSeleccion();
            this.gestor.tomarFormato(this.formatoImpresion);
        }
        
    }

}
