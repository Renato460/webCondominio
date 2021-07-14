package webCondominio.model;



public class ModelVivienda {
    private int idVivienda;
    private int nroVivienda;
    private String titular;
    private String rutTitular;

    public ModelVivienda(int idVivienda, int nroVivienda, String tiTular, String rutTitular) {
        this.idVivienda = idVivienda;
        this.nroVivienda = nroVivienda;
        this.titular = tiTular;
        this.rutTitular = rutTitular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String tiTular) {
        titular = tiTular;
    }

    public String getRutTitular() {
        return rutTitular;
    }

    public void setRutTitular(String rutTitular) {
        this.rutTitular = rutTitular;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public int getNroVivienda() {
        return nroVivienda;
    }

    public void setNroVivienda(int nroVivienda) {
        this.nroVivienda = nroVivienda;
    }
}
