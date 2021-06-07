package webCondominio.model;



public class ModelVivienda {
    private int idVivienda;
    private int nroVivienda;


    public ModelVivienda(int idVivienda, int numero) {
        this.idVivienda=idVivienda;
        this.nroVivienda=numero;
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
