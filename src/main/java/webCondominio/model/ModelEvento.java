package webCondominio.model;

import java.sql.Date;

public class ModelEvento {
    private Integer id;
    private String fecha;
    private String descripcion;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public ModelEvento(Integer id, String fecha, String descripcion) {
        super();
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
