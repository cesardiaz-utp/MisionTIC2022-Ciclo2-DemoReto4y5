package co.edu.utp.misiontic2022.c2.cdiaz;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.cdiaz.util.JDBCUtilities;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            var conn = JDBCUtilities.getConnection();
            System.out.println("Conexión exitosa");
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e);

        }
    }
}
