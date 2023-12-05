
package com.hernan.ppai.vista;

import com.hernan.ppai.dominio.Llamada;
import com.hernan.ppai.dominio.RespuestaCliente;
import java.util.ArrayList;
import java.util.Date;

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
        btnseleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdatos = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbformato = new javax.swing.JComboBox<>();
        btnformato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Fecha Inicio");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Fecha Fin");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        btnseleccionar.setText("Seleccionar");
        btnseleccionar.setEnabled(false);
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
            }
        });

        txtdatos.setColumns(20);
        txtdatos.setRows(5);
        jScrollPane1.setViewportView(txtdatos);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Selecciona llamada");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Datos llamada");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Formato de Impresion");

        cbformato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Impresion Papel", "CSV" }));
        cbformato.setSelectedIndex(-1);

        btnformato.setText("Imprimir");
        btnformato.setEnabled(false);
        btnformato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnformatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnseleccionar)
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(101, 101, 101)
                                    .addComponent(jLabel5)
                                    .addGap(103, 103, 103))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(73, 73, 73)
                                            .addComponent(jLabel3))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(23, 23, 23)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2))
                                            .addGap(44, 44, 44)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbllamadafiltrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(93, 93, 93)
                                    .addComponent(jLabel4))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(cbformato, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnformato, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(355, 355, 355)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(cbllamadafiltrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(fechafin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnconsultar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnseleccionar)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cbformato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnformato)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        this.btnseleccionar.setEnabled(true);
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

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed
        // TODO add your handling code here:
        this.btnformato.setEnabled(true);
        this.txtdatos.setText("");
        this.pantallaEncuesta.tomarSeleccionLlamada();
    }//GEN-LAST:event_btnseleccionarActionPerformed

    private void btnformatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnformatoActionPerformed

        this.pantallaEncuesta.mostrarFormatoImpresionPSeleccion();
    }//GEN-LAST:event_btnformatoActionPerformed
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btnformato;
    private javax.swing.JButton btnseleccionar;
    private javax.swing.JComboBox<String> cbformato;
    private javax.swing.JComboBox<String> cbllamadafiltrada;
    private com.toedter.calendar.JDateChooser fechafin;
    private com.toedter.calendar.JDateChooser fechainicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtdatos;
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
        cbllamadafiltrada.addItem(null);
        for (Llamada l : llamadasFiltradas){
            int llamadaId = l.getId();
            cbllamadafiltrada.addItem(String.valueOf(llamadaId));
            txtllamadasfiltradas.append(l.toString() + "\n");
        }
        
    }

    public int tomarSeleccionLlamada() {
            // Obtener el índice seleccionado en el JComboBox
        if(this.cbllamadafiltrada.getSelectedItem()!=null){
            int selectedIndex = cbllamadafiltrada.getSelectedIndex();
            // Validar si se seleccionó algún elemento
            if (selectedIndex != -1) {
                // Obtener el valor seleccionado (en este caso, el ID de la llamada)
                int llamadaSeleccionada = Integer.parseInt((String) cbllamadafiltrada.getSelectedItem());
                return llamadaSeleccionada;
            } else {
                // Manejar la situación donde no se ha seleccionado ningún elemento
                System.out.println("Ninguna llamada seleccionada");
                return -1; // O cualquier otro valor que indique que no se seleccionó ninguna llamada
            }
        }
        return 0;

    }               

    void mostrarDatosEncuesta(String nombreClienteYEstado, int duracionLlamadaSeleccionada, ArrayList<String> respuestasCliente, ArrayList<String> encuestaPregunta) {
        this.txtdatos.append(" "+nombreClienteYEstado);
        String duracion = String.valueOf(duracionLlamadaSeleccionada);
        this.txtdatos.append("\n");
        this.txtdatos.append("\n");
        this.txtdatos.append(" Duracion de llamada: "+duracion);
        this.txtdatos.append("\n");
        this.txtdatos.append("\n");
        
        // Mostrar la primera pregunta
        this.txtdatos.append(" "+encuestaPregunta.get(0));
        this.txtdatos.append("\n");

        // Mostrar las preguntas restantes con sus respuestas
        for (int i = 1; i < encuestaPregunta.size(); i++) {
            String pregunta = encuestaPregunta.get(i);
            String respuesta = respuestasCliente.get(i - 1); // Usar i - 1 para acceder a la respuesta correspondiente
            this.txtdatos.append(" ¿" + pregunta + "? - " + respuesta);
            this.txtdatos.append("\n");
        }

        this.txtdatos.append("\n");

    }

    public Object mostrarFormatosImpresionPSeleccion() {
        return this.tomarFormato();
    }

    private Object tomarFormato() {
        if(this.cbformato.getSelectedItem() != null){
            return this.cbformato.getSelectedItem();
        }
        return null;
    }


    
    
}
