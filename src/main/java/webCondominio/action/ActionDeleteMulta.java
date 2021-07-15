package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionDeleteMulta extends ActionSupport implements ServletRequestAware {

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        int idMulta = Integer.parseInt(request.getParameter("idMulta"));
        this.respuesta=conexion.deleteMulta(idMulta);
        conexion.cerrarSession();
        return SUCCESS;
    }


    private int respuesta;
    private HttpServletRequest request;
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public int getRespuesta() {
        return respuesta;
    }
}
