/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import gestor.GestorDB;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Autor;
import model.Libro;


public class VentanaAgregarLibro extends javax.swing.JFrame {

    GestorDB g;
    
    
    public VentanaAgregarLibro() {
        initComponents();
        
        g = new GestorDB();
        cargarAutores();
        limpiarCampos();
    }
    
    public VentanaAgregarLibro(Libro libro) {
        initComponents();
        
        g = new GestorDB();
        txtIdLibro.setText( String.valueOf(libro.getId_libro()));
        txtDescripcionLibro.setText(libro.getDescripcion());
            cboTipoPrestamo.setSelectedItem(libro.getTipoPrestamo());
            cargarAutores();
            
            //OJO CON EL SELECTED INDEX ESTA 1 NUMERO ARRIBA SIEMPRE
            cboAutor.setSelectedIndex(libro.getAutor().getId() -1);
            
            txtIdLibro.setEnabled(false);
    }
    
   /* public VentanaAgregarLibro(int id, String descripcion, String tipoPrestamo, int id_autor) {
        initComponents();
        
        g = new GestorDB();
        
        txtDescripcionLibro.setText(descripcion);
            cboTipoPrestamo.setSelectedItem(tipoPrestamo);
            cargarAutores();
            
            //OJO CON EL SELECTED INDEX ESTA 1 NUMERO ARRIBA SIEMPRE
            cboAutor.setSelectedIndex(id_autor -1);
        
    }
    */

    public void cargarAutores(){
        ArrayList<Autor> listAutores = g.GetAutores();
        
        for (Autor autor : listAutores) {
            cboAutor.addItem(autor);
        }
        
    }
    
    public void limpiarCampos(){
        txtDescripcionLibro.setText("");
            cboTipoPrestamo.setSelectedIndex(-1);
            cboAutor.setSelectedIndex(-1);
    }
    
    public boolean validarCampos(){
        String descripcion = txtDescripcionLibro.getText();
        
        if (descripcion.isEmpty() || cboAutor.getSelectedIndex()== -1 || cboTipoPrestamo.getSelectedIndex() == -1) {
            return false;
        } else { return true; }
    }
    
    public void agregarOModificar(boolean a ){
        
        if (a) {
            btnModificar.setVisible(false);
            btnAgregarLibroSISI.setVisible(true);
            lblIDLibro.setVisible(false);
            txtIdLibro.setVisible(false);
        }
        else {
            btnAgregarLibroSISI.setVisible(false);
            btnModificar.setVisible(true);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboAutor = new javax.swing.JComboBox();
        txtDescripcionLibro = new javax.swing.JTextField();
        btnAgregarLibroSISI = new javax.swing.JButton();
        cboTipoPrestamo = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        txtIdLibro = new javax.swing.JTextField();
        lblIDLibro = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Nombre Libro");

        jLabel2.setText("Tipo Prestamo");

        jLabel3.setText("Seleccione Autor");

        btnAgregarLibroSISI.setText("Cargar");
        btnAgregarLibroSISI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLibroSISIActionPerformed(evt);
            }
        });

        cboTipoPrestamo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Domicilio", "Sala de Lectura" }));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblIDLibro.setText("ID Libro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblIDLibro)
                        .addComponent(jLabel2)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcionLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar)
                            .addComponent(btnAgregarLibroSISI)))
                    .addComponent(txtIdLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIDLibro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescripcionLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboTipoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarLibroSISI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarLibroSISIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroSISIActionPerformed
        try {
           // GestorDB g = new GestorDB();
            if (validarCampos()) {
                String descripcion = txtDescripcionLibro.getText();
            //String tipoPrestamo = txtTipoPrestamo.getText();
            String tipoPrestamo =  (String) cboTipoPrestamo.getSelectedItem();
            Autor nombreAutor = (Autor) cboAutor.getSelectedItem();
            
            Libro l = new Libro(descripcion, tipoPrestamo, nombreAutor);
            
            
            g.agregarLibro(l);
            
            
            
            limpiarCampos();
            }
            else{JOptionPane.showMessageDialog(this, "Revise los Campos");}
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Revise los Campos");
        }
        
        
    }//GEN-LAST:event_btnAgregarLibroSISIActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        GestorDB g = new GestorDB();
            if (validarCampos()) {
            int idLibro= Integer.parseInt(txtIdLibro.getText()); 
            System.out.println(idLibro);
            String descripcion = txtDescripcionLibro.getText();
            //String tipoPrestamo = txtTipoPrestamo.getText();
            String tipoPrestamo =  (String) cboTipoPrestamo.getSelectedItem();
            
            //OJO ACA CON EL INDICE
            int id_autor = cboAutor.getSelectedIndex() +1;
            
            
            Libro l = new Libro(idLibro, descripcion, tipoPrestamo, id_autor );
            
        
        g.modificarLibro(l);
        
        this.dispose();
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
        }
            else{JOptionPane.showMessageDialog(this, "Revise los Campos");}
        
        
    
      
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(VentanaAgregarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgregarLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLibroSISI;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cboAutor;
    private javax.swing.JComboBox<String> cboTipoPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblIDLibro;
    private javax.swing.JTextField txtDescripcionLibro;
    private javax.swing.JTextField txtIdLibro;
    // End of variables declaration//GEN-END:variables
}
