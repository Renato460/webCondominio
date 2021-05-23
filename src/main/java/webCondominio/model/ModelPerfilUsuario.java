package webCondominio.model;

import java.sql.Date;

public class ModelPerfilUsuario {
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String run;
    private String nacionalidad;
    private String telefono;
    private String correo;
    private String fechai;
    private int cantidad_multas;

    public ModelPerfilUsuario(String nombre, String aPaterno, String aMaterno, String run, String nacionalidad, String telefono, String correo, int cantidad_multas,String fechai) {
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.run = run;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.correo = correo;
        this.cantidad_multas = cantidad_multas;
        this.fechai= fechai;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCantidad_multas() {
        return cantidad_multas;
    }

    public void setCantidad_multas(int cantidad_multas) {
        this.cantidad_multas = cantidad_multas;
    }

    public String getFechai() {
        return fechai;
    }

    public void setFechai(String fechai) {
        this.fechai = fechai;
    }
}
