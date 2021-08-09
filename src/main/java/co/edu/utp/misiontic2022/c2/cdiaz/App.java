package co.edu.utp.misiontic2022.c2.cdiaz;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.cdiaz.model.dao.ProyectosDao;
import co.edu.utp.misiontic2022.c2.cdiaz.model.vo.ProyectosVo;
import co.edu.utp.misiontic2022.c2.cdiaz.util.JDBCUtilities;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            var pd = new ProyectosDao();
            var lista = pd.listarProyectos("Casa Campestre", "Condominio");
            for (ProyectosVo proyecto : lista) {
                System.out.println(proyecto);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
