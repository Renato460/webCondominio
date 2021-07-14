package webCondominio.action;

import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionSupport;
public class ActionDeleteGastoComun extends ActionSupport implements ServletRequestAware {

    @Override
    public String execute() throws Exception {
        Integer idGastocomun = Integer.parseInt(request.getParameter("idGastocomun"));
        ControllerConexion conexion = new ControllerConexion();
        this.resultado=conexion.DeleteGastoComun(idGastocomun);
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
    public void setServletRequest(HttpServletRequest request) {this.request=request;}
}
