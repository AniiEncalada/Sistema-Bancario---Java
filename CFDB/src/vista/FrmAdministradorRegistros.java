package vista;

import controlador.servicio.PersonaServicio;
import controlador.servicio.RolServicio;
import controlador.utilidades.Sesion;
import controlador.utilidades.Utilidades;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import modelo.Cuenta;
import vista.tabla.ModeloTablaPersona;
import vista.utilidades.UtilidadesComponente;
import vista.utilidades.Utilitario;

/**
 *
 * @author Usuario
 */
public class FrmAdministradorRegistros extends javax.swing.JDialog {
    
    Utilitario u = new Utilitario();
    private PersonaServicio ps = new PersonaServicio();
    ModeloTablaPersona modelo = new ModeloTablaPersona();
    Cuenta c = new Cuenta();

    /**
     * Creates new form FrmVerLista
     */
    public FrmAdministradorRegistros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbRServicios);
        grupo.add(rbRCajero);
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rbCajero);
        grupo1.add(rbServicios);
        grupo1.add(rbTodos);
        ButtonGroup grupo2 = new ButtonGroup();
        grupo2.add(rbActivo);
        grupo2.add(rbInactivo);
        limpiar();
    }
    
    private void cargarTabla() {
        modelo.setLista(ps.listado().stream().sorted((a, b) -> a.getApellido().compareTo(b.getApellido())).
                collect(Collectors.toList()));
        tblVerListado.setModel(modelo);
        tblVerListado.updateUI();
    }
    
    private void limpiar() {
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtNacionalidad.setText(null);
        txtCedula.setText(null);
        txtDireccion.setText(null);
        txtEmail.setText(null);
        txtTelefono.setText(null);
        txtUsuario.setText(null);
        txtClave.setText(null);
        cargarTabla();
        rbRServicios.setSelected(false);
        rbRCajero.setSelected(false);
        rbServicios.setSelected(false);
        rbCajero.setSelected(false);
        txtCedula.setEditable(true);
    }
    
    public void cargarObjeto() {
        ps.getPersona().setApellido(txtApellido.getText());
        ps.getPersona().setNombre(txtNombre.getText());
        ps.getPersona().setDireccion(txtDireccion.getText());
        ps.getPersona().setTelefono(txtTelefono.getText());
        ps.getPersona().setCedula(txtCedula.getText());
        ps.getPersona().setNacionalidad(txtNacionalidad.getText());
        ps.getPersona().setCorreo(txtEmail.getText());
        ps.getPersona().setExternal_id(UUID.randomUUID().toString());
        c.setClave(UUID.randomUUID().toString().toUpperCase().substring(0, 7));
        c.setUsuario(txtNombre.getText().substring(0, 3)+txtApellido.getText().substring(0, 3));
        if (rbActivo.isSelected()) {
            c.setEstado(true);
        } else {
            c.setEstado(false);
        }
        c.setCreated_at(new Date());
        c.setUpdate_at(new Date());
        c.setExternal_id(UUID.randomUUID().toString());
        c.setPersona(ps.getPersona());
        ps.getPersona().setCuenta(c);
        if (rbRServicios.isSelected()) {
            ps.getPersona().setRol(new RolServicio().buscarRolNombre("Servicio"));
        } else {
            ps.getPersona().setRol(new RolServicio().buscarRolNombre("Cajero"));
        }
    }
    
    private void guardar() {
        String mensaje = "Se reqiere este dato";
        if (!UtilidadesComponente.mostrarError(txtCedula, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txtNombre, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txtApellido, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txtDireccion, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txtTelefono, mensaje, 'r')) {
            cargarObjeto();
            if (ps.getPersona().getId() != null) {
                //Modificar
                if (ps.guardar()) {
                    JOptionPane.showMessageDialog(this, "Se ha modificado correctamente");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo modificar");
                }
            } else {
                //Guardar
                if (Utilidades.validadorDeCedula(txtCedula.getText())) {
                    if (ps.getPersonaCedula(txtCedula.getText()) != null) {
                        JOptionPane.showMessageDialog(this, "Cedula ya registrada");
                        
                    } else {
                        //guardar 
                        if (ps.guardar()) {
                            JOptionPane.showMessageDialog(this, "Se ha guardado correctamente");
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo guardar");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Cedula no valida");
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

        jPanel1 = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jLabel1 = new javax.swing.JLabel();
        rbTodos = new javax.swing.JRadioButton();
        rbServicios = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVerListado = new javax.swing.JTable();
        rSMTextFull1 = new rojeru_san.RSMTextFull();
        rbCajero = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnCancelar = new rojeru_san.RSButton();
        btnDarBaja = new rojeru_san.RSButton();
        btnVolver = new rojeru_san.RSButton();
        btnGuardar = new rojeru_san.RSButton();
        rSPanelsSlider1 = new rojeru_san.RSPanelsSlider();
        txtNombre = new rojeru_san.RSMTextFull();
        txtApellido = new rojeru_san.RSMTextFull();
        txtNacionalidad = new rojeru_san.RSMTextFull();
        txtCedula = new rojeru_san.RSMTextFull();
        txtDireccion = new rojeru_san.RSMTextFull();
        txtEmail = new rojeru_san.RSMTextFull();
        txtTelefono = new rojeru_san.RSMTextFull();
        rbRServicios = new javax.swing.JRadioButton();
        rbRCajero = new javax.swing.JRadioButton();
        txtUsuario = new rojeru_san.RSMTextFull();
        jLabel3 = new javax.swing.JLabel();
        rbActivo = new javax.swing.JRadioButton();
        rbInactivo = new javax.swing.JRadioButton();
        txtClave = new rojeru_san.RSMPassView();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Casa financiera \"Doña Bachita\"");
        setIconImage(u.getIconImage());
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        rSPanelShadow1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de Personal ");
        rSPanelShadow1.add(jLabel1);
        jLabel1.setBounds(5, 5, 680, 22);

        rbTodos.setBackground(new java.awt.Color(255, 255, 255));
        rbTodos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbTodos.setForeground(new java.awt.Color(0, 112, 192));
        rbTodos.setText("Todos");
        rSPanelShadow1.add(rbTodos);
        rbTodos.setBounds(330, 50, 80, 23);

        rbServicios.setBackground(new java.awt.Color(255, 255, 255));
        rbServicios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbServicios.setForeground(new java.awt.Color(0, 112, 192));
        rbServicios.setText("Servicios");
        rSPanelShadow1.add(rbServicios);
        rbServicios.setBounds(540, 50, 79, 23);

        jLabel2.setBackground(new java.awt.Color(0, 102, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 112, 192));
        jLabel2.setText("Buscar");
        rSPanelShadow1.add(jLabel2);
        jLabel2.setBounds(20, 50, 60, 30);

        jDesktopPane1.setBackground(new java.awt.Color(0, 102, 255));

        tblVerListado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblVerListado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblVerListado.setForeground(new java.awt.Color(0, 112, 192));
        tblVerListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Nacionalidad", "Cedula/Pasaporte", "Dirección", "Email", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tblVerListado);

        jDesktopPane1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 680, 180);

        rSPanelShadow1.add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 80, 680, 190);

        rSMTextFull1.setPlaceholder("Cedula/pasaporte");
        rSPanelShadow1.add(rSMTextFull1);
        rSMTextFull1.setBounds(90, 40, 230, 42);

        rbCajero.setBackground(new java.awt.Color(255, 255, 255));
        rbCajero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbCajero.setForeground(new java.awt.Color(0, 112, 192));
        rbCajero.setText("Cajero");
        rSPanelShadow1.add(rbCajero);
        rbCajero.setBounds(430, 50, 80, 23);

        jPanel1.add(rSPanelShadow1);
        rSPanelShadow1.setBounds(0, 0, 690, 270);

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setLayout(null);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);
        btnCancelar.setBounds(230, 0, 90, 40);

        btnDarBaja.setText("Dar de baja");
        jPanel2.add(btnDarBaja);
        btnDarBaja.setBounds(400, 0, 110, 40);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel2.add(btnVolver);
        btnVolver.setBounds(570, 0, 100, 40);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);
        btnGuardar.setBounds(40, 0, 150, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 470, 690, 50);

        rSPanelsSlider1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelsSlider1.setLayout(null);

        txtNombre.setPlaceholder("Nombres");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        rSPanelsSlider1.add(txtNombre);
        txtNombre.setBounds(10, 0, 180, 42);

        txtApellido.setPlaceholder("Apellidos");
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoKeyPressed(evt);
            }
        });
        rSPanelsSlider1.add(txtApellido);
        txtApellido.setBounds(10, 50, 180, 42);

        txtNacionalidad.setPlaceholder("Nacionalidad");
        txtNacionalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNacionalidadKeyPressed(evt);
            }
        });
        rSPanelsSlider1.add(txtNacionalidad);
        txtNacionalidad.setBounds(10, 100, 180, 42);

        txtCedula.setPlaceholder("Cedula");
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        rSPanelsSlider1.add(txtCedula);
        txtCedula.setBounds(10, 150, 180, 42);

        txtDireccion.setPlaceholder("Dirección");
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
        });
        rSPanelsSlider1.add(txtDireccion);
        txtDireccion.setBounds(210, 0, 190, 42);

        txtEmail.setPlaceholder("E-mail");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        rSPanelsSlider1.add(txtEmail);
        txtEmail.setBounds(210, 50, 190, 42);

        txtTelefono.setPlaceholder("Telefono");
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
        });
        rSPanelsSlider1.add(txtTelefono);
        txtTelefono.setBounds(210, 100, 190, 42);

        rbRServicios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbRServicios.setForeground(new java.awt.Color(0, 112, 192));
        rbRServicios.setText("Servicios");
        rSPanelsSlider1.add(rbRServicios);
        rbRServicios.setBounds(210, 160, 79, 30);

        rbRCajero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbRCajero.setForeground(new java.awt.Color(0, 112, 192));
        rbRCajero.setText("Cajero");
        rSPanelsSlider1.add(rbRCajero);
        rbRCajero.setBounds(310, 160, 65, 30);

        txtUsuario.setPlaceholder("Usuario");
        rSPanelsSlider1.add(txtUsuario);
        txtUsuario.setBounds(430, 50, 250, 42);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 112, 192));
        jLabel3.setText("Usuario y contraseña de registro");
        rSPanelsSlider1.add(jLabel3);
        jLabel3.setBounds(440, 10, 230, 30);

        rbActivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbActivo.setForeground(new java.awt.Color(0, 112, 192));
        rbActivo.setText("Activo");
        rSPanelsSlider1.add(rbActivo);
        rbActivo.setBounds(430, 160, 93, 30);

        rbInactivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbInactivo.setForeground(new java.awt.Color(0, 112, 192));
        rbInactivo.setText("Inactivo");
        rSPanelsSlider1.add(rbInactivo);
        rbInactivo.setBounds(540, 160, 75, 30);
        rSPanelsSlider1.add(txtClave);
        txtClave.setBounds(430, 100, 250, 42);

        jPanel1.add(rSPanelsSlider1);
        rSPanelsSlider1.setBounds(0, 270, 690, 200);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 690, 520);

        setSize(new java.awt.Dimension(705, 557));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        new FrmAdministradorPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        Utilidades.valiarSoloLetras(txtNombre);
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyPressed
        Utilidades.valiarSoloLetras(txtApellido);        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoKeyPressed

    private void txtNacionalidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNacionalidadKeyPressed
        Utilidades.valiarSoloLetras(txtNacionalidad);        // TODO add your handling code here:
    }//GEN-LAST:event_txtNacionalidadKeyPressed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        Utilidades.validadorDeCedula(txtCedula.getText());
        Utilidades.LimitarCaracterers(txtCedula, 10);
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        Utilidades.valiarSoloLetras(txtDireccion);        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        Utilidades.esEmail(txtEmail.getText());       // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        Utilidades.valiarSoloNumeros(txtTelefono);
        Utilidades.LimitarCaracterers(txtTelefono, 11);
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        guardar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAdministradorRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdministradorRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdministradorRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdministradorRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmAdministradorRegistros dialog = new FrmAdministradorRegistros(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnCancelar;
    private rojeru_san.RSButton btnDarBaja;
    private rojeru_san.RSButton btnGuardar;
    private rojeru_san.RSButton btnVolver;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.RSMTextFull rSMTextFull1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private rojeru_san.RSPanelsSlider rSPanelsSlider1;
    private javax.swing.JRadioButton rbActivo;
    private javax.swing.JRadioButton rbCajero;
    private javax.swing.JRadioButton rbInactivo;
    private javax.swing.JRadioButton rbRCajero;
    private javax.swing.JRadioButton rbRServicios;
    private javax.swing.JRadioButton rbServicios;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tblVerListado;
    private rojeru_san.RSMTextFull txtApellido;
    private rojeru_san.RSMTextFull txtCedula;
    private rojeru_san.RSMPassView txtClave;
    private rojeru_san.RSMTextFull txtDireccion;
    private rojeru_san.RSMTextFull txtEmail;
    private rojeru_san.RSMTextFull txtNacionalidad;
    private rojeru_san.RSMTextFull txtNombre;
    private rojeru_san.RSMTextFull txtTelefono;
    private rojeru_san.RSMTextFull txtUsuario;
    // End of variables declaration//GEN-END:variables
}
