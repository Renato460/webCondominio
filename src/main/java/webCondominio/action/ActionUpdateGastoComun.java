package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;
import javax.servlet.http.HttpServletRequest;

public class ActionUpdateGastoComun extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute() throws Exception {
        this.idGastocomun=Integer.parseInt(request.getParameter("idGastocomun"));
        this.descripcion=request.getParameter("descripcion");
        this.valor=Integer.parseInt(request.getParameter("valor"));
        ControllerConexion conexion = new ControllerConexion();
        this.resultado = conexion.updateGastoComun(idGastocomun,descripcion,valor);
        conexion.cerrarSession();
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
    private int idGastocomun;
    private String descripcion;
    private int valor;
    private int resultado;
    private HttpServletRequest request;
    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }


    public int getIdGastocomun() {
        return idGastocomun;
    }

    public void setIdGastocomun(int idGastocomun) {
        this.idGastocomun = idGastocomun;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


}
