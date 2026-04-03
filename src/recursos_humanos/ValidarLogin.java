
package recursos_humanos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidarLogin {
    public boolean validarCredenciales(String usuario, String contraseña) {
        Conexion con = new Conexion();
        Connection cn = con.establecerConexion();
        
        if (cn == null) {
            System.out.println("Conexión nula, no se puede validar.");
            return false;
        }

        String sql = "SELECT * FROM Usuarios WHERE Usuario = ? AND Contraseña = ?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);

            ResultSet rs = pst.executeQuery();

            return rs.next(); // true si encontró el usuario

        } catch (Exception e) {
            System.out.println("Error al validar credenciales: " + e);
            return false;
        }
    }
}
