package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelLoginUsuario;

import java.util.Map;

public class ActionPagoExitoso extends ActionSupport implements SessionAware {

    @Override
    public String execute() throws Exception {
        ControllerConexion conexion = new ControllerConexion();
        try{
            Integer idMulta = Integer.parseInt(((ModelLoginUsuario)session.get("user")).getPagos().get("id").toString());
            System.out.println("----------------------->>>>>>>>>>>"+idMulta+"<<<<<<<<<<<<<<<-----------------------");
            this.resultado = conexion.setPagoMulta(idMulta);

            conexion.cerrarSession();
        }catch (Exception e){
            System.out.println("------------->"+e);
        }


        return SUCCESS;
    }
    private Integer resultado;
    private Map<String, Object> session;

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
