package co.edu.utp.misiontic2022.c2.cdiaz.model.vo;

public class ProyectosVo {
    private String ciudad;
    private String clasificacion;
    private Integer total;
    private String viejo;
    private String reciente;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getViejo() {
        return viejo;
    }

    public void setViejo(String viejo) {
        this.viejo = viejo;
    }

    public String getReciente() {
        return reciente;
    }

    public void setReciente(String reciente) {
        this.reciente = reciente;
    }

    @Override
    public String toString() {
        return "ProyectosVo [ciudad=" + ciudad + ", clasificacion=" + clasificacion + ", reciente=" + reciente
                + ", total=" + total + ", viejo=" + viejo + "]";
    }

    

}
