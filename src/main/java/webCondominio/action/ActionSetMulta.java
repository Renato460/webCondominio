package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;


public class ActionSetMulta extends ActionSupport implements ServletRequestAware {

    @Override
    public String execute() throws Exception{
        String rut = request.getParameter("rutResidente");
        String descripcion = request.getParameter("descMulta");
        Integer montoMulta = Integer.parseInt(request.getParameter("montoMulta"));
        ControllerConexion conexion = new ControllerConexion();
        this.resultado = conexion.setMulta(rut,descripcion,montoMulta);
        conexion.cerrarSession();
        return SUCCESS;
    }

    private int resultado;
    private HttpServletRequest request;
    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}
