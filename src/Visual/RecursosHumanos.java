package Visual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import recursos_humanos.Conexion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jhony
 */
public class RecursosHumanos extends javax.swing.JFrame {

    /**
     * Creates new form RecursosHumanos
     */
    public RecursosHumanos() {
        initComponents();
    }
    private void cargarTabla() {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID","NomApe", "Fecha_Ingreso", "Nombre_Oficina", "Nombre_Regimen", "Sueldo", "Nombre_Cargo"});


        Conexion conexion = new Conexion();
        Connection cn = conexion.establecerConexion();

        try {
            String sql = "SELECT E.ID_Empleado, E.NomApe, E.Fecha_Ingreso, O.Nombre AS Nombre_Oficina, " +
                         "R.Nombre AS Nombre_Regimen, E.Sueldo, C.Nombre AS Nombre_Cargo " +
                         "FROM Empleados AS E " +
                         "JOIN Cargo AS C ON E.ID_Cargo = C.ID_Cargo " +
                         "JOIN Oficina AS O ON E.ID_Oficina = O.ID_Oficina " +
                         "JOIN Regimen_Laboral AS R ON E.ID_Regimen = R.ID_Regimen;";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ID_Empleado = rs.getString("ID_Empleado");
                String NomApe = rs.getString("NomApe");
                String Fecha_Ingreso = rs.getString("Fecha_Ingreso");
                String Nombre_Oficina = rs.getString("Nombre_Oficina");
                String Nombre_Regimen = rs.getString("Nombre_Regimen");
                String Sueldo = rs.getString("Sueldo");
                String Nombre_Cargo = rs.getString("Nombre_Cargo");

                modelo.addRow(new Object[]{ID_Empleado, NomApe, Fecha_Ingreso, Nombre_Oficina, Nombre_Regimen, Sueldo, Nombre_Cargo});
            }

            tablaGeneral.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.toString());
        }
    }
    
    private void cargarTablaLicencias() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{ 
        "ID_Licencias", "Nombre_Empleado", "Fecha_Solicitud", "ID_Tipo",
        "Fecha_Inicio", "Fecha_Fin", "ID_Modalidad", "ID_Estado" 
    });

    Conexion conexion = new Conexion();
    Connection cn = conexion.establecerConexion();

    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT l.ID_Licencias, e.NomApe AS Nombre_Empleado, l.Fecha_Solicitud, l.ID_Tipo, " +
            "l.Fecha_Inicio, l.Fecha_Fin, l.ID_Modalidad, l.ID_Estado " +
            "FROM Licencias l " +
            "INNER JOIN Empleados e ON l.ID_Empleado = e.ID_Empleado"
        );

        while (rs.next()) {
            String idLicencia = rs.getString("ID_Licencias");
            String nombreEmpleado = rs.getString("Nombre_Empleado");
            String fechaSolicitud = rs.getString("Fecha_Solicitud");
            String idTipo = rs.getString("ID_Tipo");
            String fechaInicio = rs.getString("Fecha_Inicio");
            String fechaFin = rs.getString("Fecha_Fin");
            String idModalidad = rs.getString("ID_Modalidad");
            String idEstado = rs.getString("ID_Estado");

            modelo.addRow(new Object[]{
                idLicencia, nombreEmpleado, fechaSolicitud, idTipo,
                fechaInicio, fechaFin, idModalidad, idEstado
            });
        }

        tablaGeneral.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.toString());
    }
}


    
    private void cargarTablaConcepto() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{
        "ID_Concepto", "Descripcion", "Monto", "Tasa", "ID_TipoC", "ID_Situacion"
    });

    Conexion conexion = new Conexion();
    Connection cn = conexion.establecerConexion();

    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT ID_Concepto, Descripcion, Monto, Tasa, ID_TipoC, ID_Situacion FROM Concepto");

        while (rs.next()) {
            int id = rs.getInt("ID_Concepto");
            String descripcion = rs.getString("Descripcion");
            double monto = rs.getDouble("Monto");
            double tasa = rs.getDouble("Tasa");
            int tipoC = rs.getInt("ID_TipoC");
            int situacion = rs.getInt("ID_Situacion");

            modelo.addRow(new Object[]{
                id, descripcion, monto, tasa, tipoC, situacion
            });
        }

        tablaGeneral.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar datos de Concepto: " + e.toString());
    }
}

