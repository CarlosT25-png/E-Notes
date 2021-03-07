/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactos;

import bd.Conexion;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login.Login;
import menu_principal.MenuPrincipal;

/**
 *
 * @author mnpra
 */
public final class Contactos extends javax.swing.JFrame {

    /**
     * Creates new form Contactos
     */
    public Contactos() {
        initComponents();
        iconoFormulario();
    }
    
    DefaultTableModel tabla;
    static ResultSet res;
    
    ImageIcon rojo = new ImageIcon(getClass().getResource("/imagenes/general/Check_rojo.png"));
    ImageIcon verde = new ImageIcon(getClass().getResource("/imagenes/general/Check_verde.png"));

    
    //Establecer el iconono
    public void iconoFormulario() {
        URL url = getClass().getResource("/imagenes/general/logo.png");
        ImageIcon icono_formulario = new ImageIcon(url);
        setIconImage(icono_formulario.getImage());
    }
    
    String usuario;
    public void cargarDatos(String user){
        tabla = (DefaultTableModel) tblContactos.getModel();
        usuario = user;
        tabla.setRowCount(0);
        res = bd.Conexion.Consulta("select Nombre,Movil,Telefono from contactos where NOMBRE_USUARIO = '"+user+"'");
        try {
            while(res.next()){
                Vector vec = new Vector();
                vec.add(res.getString(1));
                vec.add(res.getString(2));
                vec.add(res.getString(3));
                tabla.addRow(vec);
                tblContactos.setModel(tabla);
            }
        } catch (SQLException e) {
            
        }
        
    }
    
