
package vista;


public class ViewMenuPrincipal extends javax.swing.JFrame {

    
    public ViewMenuPrincipal() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpVistaPrincipal = new javax.swing.JDesktopPane();
        jmbGeneral = new javax.swing.JMenuBar();
        jmAlumno = new javax.swing.JMenu();
        jmiAlumnos = new javax.swing.JMenuItem();
        jmMateria = new javax.swing.JMenu();
        jmiMaterias = new javax.swing.JMenuItem();
        jmAdministracion = new javax.swing.JMenu();
        jmiInscripcion = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmConsultas = new javax.swing.JMenu();
        jmiConsultas = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdpVistaPrincipalLayout = new javax.swing.GroupLayout(jdpVistaPrincipal);
        jdpVistaPrincipal.setLayout(jdpVistaPrincipalLayout);
        jdpVistaPrincipalLayout.setHorizontalGroup(
            jdpVistaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jdpVistaPrincipalLayout.setVerticalGroup(
            jdpVistaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        jmAlumno.setText("Alumno");

        jmiAlumnos.setText("Formulario de Alumnos");
        jmiAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAlumnosActionPerformed(evt);
            }
        });
        jmAlumno.add(jmiAlumnos);

        jmbGeneral.add(jmAlumno);

        jmMateria.setText("Materia");

        jmiMaterias.setText("Formulario de Materias");
        jmiMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMateriasActionPerformed(evt);
            }
        });
        jmMateria.add(jmiMaterias);

        jmbGeneral.add(jmMateria);

        jmAdministracion.setText("Administracion");

        jmiInscripcion.setText("Inscripciones");
        jmAdministracion.add(jmiInscripcion);

        jMenuItem1.setText("Cargar/Modificar Notas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmAdministracion.add(jMenuItem1);

        jmbGeneral.add(jmAdministracion);

        jmConsultas.setText("Consultas");

        jmiConsultas.setText("Alumnos por materia");
        jmConsultas.add(jmiConsultas);

        jmbGeneral.add(jmConsultas);

        jmSalir.setText("Salir");
        jmSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmSalirMouseClicked(evt);
            }
        });
        jmbGeneral.add(jmSalir);

        setJMenuBar(jmbGeneral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpVistaPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpVistaPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAlumnosActionPerformed
        // TODO add your handling code here:
       jdpVistaPrincipal.removeAll();
       jdpVistaPrincipal.repaint();
       ViewAlumno internalAlumno = new ViewAlumno();
       internalAlumno.setVisible(true);
       jdpVistaPrincipal.add(internalAlumno);
       jdpVistaPrincipal.moveToFront(internalAlumno);
    }//GEN-LAST:event_jmiAlumnosActionPerformed

    private void jmSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSalirMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jmSalirMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
       jdpVistaPrincipal.removeAll();
       jdpVistaPrincipal.repaint();
       ViewCargaNotas internalNotas = new ViewCargaNotas();
       internalNotas.setVisible(true);
       jdpVistaPrincipal.add(internalNotas);
       jdpVistaPrincipal.moveToFront(internalNotas);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMateriasActionPerformed
       jdpVistaPrincipal.removeAll();
       jdpVistaPrincipal.repaint();
       ViewMateria internalMateria = new ViewMateria();
       internalMateria.setVisible(true);
       jdpVistaPrincipal.add(internalMateria);
       jdpVistaPrincipal.moveToFront(internalMateria);
    }//GEN-LAST:event_jmiMateriasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JDesktopPane jdpVistaPrincipal;
    private javax.swing.JMenu jmAdministracion;
    private javax.swing.JMenu jmAlumno;
    private javax.swing.JMenu jmConsultas;
    private javax.swing.JMenu jmMateria;
    private javax.swing.JMenu jmSalir;
    private javax.swing.JMenuBar jmbGeneral;
    private javax.swing.JMenuItem jmiAlumnos;
    private javax.swing.JMenuItem jmiConsultas;
    private javax.swing.JMenuItem jmiInscripcion;
    private javax.swing.JMenuItem jmiMaterias;
    // End of variables declaration//GEN-END:variables
}
