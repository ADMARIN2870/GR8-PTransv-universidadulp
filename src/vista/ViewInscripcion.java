/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import persistencia.AlumnoData;
import persistencia.InscripcionData;
import persistencia.MateriaData;

/**
 *
 * @author nelso
 */
public class ViewInscripcion extends javax.swing.JInternalFrame {

    private List<Materia> listaMateria;
    private List<Alumno> listaAlumno;
    
    private InscripcionData inscData;
    private MateriaData mData;
    private AlumnoData aData;
    /**
     * Creates new form view_formulario_de_inscripcion
     */
    private DefaultTableModel modelo;
    
    public ViewInscripcion() {
        initComponents();
        
        aData = new AlumnoData();
        listaAlumno = aData.obtenerAlumnos();
        modelo = new DefaultTableModel();
        inscData = new InscripcionData();
        mData = new MateriaData();
        
        cargarAlumnos();
        armarCabeceraTabla();
       
        

    }
    
    private void cargarAlumnos(){
    for (Alumno item: listaAlumno){
            cbAlumno.addItem(item);
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRmateriasInscriptas = new javax.swing.JRadioButton();
        jRmateriasNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();
        jbAnularInscripcion = new javax.swing.JButton();
        jbInscribir = new javax.swing.JButton();
        cbAlumno = new javax.swing.JComboBox<>();

        setTitle("Formulario de inscripcion");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Formulario de inscripcion");

        jLabel2.setText("Seleccione un alumno:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Listado de materias");

        jRmateriasInscriptas.setText("Materias inscriptas");
        jRmateriasInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRmateriasInscriptasActionPerformed(evt);
            }
        });

        jRmateriasNoInscriptas.setText("Materias no inscriptas");
        jRmateriasNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRmateriasNoInscriptasActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtMaterias);

        jbSalir.setText("Salir");

        jbAnularInscripcion.setText("Anular inscripcion");
        jbAnularInscripcion.setEnabled(false);

        jbInscribir.setText("Inscribir");
        jbInscribir.setEnabled(false);
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbInscribir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAnularInscripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRmateriasInscriptas)
                        .addGap(18, 18, 18)
                        .addComponent(jRmateriasNoInscriptas)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGap(0, 43, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRmateriasInscriptas)
                    .addComponent(jRmateriasNoInscriptas))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir)
                    .addComponent(jbAnularInscripcion)
                    .addComponent(jbInscribir))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRmateriasNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRmateriasNoInscriptasActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        jRmateriasInscriptas.setSelected(false);
        cargaDatosNoInscritas();
        jbAnularInscripcion.setEnabled(false);
        jbInscribir.setEnabled(true);

    }//GEN-LAST:event_jRmateriasNoInscriptasActionPerformed

    private void jRmateriasInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRmateriasInscriptasActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        jRmateriasNoInscriptas.setSelected(false);
        cargaDatosInscritas();
        jbAnularInscripcion.setEnabled(true);
        jbInscribir.setEnabled(false);

    }//GEN-LAST:event_jRmateriasInscriptasActionPerformed

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = jtMaterias.getSelectedRow();

        if (filaSeleccionada != -1) {
            Alumno a= (Alumno) cbAlumno.getSelectedItem();

            int idMateria=(Integer)modelo.getValueAt(filaSeleccionada, 0);
            String nombreMateria=(String)modelo.getValueAt(filaSeleccionada, 1);
            int anio= (Integer) modelo.getValueAt(filaSeleccionada, 2);

            Materia m=new Materia (idMateria, nombreMateria, anio, true);

            Inscripcion i= new Inscripcion (a ,m,0);
            inscData.guardarInscripcion(i);
            borrarFilaTabla();
        }
    }//GEN-LAST:event_jbInscribirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> cbAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRmateriasInscriptas;
    private javax.swing.JRadioButton jRmateriasNoInscriptas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnularInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceraTabla() {
        
        ArrayList<Object> filaCabecera = new ArrayList<> () ;
        filaCabecera.add("ID");
        filaCabecera.add("Nombre");
        filaCabecera.add("Año");
        for (Object it: filaCabecera){
                modelo.addColumn(it);
            }
        jtMaterias.setModel (modelo);
    }
    
    private void borrarFilaTabla() {
        int indice = modelo.getColumnCount() -1;
        
        
    for (int i = indice - 1; i >= 0; i--) {
        modelo.removeRow(i);
        }
    }
    
    private void cargaDatosNoInscritas() {
    
    Alumno selec = (Alumno) cbAlumno.getSelectedItem();
    listaMateria = inscData.obtenerMateriasNOCursadas(selec.getIdAlumno());

    for(Materia m : listaMateria) {
        modelo.addRow(new Object[] {m.getIdMateria(), m.getNombre_materia(), m.getAnio()});
    }
}

private void cargaDatosInscritas() {
    
    Alumno selec = (Alumno) cbAlumno.getSelectedItem();
    List<Materia> lista = (ArrayList) inscData.obtenerMateriasCursadas(selec.getIdAlumno());

    for(Materia m : lista) {
        modelo.addRow(new Object[] { m.getIdMateria(), m.getNombre_materia(), m.getAnio() });
    }
}

}
