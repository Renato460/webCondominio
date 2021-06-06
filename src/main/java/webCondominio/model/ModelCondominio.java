package webCondominio.model;

public class ModelCondominio {

    private int idCondominio;
    private String nombre;

    public ModelCondominio(int idCondominio, String nombre) {
        this.idCondominio = idCondominio;
        this.nombre = nombre;
    }

    public int getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(int idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
