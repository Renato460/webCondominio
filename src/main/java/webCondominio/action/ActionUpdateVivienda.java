package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionUpdateVivienda extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute() throws Exception {
        this.idVivienda=Integer.parseInt(request.getParameter("idVivienda"));
        this.nroVivienda=Integer.parseInt(request.getParameter("nroVivienda"));
        this.titular=request.getParameter("titular");
        this.ruttitular=request.getParameter("ruttitular");
        ControllerConexion conexion = new ControllerConexion();
        this.resultado=conexion.updateVivienda(idVivienda,nroVivienda,titular,ruttitular);
        conexion.cerrarSession();
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
    private int idVivienda;
    private int nroVivienda;
    private int resultado;
    private String titular;
    private String ruttitular;
    private HttpServletRequest request;

    public int getNroVivienda() {
        return nroVivienda;
    }

    public void setNroVivienda(int nroVivienda) {
        this.nroVivienda = nroVivienda;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getRuttitular() {
        return ruttitular;
    }

    public void setRuttitular(String ruttitular) {
        this.ruttitular = ruttitular;
    }
}