private void cargarTablaPlanilla() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{
        "ID_Planilla", "Empleado", "Periodo", "Faltas", "Tardanzas", "Sueldo_Neto"
    });

    Conexion conexion = new Conexion();
    Connection cn = conexion.establecerConexion();

    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT pr.ID_Planilla, e.NomApe AS Nombre_Empleado, pr.Periodo, pr.Faltas, pr.Tardanzas, pr.Sueldo_Neto " +
            "FROM Planilla_Remuneraciones pr " +
            "INNER JOIN Empleados e ON pr.ID_Empleado = e.ID_Empleado"
        );

        while (rs.next()) {
            String idPlanilla = rs.getString("ID_Planilla");
            String nombreEmpleado = rs.getString("Nombre_Empleado");
            String periodo = rs.getString("Periodo");
            int faltas = rs.getInt("Faltas");
            int tardanzas = rs.getInt("Tardanzas");
            double sueldoNeto = rs.getDouble("Sueldo_Neto");

            modelo.addRow(new Object[]{
                idPlanilla, nombreEmpleado, periodo, faltas, tardanzas, sueldoNeto
            });
        }

        tablaGeneral.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar datos de Planilla: " + e.toString());
    }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnEmpleados = new javax.swing.JButton();
        btnLicencias = new javax.swing.JButton();
        btnConcepto = new javax.swing.JButton();
        btnRenumeraciones = new javax.swing.JButton();
        btnOtraCuenta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGeneral = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(20, 70, 102));

        btnEmpleados.setBackground(new java.awt.Color(20, 70, 102));
        btnEmpleados.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setText("Empleados");
        btnEmpleados.setBorderPainted(false);
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnLicencias.setBackground(new java.awt.Color(20, 70, 102));
        btnLicencias.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        btnLicencias.setForeground(new java.awt.Color(255, 255, 255));
        btnLicencias.setText("Licencias");
        btnLicencias.setBorderPainted(false);
        btnLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLicenciasActionPerformed(evt);
            }
        });

        btnConcepto.setBackground(new java.awt.Color(20, 70, 102));
        btnConcepto.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        btnConcepto.setForeground(new java.awt.Color(255, 255, 255));
        btnConcepto.setText("Concepto");
        btnConcepto.setBorderPainted(false);
        btnConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConceptoActionPerformed(evt);
            }
        });

        btnRenumeraciones.setBackground(new java.awt.Color(20, 70, 102));
        btnRenumeraciones.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnRenumeraciones.setForeground(new java.awt.Color(255, 255, 255));
        btnRenumeraciones.setText("Renumeraciones");
        btnRenumeraciones.setBorderPainted(false);
        btnRenumeraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenumeracionesActionPerformed(evt);
            }
        });

        btnOtraCuenta.setBackground(new java.awt.Color(20, 70, 102));
        btnOtraCuenta.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        btnOtraCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnOtraCuenta.setText("Cambiar Cuenta");
        btnOtraCuenta.setBorderPainted(false);
        btnOtraCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtraCuentaActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuenta.png"))); // NOI18N

        txtUser.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setText("Bienvenido");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnRenumeraciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEmpleados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLicencias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConcepto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOtraCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnEmpleados)
                .addGap(18, 18, 18)
                .addComponent(btnLicencias)
                .addGap(26, 26, 26)
                .addComponent(btnConcepto)
                .addGap(18, 18, 18)
                .addComponent(btnRenumeraciones)
                .addGap(27, 27, 27)
                .addComponent(btnOtraCuenta)
                .addGap(39, 39, 39))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 490));

        tablaGeneral.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGeneralMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGeneral);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 730, 270));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setText("Recursos Humanos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 410, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, -1, -1));

        btnSalir.setBackground(new java.awt.Color(255, 51, 51));
        btnSalir.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaGeneralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGeneralMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaGeneralMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLicenciasActionPerformed
       cargarTablaLicencias();
    }//GEN-LAST:event_btnLicenciasActionPerformed

    private void btnConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConceptoActionPerformed
        cargarTablaConcepto();
    }//GEN-LAST:event_btnConceptoActionPerformed

    private void btnRenumeracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenumeracionesActionPerformed
     cargarTablaPlanilla();
    }//GEN-LAST:event_btnRenumeracionesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnOtraCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtraCuentaActionPerformed
            new login().setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnOtraCuentaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       new Eliminar().setVisible(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       new Agregar_Empleado().setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    int fila = tablaGeneral.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una fila");
        return;
    }


    String idEmpleado = tablaGeneral.getValueAt(fila, 0).toString();
    String nombre = tablaGeneral.getValueAt(fila, 1).toString();
    String fechaIngreso = tablaGeneral.getValueAt(fila, 2).toString();
    String idOficina = tablaGeneral.getValueAt(fila, 3).toString();
    String idRegimen = tablaGeneral.getValueAt(fila, 4).toString();
    String sueldo = tablaGeneral.getValueAt(fila, 5).toString();
    String idCargo = tablaGeneral.getValueAt(fila, 6).toString();


    Agregar_Empleado frm = new Agregar_Empleado();

    frm.cargarDatosParaEditar(idEmpleado, nombre, fechaIngreso, idOficina, idRegimen, sueldo, idCargo);
    frm.setVisible(true);

    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(RecursosHumanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecursosHumanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecursosHumanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecursosHumanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecursosHumanos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConcepto;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnLicencias;
    private javax.swing.JButton btnOtraCuenta;
    private javax.swing.JButton btnRenumeraciones;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaGeneral;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables

    void setnombreUsuario(String nombreUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
