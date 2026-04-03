/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visual;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import recursos_humanos.Conexion;
public class Agregar_Empleado extends javax.swing.JFrame {
  
    
    public Agregar_Empleado() {
        initComponents();
        btnActualizar.setVisible(false);
    }

    
   


private String obtenerIdOficinaPorNombre(String nombre) {
    switch (nombre) {
        case "Contabilidad y Finanzas": return "01";
        case "Operaciones y Mantenimiento": return "02";
        case "Almacén e Inventario": return "03";
        case "Seguridad y Vigilancia": return "04";
        default: return "00";
    }
}

private String obtenerIdRegimenPorNombre(String nombre) {
    switch (nombre) {
        case "Ley 25530": return "1";
        case "Ley 19990": return "2";
        default: return "0";
    }
}

private String obtenerIdCargoPorNombre(String nombre) {
    switch (nombre) {
        case "Asistente Administrativo": return "01";
        case "Auxiliar Financiero": return "02";
        case "Apoyo Administrativo": return "03";
        case "Analista de Creditos": return "04";
        case "Analista de Cobranzas": return "05";
        case "Operario de Servicios Generales": return "06";
        case "Personal de Seguridad": return "07";
        case "Supervisor de Seguridad": return "08";
        default: return "00";
    }
}


private String obtenerFechaFormateada(JDateChooser dateChooser) {
    if (dateChooser.getDate() != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dateChooser.getDate());
    }
    return null; 
}

private String nombreOficinaPorId(String id) {
    switch (id) {
        case "01": return "Contabilidad y Finanzas";
        case "02": return "Operaciones y Mantenimiento";
        case "03": return "Almacén e Inventario";
        case "04": return "Seguridad y Vigilancia";
        default: return "";
    }
}

private String nombreRegimenPorId(String id) {
    switch (id) {
        case "1": return "Ley 25530";
        case "2": return "Ley 19990";
        default: return "";
    }
}

private String nombreCargoPorId(String id) {
    switch (id) {
        case "01": return "Asistente Administrativo";
        case "02": return "Auxiliar Financiero";
        case "03": return "Apoyo Administrativo";
        case "04": return "Analista de Creditos";
        case "05": return "Analista de Cobranzas";
        case "06": return "Operario de Servicios Generales";
        case "07": return "Personal de Seguridad";
        case "08": return "Supervisor de Seguridad";
        default: return "";
    }
} 

