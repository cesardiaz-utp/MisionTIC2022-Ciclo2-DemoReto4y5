package co.edu.utp.misiontic2022.c2.cdiaz.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.cdiaz.model.vo.ProyectosVo;
import co.edu.utp.misiontic2022.c2.cdiaz.util.JDBCUtilities;

public class ProyectosDao {

    public List<ProyectosVo> listarProyectos(String clasificacion1, String clasificacion2) throws SQLException {
        List<ProyectosVo> respuesta = new ArrayList<>();
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            var query = "SELECT CIUDAD, CLASIFICACION, COUNT(*) TOTAL, MIN(FECHA_INICIO) VIEJO, MAX(FECHA_INICIO) RECIENTE"
                + " FROM PROYECTO P" 
                + " WHERE CLASIFICACION NOT IN (?, ?)" 
                + " GROUP BY CIUDAD , CLASIFICACION"
                + " ORDER BY CIUDAD , CLASIFICACION";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, clasificacion1);
            stmt.setString(2, clasificacion2);
            rset = stmt.executeQuery();

            while(rset.next()){
                var vo = new ProyectosVo();
                vo.setCiudad(rset.getString("CIUDAD"));
                vo.setClasificacion(rset.getString("CLASIFICACION"));
                vo.setTotal(rset.getInt("TOTAL"));
                vo.setViejo(rset.getString("VIEJO"));
                vo.setReciente(rset.getString("RECIENTE"));

                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
}
