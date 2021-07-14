package webCondominio.action;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelCondominio;
import webCondominio.model.ModelLoginUsuario;

import java.util.Map;

public class ActionGetCondoUsu extends ActionSupport implements SessionAware {


    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        String rut = ((ModelLoginUsuario)session.get("user")).getRut();
        this.condominio=conexion.getCondoUsuario(rut);
        return SUCCESS;
    }
    private Map<String,Object> session;
    private ModelCondominio condominio;

    public ModelCondominio getCondominio() {
        return condominio;
    }

    public void setCondominio(ModelCondominio condominio) {
        this.condominio = condominio;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }
}
