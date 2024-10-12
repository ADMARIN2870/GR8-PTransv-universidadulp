/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import persistencia.*;
import entidades.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class ViewCargaNotas extends javax.swing.JInternalFrame {
  
      private MateriaData matData=new MateriaData();
    private AlumnoData alumData = new AlumnoData();
    private InscripcionData inscData = new InscripcionData();
    
   // private List <Materia> listaM;
   // private List <Alumno> listaA;
    /*
   private InscripcionData inscripcionData;
    private MateriaData mData;
    private AlumnoData aData;*/
     private DefaultTableModel modelo;
    //private DefaultTableModel modelo =new DefaultTableModel();
    private Object tuTextField;

    /**
     * Creates new form ViewCargaNotas
     */
    public ViewCargaNotas() {
        initComponents();
        modelo=new DefaultTableModel();
       /* aData =new AlumnoData();
        listaA= (ArrayList <Alumno>) aData.obtenerAlumnos();
        modelo=new DefaultTableModel();
       //Conexion con = new Conexion(); //ver q onda esto
        InscripcionData inscripcionData = new InscripcionData(con);
        mData= new MateriaData();*/
        
        cargaAlumnos();
        armarCabeceraTabla();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcbAlumnoData = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInscripcionData = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setTitle("Cargar Notas");

        jLabel1.setText("Seleccione Alumno :");

        jcbAlumnoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoDataActionPerformed(evt);
            }
        });

        jtInscripcionData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtInscripcionData);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbAlumnoData, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAlumnoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbAlumnoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoDataActionPerformed
        // TODO add your handling code here:
                   borrarFilaTabla();

        cargaDatosTabla();
    }//GEN-LAST:event_jcbAlumnoDataActionPerformed

    
    
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada= jtInscripcionData.getSelectedRow();
        if(filaSeleccionada != -1){
            Alumno a=(Alumno)jcbAlumnoData.getSelectedItem();
            int idMateria=(Integer) modelo.getValueAt(filaSeleccionada, 0);
            Object valorNota= modelo.getValueAt(filaSeleccionada,2);
            double nota = 0;
//            Double nota= (Double)modelo.getValueAt(filaSeleccionada, 2);
//            Integer nota= (Integer)modelo.getValueAt(filaSeleccionada, 2);
//            int nota= (int)modelo.getValueAt(filaSeleccionada, 2);
           
    if (valorNota != null && !valorNota.toString().trim().isEmpty()) {

    try{
                String notaSTR = valorNota.toString().trim();
               nota=Double.parseDouble(notaSTR);
               } catch (NumberFormatException e) {
            // Manejar el error si la conversión falla
            JOptionPane.showMessageDialog(null, "La nota ingresada no es valida.");
            return;
        }
        }
    
            
            Materia m= new Materia ();
            m.setIdMateria(idMateria);
          // Inscripcion ins= new Inscripcion(a, m, 0);
          // inscData.guardarInscripcion(ins);

           inscData.actualizarNota(a.getIdAlumno(), m.getIdMateria(), nota);
           borrarFilaTabla();
           
        }
        JOptionPane.showMessageDialog(null, "Nota actualizada correctamente.");
    }//GEN-LAST:event_jbGuardarActionPerformed

    
    
    
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumnoData;
    private javax.swing.JTable jtInscripcionData;
    // End of variables declaration//GEN-END:variables

    private void cargaAlumnos(){
                //List <Alumno> listaA= (ArrayList <Alumno>) alumData.obtenerAlumnos();
                List <Alumno> listaA= alumData.obtenerAlumnos();

        for(Alumno item : listaA){
            jcbAlumnoData.addItem(item);
        }
    }

    private void armarCabeceraTabla(){
        ArrayList <Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Codigo");
        filaCabecera.add("Nombre");
        filaCabecera.add("Nota");
        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jtInscripcionData.setModel(modelo);


    }
    
    private void cargaDatosTabla(){
                  // borrarFilaTabla();

        Alumno selec =(Alumno) jcbAlumnoData.getSelectedItem();
        int id =selec.getIdAlumno();
//       List <Materia> lista=  inscData.obtenerMateriasCursadas(selec.getIdAlumno());
//       List <Materia> lista=  inscData.obtenerMateriasCursadas(id);
       
//            List <Inscripcion> lista= (ArrayList) inscData.obtenerMateriasCursadas(selec.getIdAlumno());
//            List <Inscripcion> lista=  inscData.obtenerMateriasCursadas(id);
            List <Inscripcion> lista= inscData.obtenerInscripcionesPorIdAlumno(id);

//        for(Materia m : lista){
////            modelo.addRow(new Object [] {m.getIdMateria() , m.getNombre_materia(),m.getAnio()}) ;
//            modelo.addRow(new Object [] {m.getIdMateria() , m.getNombre_materia() , 0 });
//        }
      
        for(Inscripcion m : lista){
            Materia idMat=m.getMateria();
            modelo.addRow(new Object []{idMat.getIdMateria() ,idMat.getNombre_materia(), m.getNota()}) ;
        }

    }
    
    private void borrarFilaTabla(){
        int indice=modelo.getRowCount()-1;
        for(int i=indice;i>=0;i--){
            modelo.removeRow(i);
        }
        
    }

    private void If(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
