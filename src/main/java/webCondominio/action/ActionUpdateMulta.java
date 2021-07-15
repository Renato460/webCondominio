package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionUpdateMulta extends ActionSupport implements ServletRequestAware {

    @Override
    public String execute() throws Exception {

        ControllerConexion conexion = new ControllerConexion();
        int idMulta = Integer.parseInt(request.getParameter("idMulta"));
        String descripcion = request.getParameter("descripcion");
        System.out.println(request.getParameter("monto"));
        int monto = Integer.parseInt(request.getParameter("monto"));
        respuesta = conexion.updateMulta(idMulta,descripcion,monto);
        conexion.cerrarSession();
        return SUCCESS;
    }

    private int respuesta;
    private HttpServletRequest request;

    public int getRespuesta() {
        return respuesta;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}
