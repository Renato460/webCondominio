package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;


public class ActionUpdateEvento extends ActionSupport implements ServletRequestAware {


    @Override
    public String execute() throws Exception {
        this.idEvento=Integer.parseInt(request.getParameter("idEvento"));
        this.descripcion = request.getParameter("descripcion");
        System.out.println(idEvento);
        System.out.println(descripcion);
        ControllerConexion conexion = new ControllerConexion();
        this.resultado = conexion.updateEvento(idEvento,descripcion);
        conexion.cerrarSession();
        return SUCCESS;
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
    private HttpServletRequest request;
    private int idEvento;
    private String descripcion;
    private int resultado;
    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
