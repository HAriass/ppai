
package vista;

import com.hernan.ppai.gestor.GestorEncuesta;
import java.util.Date;

public class PantallaEncuesta extends javax.swing.JFrame {
    
    //Atributos
    GestorEncuesta gestor;
    ConsultarEncuestaVista consultarEncuestaVista = new ConsultarEncuestaVista();
    private Date fechaInicio;
    private Date fechaFin;
    
    //Constructor
    public PantallaEncuesta() {
        initComponents();
    }

    
    // Metodos netbeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnconsultarencuesta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sistema de consulta de encuestas IVR");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnconsultarencuesta)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnconsultarencuesta)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultarencuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarencuestaActionPerformed
        this.habilitarPantalla();
    }//GEN-LAST:event_btnconsultarencuestaActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaEncuesta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsultarencuesta;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
    
    //Metodos propios
    public void habilitarPantalla(){
        gestor.consultarEncuesta();
    }
    public void solicitarPeriodoLlamada() {
        this.tomarFechaInicioPeriodo();
        this.tomarFechaFinPeriodo();
        this.gestor.tomarPeriodoLlamada(this.fechaInicio, this.fechaFin);
    }

    public void tomarFechaInicioPeriodo() {
        this.fechaInicio =  consultarEncuestaVista.getFechainicio();
    }

    public void tomarFechaFinPeriodo() {
        this.fechaFin = consultarEncuestaVista.getFechafin();
        
    }

    public void setGestor(GestorEncuesta gestorEncuesta) {
        this.gestor = gestorEncuesta;
    }
}
