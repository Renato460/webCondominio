package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionDeleteEvento extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute() throws Exception {
        Integer idEvento=Integer.parseInt(request.getParameter("idEvento"));
        ControllerConexion conexion = new ControllerConexion();
        this.resultado=conexion.DeleteEvento(idEvento);
        conexion.cerrarSession();
        return SUCCESS;
    }

    private HttpServletRequest request;
    private int resultado;
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
}
