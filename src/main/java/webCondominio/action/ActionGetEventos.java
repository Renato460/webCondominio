package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelEvento;

import org.apache.struts2.interceptor.ServletRequestAware;


import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ActionGetEventos extends ActionSupport implements ServletRequestAware {
    @Override
    public String execute () {

        Integer idCondominio= Integer.parseInt(request.getParameter("idCondominio"));
        System.out.println(idCondominio);
        ControllerConexion conexion=new ControllerConexion();
        this.resultado=conexion.getEventos(idCondominio);
        conexion.cerrarSession();
        return SUCCESS;
    }
    private HttpServletRequest request;
    @Override
    public void setServletRequest(HttpServletRequest request) {this.request=request;}

    private ArrayList <ModelEvento> resultado;
    public ArrayList <ModelEvento> getResultado() {
        return resultado;
    }

    public void setResultado(ArrayList <ModelEvento> resultado) {
        this.resultado = resultado;
    }


}
