/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import entidades.Alumno;
import entidades.Materia;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.InscripcionData;
import persistencia.MateriaData;

/**
 *
 * @author Adriana
 */
public class AlumnosPorMateriaView extends javax.swing.JInternalFrame {

    /**
     * Creates new form AlumnosPorMateriaView
     */
    public AlumnosPorMateriaView() {
        initComponents();
    }

     
public class AlumnosPorMateriaForm extends JFrame {
    
    private JComboBox<Materia> jComboBoxMaterias;
    private JTable jTableAlumnos;
    private JButton btnSalir;
    
    public AlumnosPorMateriaForm() {
        initComponents();
        cargarMaterias(); // Llenar el ComboBox con las materias
    }

    private void initComponents() {
        setTitle("Listado de Alumnos por Materia");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Etiqueta
        JLabel lblMateria = new JLabel("Seleccione una materia:");
        lblMateria.setBounds(20, 20, 150, 25);
        add(lblMateria);

        // ComboBox de Materias
        jComboBoxMaterias = new JComboBox<>();
        jComboBoxMaterias.setBounds(180, 20, 250, 25);
        jComboBoxMaterias.addActionListener((ActionEvent evt) -> {
            cargarAlumnosPorMateria();
        });
        add(jComboBoxMaterias);

        // Tabla de Alumnos
        jTableAlumnos = new JTable(new DefaultTableModel(
                new Object[]{"ID", "DNI", "Apellido", "Nombre"}, 0
        ));
        JScrollPane scrollPane = new JScrollPane(jTableAlumnos);
        scrollPane.setBounds(20, 60, 550, 250);
        add(scrollPane);

        // Botón Salir
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(480, 320, 90, 25);
        btnSalir.addActionListener((ActionEvent evt) -> {
            dispose();
        });
        add(btnSalir);
    }

    private void cargarMaterias() {
        // Supongamos que tienes un objeto MateriaData y un método listarMaterias()
        MateriaData materiaData = new MateriaData();
        List<Materia> materias = materiaData.listarMaterias();
        
        // Limpiar el ComboBox antes de llenarlo
        jComboBoxMaterias.removeAllItems();
        
        for (Materia materia : materias) {
            jComboBoxMaterias.addItem(materia);
        }
    }

    private void cargarAlumnosPorMateria() {
        Materia materiaSeleccionada = (Materia) jComboBoxMaterias.getSelectedItem();
        
        if (materiaSeleccionada != null) {
            InscripcionData inscripcionData = new InscripcionData();
            List<Alumno> alumnos = inscripcionData.obtenerAlumnosxMateria(materiaSeleccionada.getIdMateria());
            
            // Limpiar la tabla antes de llenarla con nuevos datos
            DefaultTableModel modelo = (DefaultTableModel) jTableAlumnos.getModel();
            modelo.setRowCount(0);
            
            // Agregar los alumnos a la tabla
            for (Alumno alumno : alumnos) {
                modelo.addRow(new Object[]{
                    alumno.getId(), alumno.getDni(), alumno.getApellido(), alumno.getNombre()
                });
            }
        }
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setTitle("Listado de Alumnos por Materia");
        setToolTipText("");
        setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("<html><u>Listado de Alumnos por Materia</u></html>\n");

        jLabel2.setText("Seleccione una Materia:");

        jComboBox1.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Salir");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Materia> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
