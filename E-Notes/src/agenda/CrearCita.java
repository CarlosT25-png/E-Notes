/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import contactos.*;
import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mnpra
 */
public final class CrearCita extends javax.swing.JFrame {

    /**
     * Creates new form CrearContacto
     */
    public CrearCita() {
        initComponents();
        iconoFormulario();
    }
    
    //Establecer el iconono
    public void iconoFormulario() {
        URL url = getClass().getResource("/imagenes/general/logo.png");
        ImageIcon icono_formulario = new ImageIcon(url);
        setIconImage(icono_formulario.getImage());
    }
    
    String usuario;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public void getuser(String user){
        usuario = user;
    }

    public void GuardarCitaSQL(String hora, String lugar, String nota) throws ParseException{
        ResultSet res;
        PreparedStatement stm;
        

        int dia,mes,año;
        dia = txtFecha.getCalendar().get(Calendar.DAY_OF_MONTH);
        mes = txtFecha.getCalendar().get(Calendar.MONTH);
        año = txtFecha.getCalendar().get(Calendar.YEAR);
        
        String fech;
        fech = año+"/"+(mes+1)+"/"+dia;
        
        try {
            try (Connection conexionBD = bd.Conexion.getConnection()) {
                String consulta = "INSERT INTO agenda (fecha,hora,lugar,nota,nombre_usuario) VALUES (?,?,?,?,?)";
                stm = conexionBD.prepareStatement(consulta);
                stm.setString(1, fech);
                stm.setString(2, hora);
                stm.setString(3, lugar);
                stm.setString(4, nota);
                stm.setString(5, usuario);
                
                int i = stm.executeUpdate();
                
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Datos Guardados");
                    Agenda agenda = new Agenda();
                    agenda.setVisible(true);
                    this.dispose();
                    agenda.cargarDatos(usuario);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            }
            
        } catch (HeadlessException | SQLException e) {
        System.out.println("Error : " + e);
        } 
        
    }
    public void limpiar() throws ParseException{
        txtDescripcion.setText("");
        txtFecha.setDate(null);
        txtLugar.setText("");
    }
    
    public void validacion(){
        if(txtHora.getTimeField().getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtLugar.getText().isEmpty()|| txtFecha.getDate().toString().isEmpty()){
            btnGuardarCita.setEnabled(false);
        }else{
            btnGuardarCita.setEnabled(true);
        }
            
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnLimpiarCita = new javax.swing.JButton();
        btnGuardarCita = new javax.swing.JButton();
        borde = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtLugar = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtHora = new lu.tudor.santec.jtimechooser.JTimeChooser();

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Telefono:");

        jScrollPane4.setViewportView(jTextPane4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 105, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Lugar:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 165, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Hora:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 105, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Descripción:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 225, -1, -1));

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

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnCerrar.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        borde.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agenda/iconAgenda.png"))); // NOI18N
        borde.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("CREAR CITA");
        borde.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel1.add(borde, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 40));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 490, 40));

        txtLugar.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtLugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLugarKeyReleased(evt);
            }
        });
        jPanel1.add(txtLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 200, 40));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 200, 40));
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 170, 40));

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

    private void btnGuardarCitaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCitaMouseEntered
        if(btnGuardarCita.isEnabled()){
            btnGuardarCita.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnGuardar.png")));
        }
    }//GEN-LAST:event_btnGuardarCitaMouseEntered

    private void btnGuardarCitaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCitaMouseExited
        btnGuardarCita.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/btnGuardar.png")));
    }//GEN-LAST:event_btnGuardarCitaMouseExited

    private void btnLimpiarCitaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarCitaMouseEntered
        btnLimpiarCita.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnLimpiar.png")));
    }//GEN-LAST:event_btnLimpiarCitaMouseEntered

    private void btnLimpiarCitaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarCitaMouseExited
        btnLimpiarCita.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/btnLimpiar.png")));
    }//GEN-LAST:event_btnLimpiarCitaMouseExited

    //metodos para mover el frame
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

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Agenda ag = new Agenda();
        ag.cargarDatos(usuario);
        ag.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnLimpiarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCitaActionPerformed
        try {
            limpiar();
        } catch (ParseException ex) {
            Logger.getLogger(CrearCita.class.getName()).log(Level.SEVERE, null, ex);
        }
        validacion();
    }//GEN-LAST:event_btnLimpiarCitaActionPerformed

    private void btnGuardarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCitaActionPerformed
        try {
            GuardarCitaSQL(txtHora.getTimeField().getText(),txtLugar.getText(), txtDescripcion.getText());
        } catch (ParseException ex) {
            Logger.getLogger(CrearCita.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_btnGuardarCitaActionPerformed

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        validacion();
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtLugarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugarKeyReleased
        validacion();
    }//GEN-LAST:event_txtLugarKeyReleased

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
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CrearCita().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel borde;
    private javax.swing.JButton btnGuardarCita;
    private javax.swing.JButton btnLimpiarCita;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextField txtDescripcion;
    private com.toedter.calendar.JDateChooser txtFecha;
    private lu.tudor.santec.jtimechooser.JTimeChooser txtHora;
    private javax.swing.JTextField txtLugar;
    // End of variables declaration//GEN-END:variables
}
