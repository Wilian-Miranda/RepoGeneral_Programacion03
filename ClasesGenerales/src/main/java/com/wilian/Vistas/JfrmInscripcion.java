/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.wilian.Vistas;

import com.wilian.DAO.CDEstudiantes;
import com.wilian.DAO.CDMaterias;
import com.wilian.DAO.CDNotas;
import com.wilian.Entidades.DbNotas;
import org.w3c.dom.Notation;

/**
 *
 * @author Willian
 */
public class JfrmInscripcion extends javax.swing.JFrame {

    /**
     * Creates new form JfrmInscripcion
     */
    public JfrmInscripcion() {
        initComponents();
        setLocationRelativeTo(null);
        cargarEstudiantes();
        cargarMaterias();
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
        cbbEstudiantes = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbbMateria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("INSCRIPCIÓN Y ASIGNACIÓN DE NOTAS");

        jLabel2.setText("Estudiante:");

        cbbEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbEstudiantesActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");

        jLabel3.setText("Materia:");

        cbbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMateriaActionPerformed(evt);
            }
        });

        jLabel4.setText("Nota:");

        txtNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNotaKeyTyped(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(123, 123, 123)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(cbbEstudiantes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbMateria, 0, 281, Short.MAX_VALUE))
                                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int indexEstudiante = 0;
    private int indexMateria = 0;
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        CDNotas notasDao = new CDNotas();

        DbNotas nota = new DbNotas();
        if ((cbbEstudiantes.getSelectedIndex() >= 0 && cbbMateria.getSelectedIndex() >= 0)
                && !txtNota.getText().equals("")) {
            try {
                if (Double.parseDouble(txtNota.getText())>0.0) {
                    nota.setIdEstudiante(estudiantes[indexEstudiante]);
                    nota.setIdmateria(materias[indexMateria]);
                    nota.setNota(Double.parseDouble(txtNota.getText()));
                    notasDao.AgregarNota(nota);
                    limpiar();
                }

            } catch (Exception e) {
                txtNota.setText("");
            }

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void limpiar(){
        cbbEstudiantes.setSelectedIndex(0);
        cbbMateria.setSelectedIndex(0);
        txtNota.setText("");
    }
    
    private void cbbEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbEstudiantesActionPerformed
        if (cbbEstudiantes.getSelectedIndex() != -1) {
            indexEstudiante = cbbEstudiantes.getSelectedIndex();
        }
    }//GEN-LAST:event_cbbEstudiantesActionPerformed

    private void cbbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMateriaActionPerformed
                if (cbbMateria.getSelectedIndex() != -1) {
            indexMateria = cbbMateria.getSelectedIndex();
        }
    }//GEN-LAST:event_cbbMateriaActionPerformed

    private void txtNotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaKeyTyped

    }//GEN-LAST:event_txtNotaKeyTyped

    int estudiantes[];
   private void  cargarEstudiantes(){
       cbbEstudiantes.removeAllItems();
        CDEstudiantes n = new CDEstudiantes();
        
        estudiantes = new int[n.MostrarEstudiantes().size()];
        
        int indice = 0;
        for (var i : n.MostrarEstudiantes()) {
          cbbEstudiantes.addItem(i.getNombres()+" "+i.getApellidos());
          estudiantes[indice] = i.getId();
          indice++;
       }
    }
       
   
   int materias[];
   private void  cargarMaterias(){
       cbbMateria.removeAllItems();
        CDMaterias n = new CDMaterias();
        
        materias = new int[n.MostrarMaterias().size()];
        
        int indice = 0;
        for (var i : n.MostrarMaterias()) {
          cbbMateria.addItem(i.getNombreMateria());
         materias[indice] = i.getIdMateria();
          indice++;
       }
        
    }
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
            java.util.logging.Logger.getLogger(JfrmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmInscripcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbbEstudiantes;
    private javax.swing.JComboBox<String> cbbMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}
