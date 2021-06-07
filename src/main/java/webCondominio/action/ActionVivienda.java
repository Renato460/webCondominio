package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelCondominio;
import webCondominio.model.ModelVivienda;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ActionVivienda extends ActionSupport implements ServletRequestAware {
    private ArrayList<ModelVivienda> vivienda;
    private HttpServletRequest request;
    public ArrayList<ModelVivienda> getVivienda() {
        return vivienda;
    }

    public void setVivienda(ArrayList<ModelVivienda> vivienda) {
        this.vivienda = vivienda;
    }

    @Override
    public String execute() throws Exception {

        ControllerConexion conexion = new ControllerConexion();
        Integer idCondo = Integer.parseInt(request.getParameter("idCondo"));
        this.vivienda = conexion.getViviendas(idCondo);
        conexion.cerrarSession();
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
}
