package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;

import javax.servlet.http.HttpServletRequest;

public class ActionSetCondominio extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute() throws Exception {
        this.nombre=request.getParameter("nombre");
        this.numero=Integer.parseInt(request.getParameter("numero"));
        this.calle=request.getParameter("calle");
        this.idComuna=Integer.parseInt(request.getParameter("idComuna"));
        ControllerConexion conexion = new ControllerConexion();
        this.resultado=conexion.setCondominio(nombre,numero,calle,idComuna);
        conexion.cerrarSession();
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
    private String nombre;
    private int numero;
    private String calle;
    private int idComuna;
    private int resultado;
    private HttpServletRequest request;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }


}
