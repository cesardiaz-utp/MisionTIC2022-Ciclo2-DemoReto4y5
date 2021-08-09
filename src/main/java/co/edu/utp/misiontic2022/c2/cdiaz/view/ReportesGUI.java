package co.edu.utp.misiontic2022.c2.cdiaz.view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import co.edu.utp.misiontic2022.c2.cdiaz.controller.ReportesController;
import co.edu.utp.misiontic2022.c2.cdiaz.model.vo.ProyectosVo;

public class ReportesGUI extends JFrame {

    private JTable tabla;
    private ReportesController controller;

    public ReportesGUI() {
        controller = new ReportesController();

        initUI();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void initUI() {
        setTitle("Demo del reto 4 y 5 ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        var panel = new JPanel();
        getContentPane().add(panel, BorderLayout.PAGE_START);
        var btnProyectos = new JButton("Proyectos NO casas campestres ni condominios");
        btnProyectos.addActionListener(e -> cargarTablaProyectosSinCasasCampestresNiCondominios());
        panel.add(btnProyectos);

        tabla = new JTable();
        getContentPane().add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    private void cargarTablaProyectosSinCasasCampestresNiCondominios() {
        try {
            var tableModel = new ProyectosTableModel();

            var lista = controller.listarProyectosExcluyendoClasificaciones("Casa Campestre", "Condominio");

            tableModel.setData(lista);

            tabla.setModel(tableModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class ProyectosTableModel extends AbstractTableModel {
        private List<ProyectosVo> proyectos;

        public ProyectosTableModel(){
            proyectos = new ArrayList<>();
        }

        public void setData(List<ProyectosVo> data) {
            proyectos = data;
            fireTableDataChanged();
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 2:
                    return Integer.class;
                default:
                    return String.class;
            }
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Ciudad";
                case 1:
                    return "Clasificación";
                case 2:
                    return "Total";
                case 3:
                    return "Viejo";
                case 4:
                    return "Reciente";
            }

            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return proyectos.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var proyecto = proyectos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return proyecto.getCiudad();
                case 1:
                    return proyecto.getClasificacion();
                case 2:
                    return proyecto.getTotal();
                case 3:
                    return proyecto.getViejo();
                case 4:
                    return proyecto.getReciente();
            }
            return null;
        }

    }

}