public void cargarDatosParaEditar(String id, String nombre, String fechaIngreso, String idOficina, String idRegimen, String sueldo, String idCargo) {
    txtID.setText(id);
    txtNombre.setText(nombre);

    try {
        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaIngreso);
        txtFechaIngreso.setDate(fecha);
    } catch (Exception e) {
        e.printStackTrace();
    }

    txtSueldo.setText(sueldo);

    txtOficina.setSelectedItem(idOficina);
    txtRegimen.setSelectedItem(idRegimen);
    txtCargo.setSelectedItem(idCargo);

    txtID.setEditable(false); 
    btnAgregar.setVisible(false);
    btnActualizar.setVisible(true);
}





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtOficina = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtRegimen = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnAgregar1 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setText("AGREGAR/ACTUALIZAR EMPLEADO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel3.setText("Regimen:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("ID_Empleado:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 410, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Nombre y Apellidos: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));
        jPanel1.add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 140, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Fecha Ingreso: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        txtOficina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contabilidad y Finanzas", "Operaciones y Mantenimiento", "Almacén e Inventario", "Seguridad y Vigilancia" }));
        jPanel1.add(txtOficina, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 220, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("Cargo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        txtRegimen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ley 25530", "Ley 19990" }));
        jPanel1.add(txtRegimen, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 220, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel8.setText("Oficina: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));
        jPanel1.add(txtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 130, -1));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel9.setText("Sueldo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        txtCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asistente administrativo", "Auxiliar Financiero", "Apoyo Administrativo", "Analista de Creditos", "Analista de Cobranzas", "Operario de Servicios Generales", "Personal de Seguridad", "Supervisor de Seguridad" }));
        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 220, -1));

        btnAgregar.setBackground(new java.awt.Color(20, 70, 102));
        btnAgregar.setFont(new java.awt.Font("Tw Cen MT", 1, 21)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-hacia-atras.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setDefaultCapable(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, -1, -1));

        btnAgregar1.setBackground(new java.awt.Color(20, 70, 102));
        btnAgregar1.setFont(new java.awt.Font("Tw Cen MT", 1, 21)); // NOI18N
        btnAgregar1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar1.setText("AGREGAR");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(20, 70, 102));
        btnActualizar.setFont(new java.awt.Font("Tw Cen MT", 1, 21)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       Conexion conexion = new Conexion();
    Connection cn = conexion.establecerConexion();

    if (txtNombre.getText().isEmpty() || txtFechaIngreso.getDate()== null|| 
        txtSueldo.getText().isEmpty() || txtOficina.getSelectedItem() == null ||
        txtRegimen.getSelectedItem() == null || txtCargo.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Complete todos los campos");
        return;
    }

    try {
        String idEmpleado = txtID.getText();
        String nombre = txtNombre.getText();
        String fechaIngreso = obtenerFechaFormateada(txtFechaIngreso);
        String idOficina = obtenerIdOficinaPorNombre(txtOficina.getSelectedItem().toString());
        String idRegimen = obtenerIdRegimenPorNombre(txtRegimen.getSelectedItem().toString());
        String sueldo = txtSueldo.getText();
        String idCargo = obtenerIdCargoPorNombre(txtCargo.getSelectedItem().toString());

        String sql = "INSERT INTO EMPLEADOS (ID_Empleado, NomApe, Fecha_Ingreso, ID_Oficina, ID_Regimen, Sueldo, ID_Cargo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = cn.prepareStatement(sql);
        stmt.setString(1, idEmpleado);
        stmt.setString(2, nombre);
        stmt.setString(3, fechaIngreso);
        stmt.setString(4, idOficina);
        stmt.setString(5, idRegimen);
        stmt.setDouble(6, Double.parseDouble(sueldo));
        stmt.setString(7, idCargo);


        stmt.executeUpdate();
        stmt.close();

        JOptionPane.showMessageDialog(this, "Empleado agregado correctamente con ID: " + idEmpleado);


        txtID.setText("");
        txtNombre.setText("");
        txtFechaIngreso.setDate(null);
        txtSueldo.setText("");
        txtOficina.setSelectedIndex(0);
        txtRegimen.setSelectedIndex(0);
        txtCargo.setSelectedIndex(0);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al agregar empleado " + e.getMessage());
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Conexion conexion = new Conexion();
        Connection cn = conexion.establecerConexion();

    try {
        String idEmpleado = txtID.getText();
        String nombre = txtNombre.getText();
        String fechaIngreso = new SimpleDateFormat("yyyy-MM-dd").format(txtFechaIngreso.getDate());
        String idOficina = obtenerIdOficinaPorNombre(txtOficina.getSelectedItem().toString());
        String idRegimen = obtenerIdOficinaPorNombre(txtRegimen.getSelectedItem().toString());
        String sueldo = txtSueldo.getText();
        String idCargo = txtCargo.getSelectedItem().toString();

        String sql = "UPDATE EMPLEADOS SET NomApe=?, Fecha_Ingreso=?, ID_Oficina=?, ID_Regimen=?, Sueldo=?, ID_Cargo=? WHERE ID_Empleado=?";
        PreparedStatement stmt = cn.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, fechaIngreso);
        stmt.setString(3, idOficina);
        stmt.setString(4, idRegimen);
        stmt.setDouble(5, Double.parseDouble(sueldo));
        stmt.setString(6, idCargo);
        stmt.setString(7, idEmpleado);

        stmt.executeUpdate();
        stmt.close();

        JOptionPane.showMessageDialog(this, "Empleado actualizado correctamente.");

      
        this.dispose();
        new RecursosHumanos().setVisible(true); 

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar " + e.getMessage());
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

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
            java.util.logging.Logger.getLogger(Agregar_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_Empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> txtCargo;
    private com.toedter.calendar.JDateChooser txtFechaIngreso;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JComboBox<String> txtOficina;
    private javax.swing.JComboBox<String> txtRegimen;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}

