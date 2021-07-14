package webCondominio.action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelMorosos;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class ActionGetMorosos extends ActionSupport implements ServletRequestAware{
    ArrayList <ModelMorosos> morosos;
    private HttpServletRequest request;
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        Integer idCondo = Integer.parseInt(request.getParameter("idCondo"));
        this.morosos=conexion.getMorosos(idCondo);
        conexion.cerrarSession();
        return SUCCESS;
    }

    public ArrayList<ModelMorosos> getMorosos() {
        return morosos;
    }

    public void setMorosos(ArrayList<ModelMorosos> morosos) {
        this.morosos = morosos;
    }
}
