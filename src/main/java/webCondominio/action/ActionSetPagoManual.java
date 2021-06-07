package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionSetPagoManual extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute() throws Exception {
        Integer idPlanilla = Integer.parseInt(request.getParameter("idPlanilla"));
        ControllerConexion conexion = new ControllerConexion();
        this.resultado = conexion.setPagoManual(idPlanilla);
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
