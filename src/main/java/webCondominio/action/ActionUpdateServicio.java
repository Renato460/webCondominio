package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionUpdateServicio extends ActionSupport implements ServletRequestAware {

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));
        String nombre = request.getParameter("descripcion");
        int costo = Integer.parseInt(request.getParameter("monto"));
        this.respuesta = conexion.updateServicio(idServicio, nombre, costo);
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
        this.request=request;
    }
}
