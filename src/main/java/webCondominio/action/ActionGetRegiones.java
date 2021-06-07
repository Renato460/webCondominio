package webCondominio.action;
import com.opensymphony.xwork2.ActionSupport;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelRegiones;
import java.util.ArrayList;

public class ActionGetRegiones extends ActionSupport {
    private ArrayList <ModelRegiones> regiones;

    public ArrayList<ModelRegiones> getRegiones() {
        return regiones;
    }

    public void setRegiones(ArrayList<ModelRegiones> regiones) {
        this.regiones = regiones;
    }

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        this.regiones=conexion.getRegiones();
        conexion.cerrarSession();
        return SUCCESS;
    }
}
