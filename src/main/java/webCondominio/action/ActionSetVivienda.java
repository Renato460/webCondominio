package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionSetVivienda extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute() throws Exception {
        this.nroVivienda=Integer.parseInt(request.getParameter("nroVivienda"));
        this.idCondominio=Integer.parseInt(request.getParameter("idCondominio"));
        ControllerConexion conexion = new ControllerConexion();
        this.resultado=conexion.setVivienda(nroVivienda,idCondominio);
        conexion.cerrarSession();
        return SUCCESS;
    }

    private int nroVivienda;
    private int idCondominio;
    private int resultado;

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    private HttpServletRequest request;

    public int getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(int idCondominio) {
        this.idCondominio = idCondominio;
    }


    public int getNroVivienda() {
        return nroVivienda;
    }

    public void setNroVivienda(int nroVivienda) {
        this.nroVivienda = nroVivienda;
    }



    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
}
