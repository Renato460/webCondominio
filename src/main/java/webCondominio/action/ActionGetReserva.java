package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelLoginUsuario;
import webCondominio.model.ModelReservaLista;
import webCondominio.model.ModelUsuario;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class ActionGetReserva extends ActionSupport implements SessionAware {

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        String rut = ((ModelLoginUsuario)session.get("user")).getRut();
        this.reservas = conexion.getReservas(rut);
        conexion.cerrarSession();
        return SUCCESS;
    }

    private ArrayList<ModelReservaLista> reservas;
    private Map<String, Object> session;

    public ArrayList<ModelReservaLista> getReservas() {
        return reservas;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
