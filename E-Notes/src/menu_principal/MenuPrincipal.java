
package menu_principal;

import agenda.Agenda;
import java.awt.HeadlessException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import bd.*;
import contactos.Contactos;
import java.sql.SQLException;
import javax.swing.table.TableColumnModel;
import login.Login;

/**
 *
 * @author mnpra
 */
public final class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        iconoFormulario();
    }
    
    public void iconoFormulario() {
        URL url = getClass().getResource("/imagenes/general/logo.png");
        ImageIcon icono_formulario = new ImageIcon(url);
        setIconImage(icono_formulario.getImage());
    }

    String userr;
    public void llenarTablasMP(String usuario){
        Date fechaH = new Date();
        userr = usuario;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fechaHoyS = format.format(fechaH);
        System.out.println(fechaHoyS);
        try {
            String consulta = "SELECT A.NOTA,A.LUGAR,A.FECHA,A.HORA FROM AGENDA AS A WHERE A.FECHA='" + fechaHoyS + "'  AND A.NOMBRE_USUARIO='"+usuario+"'";

            DefaultTableModel model = new DefaultTableModel();
            jtCitasH.setModel(model);

            Statement sql = Conexion.getConnection().createStatement();

            ResultSet resultado = sql.executeQuery(consulta);

            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();

            model.addColumn("Descripción");
            model.addColumn("Lugar");
            model.addColumn("Fecha");
            model.addColumn("Hora");

            while (resultado.next()) {
                Object[] filas = new Object[cantCol];

                for (int i = 0; i < cantCol; i++) {
                    filas[i] = resultado.getObject(i + 1);

                }
                model.addRow(filas);
            }
        } catch (SQLException e) {
        }

        TableColumnModel columnModel = jtCitasH.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(215);
        columnModel.getColumn(1).setPreferredWidth(87);
        columnModel.getColumn(2).setPreferredWidth(70);
        columnModel.getColumn(3).setPreferredWidth(30);
        
        try {
            String consulta = "SELECT C.NOMBRE,C.TELEFONO,C.MOVIL,C.EMAIL FROM CONTACTOS AS C WHERE C.FAVORITO=1 AND NOMBRE_USUARIO='"+usuario+"'";

            DefaultTableModel model = new DefaultTableModel();
            jtContactosF.setModel(model);

            Statement sql = Conexion.getConnection().createStatement();

            ResultSet resultado = sql.executeQuery(consulta);

            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();

            model.addColumn("Nombre");
            model.addColumn("Teléfono");
            model.addColumn("Movil");
            model.addColumn("E-mail");

            while (resultado.next()) {
                Object[] filas = new Object[cantCol];

                for (int i = 0; i < cantCol; i++) {
                    filas[i] = resultado.getObject(i + 1);

                }
                model.addRow(filas);
            }
        } catch (SQLException e) {
        }
        
        TableColumnModel columnModel2 = jtContactosF.getColumnModel();
        
        columnModel2.getColumn(0).setPreferredWidth(131);
        columnModel2.getColumn(1).setPreferredWidth(70);
        columnModel2.getColumn(2).setPreferredWidth(70);
        columnModel2.getColumn(3).setPreferredWidth(131);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PnlOpciones = new javax.swing.JPanel();
        btnAgenda = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();
        btnContactos = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        ParentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtContactosF = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCitasH = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnCerrar.png"))); // NOI18N
        btnSalir.setToolTipText("");
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 4, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/BarraSuperior.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        PnlOpciones.setBackground(new java.awt.Color(255, 255, 255));
        PnlOpciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
        PnlOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnAgenda.png"))); // NOI18N
        btnAgenda.setBorder(null);
        btnAgenda.setBorderPainted(false);
        btnAgenda.setContentAreaFilled(false);
        btnAgenda.setFocusable(false);
        btnAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendaMouseExited(evt);
            }
        });
        btnAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaActionPerformed(evt);
            }
        });
        PnlOpciones.add(btnAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 110, 30));

        btnMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/InacBtnMenuPrincipal.png"))); // NOI18N
        btnMenuPrincipal.setBorder(null);
        btnMenuPrincipal.setBorderPainted(false);
        btnMenuPrincipal.setContentAreaFilled(false);
        btnMenuPrincipal.setFocusable(false);
        PnlOpciones.add(btnMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, 30));

        btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnContactos.png"))); // NOI18N
        btnContactos.setToolTipText("");
        btnContactos.setBorder(null);
        btnContactos.setBorderPainted(false);
        btnContactos.setContentAreaFilled(false);
        btnContactos.setFocusable(false);
        btnContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnContactosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContactosMouseExited(evt);
            }
        });
        btnContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactosActionPerformed(evt);
            }
        });
        PnlOpciones.add(btnContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnReportes.png"))); // NOI18N
        btnReportes.setToolTipText("");
        btnReportes.setBorder(null);
        btnReportes.setBorderPainted(false);
        btnReportes.setContentAreaFilled(false);
        btnReportes.setFocusable(false);
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportesMouseExited(evt);
            }
        });
        PnlOpciones.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnCerrarSesion.png"))); // NOI18N
        btnCerrarSesion.setToolTipText("");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setFocusable(false);
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseExited(evt);
            }
        });
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        PnlOpciones.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/logo.png"))); // NOI18N
        logo.setFocusable(false);
        PnlOpciones.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jPanel1.add(PnlOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 520));

        ParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesMenuPrincipal/¡Bienvenido a E-NOTES!.png"))); // NOI18N
        ParentPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Contactos favoritos");
        ParentPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Citas para el día de hoy");
        ParentPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jtContactosF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Teléfono", "Móvil", "E-mail"
            }
        ));
        jScrollPane1.setViewportView(jtContactosF);

        ParentPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, 160));

        jtCitasH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Lugar", "Fecha", "Hora"
            }
        ));
        jScrollPane2.setViewportView(jtCitasH);

        ParentPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 160));

        jPanel1.add(ParentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 590, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    //Para poder arrastrar el frame
    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jLabel1MouseDragged

    int xx,xy;
    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void btnAgendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendaMouseEntered
        btnAgenda.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnAgenda.png")));
    }//GEN-LAST:event_btnAgendaMouseEntered

    private void btnAgendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendaMouseExited
        btnAgenda.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/BtnAgenda.png")));
    }//GEN-LAST:event_btnAgendaMouseExited

    private void btnContactosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContactosMouseEntered
        btnContactos.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnContactos.png")));
    }//GEN-LAST:event_btnContactosMouseEntered

    private void btnContactosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContactosMouseExited
        btnContactos.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/BtnContactos.png")));
    }//GEN-LAST:event_btnContactosMouseExited

    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        btnReportes.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnReportes.png")));
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        btnReportes.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/BtnReportes.png")));
    }//GEN-LAST:event_btnReportesMouseExited

    private void btnCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseEntered
        btnCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnCerrarSesion.png")));
    }//GEN-LAST:event_btnCerrarSesionMouseEntered

    private void btnCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseExited
        btnCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/BtnCerrarSesion.png")));
    }//GEN-LAST:event_btnCerrarSesionMouseExited

    private void btnAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaActionPerformed
        Agenda ag = new Agenda();
        ag.cargarDatos(userr);
        ag.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgendaActionPerformed

    private void btnContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactosActionPerformed
        Contactos cont = new Contactos();
        cont.setVisible(true);
        cont.cargarDatos(userr);
        this.dispose();
    }//GEN-LAST:event_btnContactosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

                                        
    public MenuPrincipal(JPanel ParentPanel, JPanel PnlOpciones, JButton btnAgenda, JButton btnCerrarSesion, JButton btnContactos, JButton btnMenuPrincipal, JButton btnReportes, JButton btnSalir, JLabel jLabel1, JLabel jLabel2, JPanel jPanel1, JLabel logo, JLabel txtUsuario) throws HeadlessException {
        this.ParentPanel = ParentPanel;
        this.PnlOpciones = PnlOpciones;
        this.btnAgenda = btnAgenda;
        this.btnCerrarSesion = btnCerrarSesion;
        this.btnContactos = btnContactos;
        this.btnMenuPrincipal = btnMenuPrincipal;
        this.btnReportes = btnReportes;
        this.btnSalir = btnSalir;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jPanel1 = jPanel1;
        this.logo = logo;
        //this.txtUsuario = txtUsuario;
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JPanel PnlOpciones;
    private javax.swing.JButton btnAgenda;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnContactos;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtCitasH;
    private javax.swing.JTable jtContactosF;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
