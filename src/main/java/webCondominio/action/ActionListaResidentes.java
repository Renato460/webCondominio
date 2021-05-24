package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelPerfilUsuario;

import java.util.ArrayList;

public class ActionListaResidentes extends ActionSupport {
    @Override
    public String execute() throws Exception {
        ControllerConexion residente = new ControllerConexion();
        listaResidentes = residente.getResidentes(4);
        residente.cerrarSession();

        return SUCCESS;
    }

    private ArrayList<ModelPerfilUsuario> listaResidentes;

    public ArrayList<ModelPerfilUsuario> getListaResidentes() {
        return listaResidentes;
    }

    public void setListaResidentes(ArrayList<ModelPerfilUsuario> listaResidentes) {
        this.listaResidentes = listaResidentes;
    }
}
