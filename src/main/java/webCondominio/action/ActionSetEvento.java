package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;

import org.apache.struts2.interceptor.ServletRequestAware;


import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

public class ActionSetEvento extends ActionSupport implements ServletRequestAware {
    /**
     *
     */
    private static final long serialVersionUID = -7380781091158854113L;
    @Override
    public String execute () {

        String fecha=request.getParameter("fecha");
        Date fechaEv = Date.valueOf(fecha);
        String descripcion=request.getParameter("descripcion");
        Integer idCondominio= Integer.parseInt(request.getParameter("idCondominio"));
        ControllerConexion conexion=new ControllerConexion();
        this.resultado=conexion.setEventos(fechaEv, descripcion, idCondominio);
        conexion.cerrarSession();
        return SUCCESS;
    }
    private HttpServletRequest request;
    @Override
    public void setServletRequest(HttpServletRequest request) {this.request=request;}

    private Integer resultado;
    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }


}
