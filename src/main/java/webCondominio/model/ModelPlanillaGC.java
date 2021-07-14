package webCondominio.model;

public class ModelPlanillaGC {
    private int idPlanilla;
    private String fecha;
    private int montoTotal;
    private String fechavenc;
    private String isvalid;
    private int montoReserva;
    private  String fechaPago;
    private int montoGastoComun;
    private int nroVivienda;
    private String rut;
    private String Nombre;
    private String Apaterno;

    public ModelPlanillaGC() {
    }

    public ModelPlanillaGC(int idPlanilla, String fecha, int montoTotal, String fechavenc, String isvalid, int montoReserva, String fechaPago, int montoGastoComun, int nroVivienda, String rut, String nombre, String apaterno) {
        this.idPlanilla = idPlanilla;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.fechavenc = fechavenc;
        this.isvalid = isvalid;
        this.montoReserva = montoReserva;
        this.fechaPago = fechaPago;
        this.montoGastoComun = montoGastoComun;
        this.nroVivienda = nroVivienda;
        this.rut = rut;
        this.Nombre = nombre;
        this.Apaterno = apaterno;
    }

    public ModelPlanillaGC(int nroVivienda, String fecha, int montoTotal, String fechavenc, String isvalid, String rut, String nombre, String apaterno, int idPlanilla) {
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

    public int getMontoReserva() {
        return montoReserva;
    }

    public void setMontoReserva(int montoReserva) {
        this.montoReserva = montoReserva;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getMontoGastoComun() {
        return montoGastoComun;
    }

    public void setMontoGastoComun(int montoGastoComun) {
        this.montoGastoComun = montoGastoComun;
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

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }
}
