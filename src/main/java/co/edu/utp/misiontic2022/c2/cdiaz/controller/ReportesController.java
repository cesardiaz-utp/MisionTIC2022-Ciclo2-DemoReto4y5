package co.edu.utp.misiontic2022.c2.cdiaz.controller;

import java.sql.SQLException;
import java.util.List;

import co.edu.utp.misiontic2022.c2.cdiaz.model.dao.ProyectosDao;
import co.edu.utp.misiontic2022.c2.cdiaz.model.vo.ProyectosVo;

public class ReportesController {

    private ProyectosDao proyectosDao;

    public ReportesController() {
        proyectosDao = new ProyectosDao();
    }

    public List<ProyectosVo> listarProyectosExcluyendoClasificaciones(String clasificacion1, String clasificacion2) throws SQLException {
        return proyectosDao.listarProyectos(clasificacion1, clasificacion2);
    }

}
