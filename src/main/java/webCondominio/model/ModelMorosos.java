package webCondominio.model;

public class ModelMorosos {
    int idPlanilla;
    String rut;
    String nombre;
    String fechainicial;
    String fechavencimiento;
    int montototal;



    public ModelMorosos(int idPlanilla,String rut, String nombre, String fechainicial, String fechavencimiento, int montototal) {
        this.idPlanilla= idPlanilla;
        this.rut = rut;
        this.nombre = nombre;
        this.fechainicial = fechainicial;
        this.fechavencimiento = fechavencimiento;
        this.montototal = montototal;
    }
    public int getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(int idPlanilla) {
        this.idPlanilla = idPlanilla;
    }
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(String fechainicial) {
        this.fechainicial = fechainicial;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public int getMontototal() {
        return montototal;
    }

    public void setMontototal(int montototal) {
        this.montototal = montototal;
    }
}
