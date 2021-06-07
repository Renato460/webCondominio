package webCondominio.model;

public class ModelPlanillaGC {
    private int nroVivienda;
    private String fecha;
    private int montoTotal;
    private String fechavenc;
    private int isvalid;
    private String rut;
    private String Nombre;
    private String Apaterno;
    private int idPlanilla;

    public ModelPlanillaGC(int nroVivienda, String fecha, int montoTotal, String fechavenc, int isvalid, String rut, String nombre, String apaterno, int idPlanilla) {
        this.nroVivienda = nroVivienda;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.fechavenc = fechavenc;
        this.isvalid = isvalid;
        this.rut = rut;
        this.Nombre = nombre;
        this.Apaterno = apaterno;
        this.idPlanilla = idPlanilla;
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
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApaterno() {
        return Apaterno;
    }

    public void setApaterno(String apaterno) {
        Apaterno = apaterno;
    }



    public int getNroVivienda() {
        return nroVivienda;
    }

    public void setNroVivienda(int nroVivienda) {
        this.nroVivienda = nroVivienda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getFechavenc() {
        return fechavenc;
    }

    public void setFechavenc(String fechavenc) {
        this.fechavenc = fechavenc;
    }

    public int getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(int isvalid) {
        this.isvalid = isvalid;
    }
}