     public void busqueda_filtrada(String nombre) {
        String columnas[] = {"Nombre", "Movil", "Telefono"};
        tabla = new DefaultTableModel(null, columnas);

        try {
            res = Conexion.Consulta("SELECT Nombre, Movil, Telefono FROM contactos WHERE Nombre LIKE '"+nombre+"%' and NOMBRE_USUARIO = '"+usuario+"'");

            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                tabla.addRow(v);
            }
            tblContactos.setModel(tabla);
            Conexion.getConnection().close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                Conexion.getConnection().close();
            } catch (SQLException e) {
            }
        }
    }
     
      public void iconofiltro(String nombre) {
        String columnas[] = {"Nombre", "Movil", "Telefono"};
        tabla = new DefaultTableModel(null, columnas);

        try {
            res = Conexion.Consulta("SELECT Nombre, Movil, Telefono FROM contactos WHERE Nombre LIKE '"+nombre+"%' and NOMBRE_USUARIO = '"+usuario+"'");

            if(res.next()) {
                lbltxtBuscar.setText("Resultados posibles");
                lblImgBuscar.setIcon(verde);
            }else{
                lbltxtBuscar.setText("No existen resultados");
                lblImgBuscar.setIcon(rojo);   
            }
            
            Conexion.getConnection().close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                Conexion.getConnection().close();
            } catch (SQLException e) {
            }
        }
    }
      
      public void EliminarContacto(){
          int i = JOptionPane.showConfirmDialog(null,"¿Está seguro que quiere eliminar este contacto?");
        if(i==0){
            int fila = tblContactos.getSelectedRow();
            String valor = tblContactos.getValueAt(fila, 0).toString();
            
            try {
                PreparedStatement elim = Conexion.getConnection().prepareStatement("DELETE FROM contactos WHERE Nombre = '"+valor+"'and NOMBRE_USUARIO = '"+usuario+"'");
                int a = elim.executeUpdate();
                if(a>0){
                    JOptionPane.showMessageDialog(null,"Contacto eliminado satisfatcoriamente","Information",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar el contacto","Error",JOptionPane.ERROR_MESSAGE);
                }
                cargarDatos(usuario);
                Conexion.getConnection().close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                Conexion.getConnection().close();
            } catch (SQLException e) {
            }
        }
        }
      }
      
      public void limpiar(){
          lblImgBuscar.setIcon(null);
          lbltxtBuscar.setText("");
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        btnCrearContacto = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContactos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBuscarContacto = new javax.swing.JTextPane();
        lblImgBuscar = new javax.swing.JLabel();
        lbltxtBuscar = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();

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
                jLabel1MouseDragge(evt);
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
        PnlOpciones.add(btnAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 110, 30));

        btnMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnMenuPrincipal.png"))); // NOI18N
        btnMenuPrincipal.setBorder(null);
        btnMenuPrincipal.setBorderPainted(false);
        btnMenuPrincipal.setContentAreaFilled(false);
        btnMenuPrincipal.setFocusable(false);
        btnMenuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuPrincipalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuPrincipalMouseExited(evt);
            }
        });
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        PnlOpciones.add(btnMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, 30));

        btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/InacBtnContactos.png"))); // NOI18N
        btnContactos.setToolTipText("");
        btnContactos.setBorder(null);
        btnContactos.setBorderPainted(false);
        btnContactos.setContentAreaFilled(false);
        btnContactos.setFocusable(false);
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

        btnCrearContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contactos/btnCrearContacto.png"))); // NOI18N
        btnCrearContacto.setBorder(null);
        btnCrearContacto.setBorderPainted(false);
        btnCrearContacto.setContentAreaFilled(false);
        btnCrearContacto.setFocusable(false);
        btnCrearContacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearContactoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearContactoMouseExited(evt);
            }
        });
        btnCrearContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearContactoActionPerformed(evt);
            }
        });
        ParentPanel.add(btnCrearContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contactos/btnVer.png"))); // NOI18N
        btnVer.setBorder(null);
        btnVer.setBorderPainted(false);
        btnVer.setContentAreaFilled(false);
        btnVer.setEnabled(false);
        btnVer.setFocusable(false);
        btnVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVerMouseExited(evt);
            }
        });
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        ParentPanel.add(btnVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnEliminar.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setEnabled(false);
        btnEliminar.setFocusable(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        ParentPanel.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        tblContactos.setBackground(new java.awt.Color(255, 255, 255));
        tblContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Movil", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContactosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContactos);

        ParentPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 540, 350));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Buscar:");
        ParentPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txtBuscarContacto.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarContacto.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtBuscarContacto.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarContactoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtBuscarContacto);

        ParentPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 210, -1));
        ParentPanel.add(lblImgBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 40, 30));

        lbltxtBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ParentPanel.add(lbltxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 170, 30));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/general/btnModificar.png"))); // NOI18N
        btnModificar.setBorder(null);
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.setEnabled(false);
        btnModificar.setFocusable(false);
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        ParentPanel.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 40, -1, -1));

        jPanel1.add(ParentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 590, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        ModificarContacto modi = new ModificarContacto();
        int fila = tblContactos.getSelectedRow();
        String nombre = tblContactos.getValueAt(fila, 0).toString();
        String movil = tblContactos.getValueAt(fila, 1).toString();
        String telefono = tblContactos.getValueAt(fila, 2).toString();

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement stm = con.prepareStatement("select DIRECCION,EMAIL,IDCONTACTO from contactos WHERE MOVIL = '"+movil+"' and NOMBRE_USUARIO = '"+usuario+"'");
            ResultSet ress = stm.executeQuery();
            while(ress.next()){
                String direccion = ress.getString("DIRECCION");
                String email = ress.getString("EMAIL");
                String id = ress.getString("IDCONTACTO");
                modi.rellenar(nombre, telefono, movil, direccion, email,id,usuario);
                modi.validacion();
            }

            modi.setVisible(true);
            this.dispose();
        }catch (SQLException e) {
            System.out.println("Error: "+e);
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        if(btnModificar.isEnabled()){
            btnModificar.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/BtnModificar.png")));
        }
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        if(btnModificar.isEnabled()){
            btnModificar.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnModificar.png")));
        }
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarMouseClicked

    private void txtBuscarContactoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarContactoKeyReleased
        busqueda_filtrada(txtBuscarContacto.getText());
        iconofiltro(txtBuscarContacto.getText());
        if(txtBuscarContacto.getText().isEmpty()){
            limpiar();
        }
    }//GEN-LAST:event_txtBuscarContactoKeyReleased

    private void tblContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContactosMouseClicked
        if(tblContactos.isColumnSelected(0)){
            btnVer.setEnabled(true);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        }else{
            btnVer.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnModificar.setEnabled(false);
        }
    }//GEN-LAST:event_tblContactosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        EliminarContacto();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        if(btnEliminar.isEnabled()){
            btnEliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/btnEliminar.png")));
        }
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        if(btnEliminar.isEnabled()){
            btnEliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnEliminar.png")));
        }

    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        VerContacto ver = new VerContacto();
        int fila = tblContactos.getSelectedRow();
        String nombre = tblContactos.getValueAt(fila, 0).toString();
        String movil = tblContactos.getValueAt(fila, 1).toString();
        String telefono = tblContactos.getValueAt(fila, 2).toString();

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement stm = con.prepareStatement("select DIRECCION,EMAIL from contactos WHERE MOVIL = '"+movil+"'and NOMBRE_USUARIO = '"+usuario+"'");
            ResultSet ress = stm.executeQuery();
            while(ress.next()){
                String direccion = ress.getString("DIRECCION");
                String email = ress.getString("EMAIL");
                ver.rellenar(nombre, telefono, movil, direccion, email,usuario);
            }

            ver.setVisible(true);
            this.dispose();
        }catch (SQLException e) {
            System.out.println("Error: "+e);
        }

    }//GEN-LAST:event_btnVerActionPerformed

    private void btnVerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerMouseExited
        if(btnVer.isEnabled()){
            btnVer.setIcon(new ImageIcon(getClass().getResource("/imagenes/contactos/BtnVer.png")));
        }
    }//GEN-LAST:event_btnVerMouseExited

    private void btnVerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerMouseEntered
        if(btnVer.isEnabled()){
            btnVer.setIcon(new ImageIcon(getClass().getResource("/imagenes/contactos/InacBtnVer.png")));
        }
    }//GEN-LAST:event_btnVerMouseEntered

    private void btnCrearContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearContactoActionPerformed
        CrearContacto crear = new CrearContacto();
        crear.getuser(usuario);
        crear.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearContactoActionPerformed

    private void btnCrearContactoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearContactoMouseExited
        btnCrearContacto.setIcon(new ImageIcon(getClass().getResource("/imagenes/contactos/BtnCrearContacto.png")));
    }//GEN-LAST:event_btnCrearContactoMouseExited

    private void btnCrearContactoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearContactoMouseEntered
        btnCrearContacto.setIcon(new ImageIcon(getClass().getResource("/imagenes/contactos/InacBtnCrearContacto.png")));
    }//GEN-LAST:event_btnCrearContactoMouseEntered

    private void btnCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseExited
        btnCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/BtnCerrarSesion.png")));
    }//GEN-LAST:event_btnCerrarSesionMouseExited

    private void btnCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseEntered
        btnCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnCerrarSesion.png")));
    }//GEN-LAST:event_btnCerrarSesionMouseEntered

    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        btnReportes.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/BtnReportes.png")));
    }//GEN-LAST:event_btnReportesMouseExited

    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        btnReportes.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnReportes.png")));
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnMenuPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuPrincipalMouseExited
        btnMenuPrincipal.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/BtnMenuPrincipal.png")));
    }//GEN-LAST:event_btnMenuPrincipalMouseExited

    private void btnMenuPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuPrincipalMouseEntered
        btnMenuPrincipal.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnMenuPrincipal.png")));
    }//GEN-LAST:event_btnMenuPrincipalMouseEntered

    private void btnAgendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendaMouseExited
        btnAgenda.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/BtnAgenda.png")));
    }//GEN-LAST:event_btnAgendaMouseExited

    private void btnAgendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendaMouseEntered
        btnAgenda.setIcon(new ImageIcon(getClass().getResource("/imagenes/general/InacBtnAgenda.png")));
    }//GEN-LAST:event_btnAgendaMouseEntered

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jLabel1MouseDragge(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragge
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jLabel1MouseDragge

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        menu.llenarTablasMP(usuario);
        this.dispose();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

   
    int xx,xy;
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
            java.util.logging.Logger.getLogger(Contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Contactos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JPanel PnlOpciones;
    private javax.swing.JButton btnAgenda;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnContactos;
    private javax.swing.JButton btnCrearContacto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImgBuscar;
    private javax.swing.JLabel lbltxtBuscar;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tblContactos;
    private javax.swing.JTextPane txtBuscarContacto;
    // End of variables declaration//GEN-END:variables
}
