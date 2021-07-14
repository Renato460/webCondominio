package webCondominio.action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelGastosComunes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
public class ActionGetGastosComunes extends ActionSupport implements ServletRequestAware {
    private ArrayList <ModelGastosComunes> gastocomun;
    private HttpServletRequest request;

    public ArrayList<ModelGastosComunes> getGastocomun() {
        return gastocomun;
    }

    public void setGastocomun(ArrayList<ModelGastosComunes> gastocomun) {
        this.gastocomun = gastocomun;
    }

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        Integer idCondo = Integer.parseInt(request.getParameter("idCondo"));
        this.gastocomun=conexion.getGastosComunes(idCondo);
        conexion.cerrarSession();
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
}
