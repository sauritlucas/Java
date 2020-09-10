
package ventanas;

import gestor.GestorDB;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Autor;
import model.Libro;


public class VentanaPrincipal extends javax.swing.JFrame {

    GestorDB g;
    
    
    public VentanaPrincipal() {
        initComponents();
        
        this.g = new GestorDB();
        
        cargarTabla();
        String cantidadLibros = g.cantidadLibros();
        cargarAutores();
        txtCantidadLibros.setText(cantidadLibros);
        
        
    }
    
     public void cargarTabla(){
                       
        DefaultTableModel dm = new DefaultTableModel();
        
        dm.setColumnIdentifiers(new String[] {"id", "descripcion", "tipo de prestamo","id_autor", "Nombre Autor"});
        GestorDB g = new GestorDB();
        ArrayList<Libro> lista = g.GetListadoLibros();
        
        for (Libro libro : lista) {
          dm.addRow(new String[]{
              String.valueOf(libro.getId_libro()), 
              libro.getDescripcion(),
              libro.getTipoPrestamo(),
              String.valueOf(libro.getAutor().getId()),
              libro.getAutor().getNombre()
          });  
        }
        tablaLibros.setModel(dm);
     }
     
    
        
     public void cargarAutores(){
         ArrayList<Autor> listadoAutores = g.GetAutores();
         
         for (Autor autor : listadoAutores) {
             cboVerLibrosAutor.addItem(autor);
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
        txtCantidadLibros = new javax.swing.JLabel();
        btnAgregarLibro = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        btnListadoDeLibrosNacionales = new javax.swing.JButton();
        btnListadoDeLibrosFriendly1 = new javax.swing.JButton();
        cboVerLibrosAutor = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        btnLibrosAutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cantidad de Libros en Base de Datos:");

        btnAgregarLibro.setText("Agregar Libro");
        btnAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLibroActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaLibros);

        btnListadoDeLibrosNacionales.setText("Obtener  Listado Libros Nacionales");
        btnListadoDeLibrosNacionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoDeLibrosNacionalesActionPerformed(evt);
            }
        });

        btnListadoDeLibrosFriendly1.setText("Obtener  Listado Libros Friendly");
        btnListadoDeLibrosFriendly1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoDeLibrosFriendly1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione un Autor");

        btnLibrosAutor.setText("Ver sus Libros");
        btnLibrosAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrosAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnAgregarLibro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnModificar)
                        .addGap(88, 88, 88)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCantidadLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboVerLibrosAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 154, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnListadoDeLibrosNacionales)
                .addGap(145, 145, 145))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLibrosAutor)
                .addGap(100, 100, 100))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(btnListadoDeLibrosFriendly1)
                    .addContainerGap(451, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarLibro)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(48, 48, 48)
                .addComponent(btnListadoDeLibrosNacionales)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCantidadLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboVerLibrosAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(btnLibrosAutor)
                .addGap(53, 53, 53))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(344, Short.MAX_VALUE)
                    .addComponent(btnListadoDeLibrosFriendly1)
                    .addGap(158, 158, 158)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroActionPerformed
        VentanaAgregarLibro vag = new VentanaAgregarLibro();
        vag.agregarOModificar(true);
        vag.setVisible(true);
    }//GEN-LAST:event_btnAgregarLibroActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        GestorDB g = new GestorDB();
        
         int row = tablaLibros.getSelectedRow();
        
        if (row == -1) {
            return; //Para cuando no hay fila seleccionada
        }
        
        int idBorrar = Integer.parseInt((String) tablaLibros.getValueAt(row, 0));
        g.eliminarLibro(idBorrar);
        
        cargarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        int row = tablaLibros.getSelectedRow();
        if (row == -1) {
            return; //Para cuando no hay fila seleccionada
        }
        int id = Integer.parseInt((String) tablaLibros.getValueAt(row, 0));
        String descripcion = (String) tablaLibros.getValueAt(row, 1);
        String tipoPrestamo = (String) tablaLibros.getValueAt(row, 2);
        int idAutor = Integer.parseInt((String) tablaLibros.getValueAt(row, 3));
        
        
        Libro libro = g.seleccionarLibro(id);
        
        VentanaAgregarLibro vag = new VentanaAgregarLibro(libro);
        
        
        
       // VentanaAgregarLibro vag = new VentanaAgregarLibro(id, descripcion, tipoPrestamo, idAutor);
        vag.agregarOModificar(false);
        
        vag.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnListadoDeLibrosFriendly1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoDeLibrosFriendly1ActionPerformed
        VentanaListadoFriendly vlf = new VentanaListadoFriendly();
        vlf.setVisible(true);
    }//GEN-LAST:event_btnListadoDeLibrosFriendly1ActionPerformed

    private void btnListadoDeLibrosNacionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoDeLibrosNacionalesActionPerformed
        VentanaListadoNacional vln = new VentanaListadoNacional();
        vln.setVisible(true);
    }//GEN-LAST:event_btnListadoDeLibrosNacionalesActionPerformed

    private void btnLibrosAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrosAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLibrosAutorActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLibro;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLibrosAutor;
    private javax.swing.JButton btnListadoDeLibrosFriendly1;
    private javax.swing.JButton btnListadoDeLibrosNacionales;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cboVerLibrosAutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JLabel txtCantidadLibros;
    // End of variables declaration//GEN-END:variables
}
