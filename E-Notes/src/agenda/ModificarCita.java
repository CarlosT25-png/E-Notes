/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import contactos.*;
import bd.Conexion;
import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mnpra
 */
public final class ModificarCita extends javax.swing.JFrame {

    /**
     * Creates new form ModificarContacto
     */
    public ModificarCita() {
        initComponents();
        iconoFormulario();
        validacion();
    }
    
    String usuario;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");  
    DateFormat formatter = new SimpleDateFormat("HH:mm");
    
    public void rellenar(String lugar, String fecha, String hora, String detalles, String user,String ID) throws ParseException{
        txtLugar.setText(lugar);
        System.out.println(fecha);
        txtFecha.setDate(formato.parse(fecha));
        txtHora.setTime(formatter.parse(hora));
        txtDetalles.setText(detalles);  
        txtIDAgenda.setText(ID);
        usuario = user;
    }
    
    //Establecer el iconono
    public void iconoFormulario() {
        URL url = getClass().getResource("/imagenes/general/logo.png");
        ImageIcon icono_formulario = new ImageIcon(url);
        setIconImage(icono_formulario.getImage()); 
    }

    public void limpiar(){
        txtLugar.setText("");
        txtDetalles.setText("");
        txtFecha.setDate(null);
        txtHora.setTime(null);
    }
     
    public void validacion(){
        if(txtHora.getTimeField().getText().isEmpty() || txtDetalles.getText().isEmpty() || txtLugar.getText().isEmpty()|| txtFecha.getDate().toString().isEmpty()){
            btnGuardarCita.setEnabled(false);
        }else{
            btnGuardarCita.setEnabled(true);
        }
            
    }
    
    public void actualizarCita(String fecha, String hora ,String lugar , String nota, String user){
        usuario = user;
        PreparedStatement sentencia_preparada;
        int ID = Integer.parseInt(txtIDAgenda.getText());
        Connection conn = Conexion.getConnection();
        try {
            String consulta = "UPDATE agenda SET fecha = ? , hora = ?, lugar = ?, nota = ?, NOMBRE_USUARIO = ? WHERE NOMBRE_USUARIO = '"+usuario+"' AND IDAGENDA = "+ID+"";
            sentencia_preparada = conn.prepareStatement(consulta);
            sentencia_preparada.setString(1, fecha);
            sentencia_preparada.setString(2, hora);
            sentencia_preparada.setString(3, lugar);
            sentencia_preparada.setString(4, nota);
            sentencia_preparada.setString(5, usuario);
            
            int i = sentencia_preparada.executeUpdate();
            
            if(i>0){
                JOptionPane.showMessageDialog(null, "Datos modificados");
                Agenda agenda = new Agenda();
                agenda.setVisible(true);
                this.dispose();
                agenda.cargarDatos(usuario);
            }else{
                JOptionPane.showMessageDialog(null, "No se han podido modificar los datos");
            }
            
            conn.close();
            
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: "+e);
        }
        
        
    }
    
    public void guardar(){
        String lugar = txtLugar.getText();
        String nota = txtDetalles.getText();
        String hora = txtHora.getTimeField().getText();     
        int dia,mes,año;
        dia = txtFecha.getCalendar().get(Calendar.DAY_OF_MONTH);
        mes = txtFecha.getCalendar().get(Calendar.MONTH);
        año = txtFecha.getCalendar().get(Calendar.YEAR);
        
        String fecha;
        fecha = año+"/"+(mes+1)+"/"+dia;
             
        actualizarCita(fecha,hora,lugar,nota,usuario);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLimpiarCita = new javax.swing.JButton();
        btnGuardarCita = new javax.swing.JButton();
        borde = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        txtID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        txtDetalles = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtHora = new lu.tudor.santec.jtimechooser.JTimeChooser();
        txtIDAgenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLimpiarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnLimpiar.png"))); // NOI18N
        btnLimpiarCita.setBorder(null);
        btnLimpiarCita.setBorderPainted(false);
        btnLimpiarCita.setContentAreaFilled(false);
        btnLimpiarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarCitaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarCitaMouseExited(evt);
            }
        });
        btnLimpiarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCitaActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        btnGuardarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnGuardar.png"))); // NOI18N
        btnGuardarCita.setBorder(null);
        btnGuardarCita.setBorderPainted(false);
        btnGuardarCita.setContentAreaFilled(false);
        btnGuardarCita.setEnabled(false);
        btnGuardarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarCitaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarCitaMouseExited(evt);
            }
        });
        btnGuardarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCitaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

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
        jLabel1.setText("MODIFICAR CITA");
        borde.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnCerrar.png"))); // NOI18N
        btnCerrar.setBorder(null);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        borde.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jPanel1.add(borde, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 590, 40));

        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Lugar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 95, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Fecha:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Detalles:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 215, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Hora:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 95, -1, -1));

        txtLugar.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtLugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLugarKeyReleased(evt);
            }
        });
        jPanel1.add(txtLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 200, 40));

        txtDetalles.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtDetalles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDetallesKeyReleased(evt);
            }
        });
        jPanel1.add(txtDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 500, 40));

        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtFechaMouseReleased(evt);
            }
        });
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 200, 40));

        txtHora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtHoraMouseReleased(evt);
            }
        });
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 160, 40));

        txtIDAgenda.setBackground(new java.awt.Color(255, 255, 255));
        txtIDAgenda.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtIDAgenda.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtIDAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarCitaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarCitaMouseEntered
        btnLimpiarCita.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnLimpiar.png")));
    }//GEN-LAST:event_btnLimpiarCitaMouseEntered

    private void btnLimpiarCitaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarCitaMouseExited
        btnLimpiarCita.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/btnLimpiar.png")));
    }//GEN-LAST:event_btnLimpiarCitaMouseExited

    private void btnLimpiarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCitaActionPerformed
        limpiar();
        validacion();
    }//GEN-LAST:event_btnLimpiarCitaActionPerformed

    private void btnGuardarCitaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCitaMouseEntered
        if(btnGuardarCita.isEnabled()){
           btnGuardarCita.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnGuardar.png")));
        }        
    }//GEN-LAST:event_btnGuardarCitaMouseEntered

    private void btnGuardarCitaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCitaMouseExited
        btnGuardarCita.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/btnGuardar.png")));
    }//GEN-LAST:event_btnGuardarCitaMouseExited

    private void btnGuardarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCitaActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarCitaActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Agenda ag = new Agenda();
        ag.setVisible(true);
        this.dispose();
        ag.cargarDatos(usuario);
    }//GEN-LAST:event_btnCerrarActionPerformed
    
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

    private void txtLugarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugarKeyReleased
        validacion();
    }//GEN-LAST:event_txtLugarKeyReleased

    private void txtDetallesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetallesKeyReleased
        validacion();
    }//GEN-LAST:event_txtDetallesKeyReleased

    private void txtFechaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMouseReleased
        validacion();
    }//GEN-LAST:event_txtFechaMouseReleased

    private void txtHoraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoraMouseReleased
        validacion();
    }//GEN-LAST:event_txtHoraMouseReleased
    
    int inicio = 0,fav=0;
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
            java.util.logging.Logger.getLogger(ModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel borde;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardarCita;
    private javax.swing.JButton btnLimpiarCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDetalles;
    private com.toedter.calendar.JDateChooser txtFecha;
    private lu.tudor.santec.jtimechooser.JTimeChooser txtHora;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtIDAgenda;
    private javax.swing.JTextField txtLugar;
    // End of variables declaration//GEN-END:variables
}
