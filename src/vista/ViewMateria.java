
package vista;


public class ViewMateria extends javax.swing.JInternalFrame {

   
    public ViewMateria() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlCodigo = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlAño = new javax.swing.JLabel();
        jlEstado = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfAño = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();

        setTitle("Formulario de materias");

        jlCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlCodigo.setText("Código:");

        jlNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlNombre.setText("Nombre:");

        jlAño.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlAño.setText("Año:");

        jlEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlEstado.setText("Estado:");

        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });

        jrbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEstadoActionPerformed(evt);
            }
        });

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");

        jbEliminar.setText("Eliminar");

        jbSalir.setText("Salir");

        jbBuscar.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbNuevo)
                        .addGap(30, 30, 30)
                        .addComponent(jbGuardar)
                        .addGap(33, 33, 33)
                        .addComponent(jbEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlAño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbEstado)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbBuscar)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlAño)
                            .addComponent(jtfAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jlEstado))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlCodigo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jbBuscar)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jrbEstado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbNuevo)
                            .addComponent(jbGuardar)
                            .addComponent(jbEliminar))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbSalir)
                        .addGap(15, 15, 15))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbEstadoActionPerformed

    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlAño;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtfAño;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
