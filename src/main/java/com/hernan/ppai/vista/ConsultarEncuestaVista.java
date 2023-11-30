
package com.hernan.ppai.vista;

import com.hernan.ppai.dominio.Llamada;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;

public class ConsultarEncuestaVista extends javax.swing.JFrame {
    //Atributos
    PantallaEncuesta pantallaEncuesta;
    private Date fechaInicio;
    private Date fechaFin;
    
    
    //Metodos netbeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fechainicio = new com.toedter.calendar.JDateChooser();
        fechafin = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnconsultar = new javax.swing.JButton();
        cbllamadafiltrada = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtllamadasfiltradas = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha Inicio");

        jLabel2.setText("Fecha Fin");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Ingrese Periodo");

        btnconsultar.setText("Consultar");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        cbllamadafiltrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbllamadafiltradaActionPerformed(evt);
            }
        });

        txtllamadasfiltradas.setColumns(20);
        txtllamadasfiltradas.setRows(5);
        jScrollPane2.setViewportView(txtllamadasfiltradas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbllamadafiltrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(fechafin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(btnconsultar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(cbllamadafiltrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        txtllamadasfiltradas.setText("");
        cbllamadafiltrada.removeAllItems();
        if (pantallaEncuesta != null) {
            this.fechaInicio = fechainicio.getDate();
            this.fechaFin = fechafin.getDate();

            pantallaEncuesta.tomarFechaInicioPeriodo();
            pantallaEncuesta.tomarFechaFinPeriodo();
            
        } else {
            // Manejar la situación donde pantallaEncuesta es null
            System.out.println("Error: pantallaEncuesta es null");
        }
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void cbllamadafiltradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbllamadafiltradaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbllamadafiltradaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsultar;
    private javax.swing.JComboBox<String> cbllamadafiltrada;
    private com.toedter.calendar.JDateChooser fechafin;
    private com.toedter.calendar.JDateChooser fechainicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtllamadasfiltradas;
    // End of variables declaration//GEN-END:variables

    //Metodos Propios
    public ConsultarEncuestaVista() {
        initComponents();
        
    }

    public Date getFechafin() {
        return fechaFin;
    }

    public Date getFechainicio() {
        return fechaInicio;
    }

    void setPantallaEncuesta(PantallaEncuesta pantallaEncuesta) {
        this.pantallaEncuesta = pantallaEncuesta;
    }
    
    public void mostrarDatosLlamada(ArrayList<Llamada> llamadasFiltradas) {
        // Limpiar el JComboBox antes de agregar nuevos elementos
        cbllamadafiltrada.removeAllItems();

        for (Llamada l : llamadasFiltradas){
            int llamadaId = l.getId();
            cbllamadafiltrada.addItem(String.valueOf(llamadaId));
            txtllamadasfiltradas.append(l.toString() + "\n");
        }
    }

    public int tomarSeleccionLlamada() {
        // Obtener el índice seleccionado en el JComboBox
        int selectedIndex = cbllamadafiltrada.getSelectedIndex();

        // Validar si se seleccionó algún elemento
        if (selectedIndex != -1) {
            // Obtener el valor seleccionado (en este caso, el ID de la llamada)
            int llamadaSeleccionada = Integer.parseInt((String) cbllamadafiltrada.getSelectedItem());

            // Realizar las operaciones necesarias con la llamada seleccionada
            System.out.println("Llamada seleccionada: " + llamadaSeleccionada);

            return llamadaSeleccionada;
        } else {
            // Manejar la situación donde no se ha seleccionado ningún elemento
            System.out.println("Ninguna llamada seleccionada");
            return -1; // O cualquier otro valor que indique que no se seleccionó ninguna llamada
        }
    }               


    
    
}
