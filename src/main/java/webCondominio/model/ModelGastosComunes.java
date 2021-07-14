package webCondominio.model;

public class ModelGastosComunes {
    private int idGastocomun;
    private String descripcion;
    private int valor;
    public ModelGastosComunes(int idGastocomun, String descripcion, int valor) {
        this.idGastocomun = idGastocomun;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public int getIdGastocomun() {
        return idGastocomun;
    }

    public void setIdGastocomun(int idGastocomun) {
        this.idGastocomun = idGastocomun;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
