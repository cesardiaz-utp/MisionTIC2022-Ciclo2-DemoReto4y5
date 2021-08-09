package co.edu.utp.misiontic2022.c2.cdiaz.view;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.cdiaz.controller.ReportesController;
import co.edu.utp.misiontic2022.c2.cdiaz.model.vo.ProyectosVo;

public class ReportesView {
    private ReportesController controller;

    public ReportesView() {
        controller = new ReportesController();
    }

    private String repitaCaracter(Character caracter, Integer veces) {
        var respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void imprimirProyectosSinCasaCampestreNiCondominio() {
        try {
            System.out.println(repitaCaracter('=', 5) + " LISTADO DE PROYECTOS SIN CASAS CAMPESTRES NI CONDOMINIOS "
                    + repitaCaracter('=', 5));
            System.out.println(String.format("%-20s %-15s %-7s %-10s %-10s", "CIUDAD", "CLASIFICACION", "TOTAL",
                    "VIEJO", "RECIENTE"));
            System.out.println(repitaCaracter('-', 68));

            var lista = controller.listarProyectosExcluyendoClasificaciones("Casa Campestre", "Condominio");
            for (ProyectosVo proyecto : lista) {
                System.out.printf("%-20s %-15s %7d %-10s %-10s %n", proyecto.getCiudad(), proyecto.getClasificacion(),
                        proyecto.getTotal(), proyecto.getViejo(), proyecto.getReciente());
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
