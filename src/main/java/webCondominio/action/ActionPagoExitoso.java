package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelLoginUsuario;

import java.util.Map;

public class ActionPagoExitoso extends ActionSupport {

    @Override
    public String execute() throws Exception {
        //ControllerConexion conexion = new ControllerConexion();
        /*try{
            Integer id_pago = Integer.parseInt(((ModelLoginUsuario)session.get("user")).getPagos().get("id").toString());
            conexion.cerrarSession();
        }catch (Exception e){
            System.out.println("------------->"+e);
        }*/


        return SUCCESS;
    }


}
