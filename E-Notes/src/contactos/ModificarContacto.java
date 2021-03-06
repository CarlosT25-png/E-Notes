/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactos;

import bd.Conexion;
import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mnpra
 */
public final class ModificarContacto extends javax.swing.JFrame {

    /**
     * Creates new form ModificarContacto
     */
    public ModificarContacto() {
        initComponents();
        iconoFormulario();
        validacion();
    }
    
    public void rellenar(String nombre, String telefono, String movil, String direccion, String email, String id){
        txtNombre.setText(nombre);
        txtTelefono.setText(telefono);
        txtMovil.setText(movil);
        txtDireccion.setText(direccion);
        txtEmail.setText(email);
        txtID.setText(id);
        
    }
    
    //Establecer el iconono
    public void iconoFormulario() {
        URL url = getClass().getResource("/imagenes/general/logo.png");
        ImageIcon icono_formulario = new ImageIcon(url);
        setIconImage(icono_formulario.getImage()); 
    }

    public void limpiar(){
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtMovil.setText("");
        txtEmail.setText("");
    }
     
    public void validacion(){
        if(txtNombre.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtMovil.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtEmail.getText().isEmpty()){
            btnGuardarContacto.setEnabled(false);
        }else{
            btnGuardarContacto.setEnabled(true);
        } 
    }
    
    public void actualizarContacto(String nombre, String direccion ,String telefono , String movil, String email, String idcontacto,int fav){
        PreparedStatement sentencia_preparada;
        Connection conn = Conexion.getConnection();
        try {
            String consulta = "UPDATE contactos SET nombre = ? , direccion = ?, telefono = ?, movil = ?, email = ?, favorito = ? WHERE IDCONTACTO = ?";
            sentencia_preparada = conn.prepareStatement(consulta);
            sentencia_preparada.setString(1, nombre);
            sentencia_preparada.setString(2, direccion);
            sentencia_preparada.setString(3, telefono);
            sentencia_preparada.setString(4, movil);
            sentencia_preparada.setString(5, email);
            sentencia_preparada.setInt(6, fav);
            sentencia_preparada.setString(7, idcontacto);
            
            int i = sentencia_preparada.executeUpdate();
            
            if(i>0){
                JOptionPane.showMessageDialog(null, "Datos modificados");
            }else{
                JOptionPane.showMessageDialog(null, "No se han podido modificar los datos");
            }
            
            conn.close();
            
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: "+e);
        }
        
        
    }
    
    public void guardar(){
        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String movil = txtMovil.getText();
        String email = txtEmail.getText();     
        String idcontacto = txtID.getText();
        
        
        actualizarContacto(nombre,direccion,telefono,movil,email,idcontacto,fav);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnLimpiarContacto = new javax.swing.JButton();
        btnGuardarContacto = new javax.swing.JButton();
        borde = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        btnFav = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtMovil = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Telefono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Movil:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Email:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Direccion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        btnLimpiarContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnLimpiar.png"))); // NOI18N
        btnLimpiarContacto.setBorder(null);
        btnLimpiarContacto.setBorderPainted(false);
        btnLimpiarContacto.setContentAreaFilled(false);
        btnLimpiarContacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarContactoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarContactoMouseExited(evt);
            }
        });
        btnLimpiarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarContactoActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        btnGuardarContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnGuardar.png"))); // NOI18N
        btnGuardarContacto.setBorder(null);
        btnGuardarContacto.setBorderPainted(false);
        btnGuardarContacto.setContentAreaFilled(false);
        btnGuardarContacto.setEnabled(false);
        btnGuardarContacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarContactoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarContactoMouseExited(evt);
            }
        });
        btnGuardarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarContactoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        borde.setBackground(new java.awt.Color(255, 255, 255));
        borde.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bordeMouseDragged(evt);
            }
        });
        borde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bordeMousePressed(evt);
            }
        });
        borde.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contactos/modificarIcon.png"))); // NOI18N
        borde.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 40, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("MODIFICAR CONTACTO");
        borde.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel1.add(borde, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 40));

        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, -1));

        btnFav.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contactos/InacBtnFav.png"))); // NOI18N
        btnFav.setBorder(null);
        btnFav.setBorderPainted(false);
        btnFav.setContentAreaFilled(false);
        btnFav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFavMouseClicked(evt);
            }
        });
        jPanel1.add(btnFav, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnCerrar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 200, 40));

        txtTelefono.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 200, 40));

        txtDireccion.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 500, 40));

        txtMovil.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMovilKeyReleased(evt);
            }
        });
        jPanel1.add(txtMovil, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 220, 40));

        txtEmail.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 220, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarContactoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarContactoMouseEntered
        btnLimpiarContacto.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnLimpiar.png")));
    }//GEN-LAST:event_btnLimpiarContactoMouseEntered

    private void btnLimpiarContactoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarContactoMouseExited
        btnLimpiarContacto.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/btnLimpiar.png")));
    }//GEN-LAST:event_btnLimpiarContactoMouseExited

    private void btnLimpiarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarContactoActionPerformed
        limpiar();
        validacion();
    }//GEN-LAST:event_btnLimpiarContactoActionPerformed

    private void btnGuardarContactoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarContactoMouseEntered
        if(btnGuardarContacto.isEnabled()){
           btnGuardarContacto.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnGuardar.png")));
        }        
    }//GEN-LAST:event_btnGuardarContactoMouseEntered

    private void btnGuardarContactoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarContactoMouseExited
        btnGuardarContacto.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/btnGuardar.png")));
    }//GEN-LAST:event_btnGuardarContactoMouseExited

    private void btnGuardarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarContactoActionPerformed
        guardar();
        Contactos cont = new Contactos();
        cont.setVisible(true);
        this.dispose();
        cont.cargarDatos();
    }//GEN-LAST:event_btnGuardarContactoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Contactos cont = new Contactos();
        cont.setVisible(true);
        this.dispose();
        cont.cargarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    //Metodos para arrastrar el frame
    int xx,xy;
    private void bordeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bordeMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_bordeMouseDragged

    private void bordeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bordeMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_bordeMousePressed
    
    int inicio = 0,fav=0;
    private void btnFavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFavMouseClicked
         if(inicio==0){
            btnFav.setIcon(new ImageIcon(getClass().getResource("/imagenes/contactos/BtnFav.png")));
            fav = 1;
            inicio=1;
        }else{
            btnFav.setIcon(new ImageIcon(getClass().getResource("/imagenes/contactos/InacBtnFav.png")));
            inicio=0;
            fav=0;
        }
    }//GEN-LAST:event_btnFavMouseClicked

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtMovilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMovilKeyReleased
        validacion();
    }//GEN-LAST:event_txtMovilKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailKeyReleased

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
            java.util.logging.Logger.getLogger(ModificarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarContacto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel borde;
    private javax.swing.JButton btnFav;
    private javax.swing.JButton btnGuardarContacto;
    private javax.swing.JButton btnLimpiarContacto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtID;
    private javax.swing.JTextField txtMovil;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
