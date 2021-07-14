package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelLoginUsuario;
import webCondominio.model.ModelPlanillaGC;

import java.util.ArrayList;
import java.util.Map;

public class ActionGetPlanillaByRut extends ActionSupport implements SessionAware {




    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        String rut = ((ModelLoginUsuario)session.get("user")).getRut();
        this.planillas=conexion.getPlanillaByRut(rut);
        conexion.cerrarSession();
        return SUCCESS;
    }

    private ArrayList<ModelPlanillaGC> planillas;

    private Map<String, Object> session;

    public ArrayList<ModelPlanillaGC> getPlanillas() {
        return planillas;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
