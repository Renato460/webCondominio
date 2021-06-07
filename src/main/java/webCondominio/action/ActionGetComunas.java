package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelComunas;

import javax.servlet.http.HttpServletRequest;

public class ActionGetComunas extends ActionSupport implements ServletRequestAware {
    private ArrayList <ModelComunas> comunas;
    private HttpServletRequest request;
    public ArrayList<ModelComunas> getComunas() {
        return comunas;
    }

    public void setComunas(ArrayList<ModelComunas> comunas) {
        this.comunas = comunas;
    }

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        Integer idRegion = Integer.parseInt(request.getParameter("idRegion"));
        System.out.println(idRegion);
        this.comunas=conexion.getComunas(idRegion);
        conexion.cerrarSession();
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
}
