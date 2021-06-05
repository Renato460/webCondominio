package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelMulta;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ActionMultaDirectorio extends ActionSupport implements ServletRequestAware {

    public String execute(){
        ControllerConexion multa = new ControllerConexion();
        String rut = request.getParameter("rut");
        System.out.println(rut);
        numeroMultas = multa.multas(rut);
        multa.cerrarSession();
        return SUCCESS;
    }

    private ArrayList<ModelMulta> numeroMultas;

    public ArrayList<ModelMulta> getNumeroMultas() {
        return numeroMultas;
    }

    public void setNumeroMultas(ArrayList<ModelMulta> numeroMultas) {
        this.numeroMultas = numeroMultas;
    }

    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        // TODO Auto-generated method stub
        this.request = request;
    }
}
