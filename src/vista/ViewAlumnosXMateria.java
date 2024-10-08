/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import entidades.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import persistencia.*;

/**
 *
 * @author salon
 */
public final class ViewAlumnosXMateria extends javax.swing.JInternalFrame {
    private MateriaData matData=new MateriaData();
    private AlumnoData alumData = new AlumnoData();
    private InscripcionData inscData = new InscripcionData();
    
    
    
     private DefaultTableModel modeloTabla = new DefaultTableModel(){
         
          @Override
          public boolean isCellEditable(int fila, int columna) {
              
              return false;
          }
     };
    /**
     * Creates new form ViewAlumnosXMateria
     */
    public ViewAlumnosXMateria() {
        initComponents();
        
        cargarCombo();
        
        armarCabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSalir = new javax.swing.JButton();

        setTitle("Consulta Alumnos por Materia");

        jcbMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMateriasActionPerformed(evt);
            }
        });

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Apellido", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(jtAlumnos);

        jLabel1.setText("Seleccione una materia:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Listado de Alumnos por Materia");

        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSalir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(125, 125, 125)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jcbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSalir)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMateriasActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
         cargarDatos();
    }//GEN-LAST:event_jcbMateriasActionPerformed

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Materia> jcbMaterias;
    private javax.swing.JTable jtAlumnos;
    // End of variables declaration//GEN-END:variables
    
    public void cargarCombo(){
       List<Materia>materias= matData.listarMaterias();
       
       for(Materia m:materias){
           
           jcbMaterias.addItem(m);
       }
    }
    
     private void armarCabecera(){ 
        this.modeloTabla.addColumn("ID");
        this.modeloTabla.addColumn("DNI");
        this.modeloTabla.addColumn("Apellido");
        this.modeloTabla.addColumn("Nombre");
        jtAlumnos.setModel(modeloTabla);
    }
    
    public void cargarDatos(){
         Materia materiaSeleccionada = (Materia) jcbMaterias.getSelectedItem();
        int id = materiaSeleccionada.getIdMateria();
        List<Alumno> alumnos = inscData.obtenerAlumnosXMateria(id);
         for(Alumno a:alumnos){
            modeloTabla.addRow(new Object[]{a.getIdAlumno(),a.getDni(),a.getApellido(), a.getNombre()});
        }
        
    }
    private void borrarFilaTabla(){
        int indice=modeloTabla.getRowCount()-1;
        for(int i=indice;i>=0;i--){
            modeloTabla.removeRow(i);
        }
        
    }
}
