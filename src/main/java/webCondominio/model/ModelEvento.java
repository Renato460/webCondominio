package webCondominio.model;

import java.sql.Date;

public class ModelEvento {
    private Integer idEvento;
    private String fecha;
    private String descripcion;

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public ModelEvento(Integer idEvento, String fecha, String descripcion) {
        this.idEvento = idEvento;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
