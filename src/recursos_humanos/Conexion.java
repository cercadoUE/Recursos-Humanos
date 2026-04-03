
package recursos_humanos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conectar = null;

    String usuario = "sa";     
    String contraseña = "123456789";
    String bd = "RRHH";
    String ip = "localhost";
    String puerto = "1433";

    public Connection establecerConexion() {
        try {

            String cadena = "jdbc:sqlserver://localhost:" + puerto + ";" +
                "databaseName=" + bd + ";" +
                "encrypt=true;" +
                "trustServerCertificate=true;";


            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            System.out.println("Se conectó a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos:\n" + e.toString());
            e.printStackTrace();
        }
        return conectar;
    }
}
