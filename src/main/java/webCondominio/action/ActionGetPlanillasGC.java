package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelPlanillaGC;

import javax.naming.ldap.Control;
import java.util.ArrayList;

public class ActionGetPlanillasGC extends ActionSupport {
    private ArrayList<ModelPlanillaGC> planillas;

    public ArrayList<ModelPlanillaGC> getPlanillas() {
        return planillas;
    }

    public void setPlanillas(ArrayList<ModelPlanillaGC> planillas) {
        this.planillas = planillas;
    }

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        this.planillas=conexion.getPlanillas();
        conexion.cerrarSession();
        return SUCCESS;
    }
}
