package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelCondominio;

import java.util.ArrayList;

public class ActionCondominios extends ActionSupport {
    private ArrayList <ModelCondominio> condominio;

    public ArrayList<ModelCondominio> getCondominio() {
        return condominio;
    }

    public void setCondominio(ArrayList<ModelCondominio> condominio) {
        this.condominio = condominio;
    }

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
         this.condominio = conexion.getCondominios();
         conexion.cerrarSession();
         return SUCCESS;
    }
}
