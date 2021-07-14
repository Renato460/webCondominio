package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionDeleteUsuario extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute() throws Exception {
        String rut = request.getParameter("rut");
        ControllerConexion conexion = new ControllerConexion();
        this.resultado=conexion.DeleteUsuario(rut);
        conexion.cerrarSession();
        return SUCCESS;
    }
    private HttpServletRequest request;
    private int resultado;

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
}
