package webCondominio.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelLoginUsuario;
import webCondominio.model.ModelMulta;

import javax.servlet.http.HttpServletRequest;

public class ActionMulta extends ActionSupport implements SessionAware, ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2305067569720645814L;
	
	@Override
	public String execute() {
		ControllerConexion multas = new ControllerConexion();
		System.out.println("---->>>>"+((ModelLoginUsuario)session.get("user")).getRut());
		String rutMultas = ((ModelLoginUsuario)session.get("user")).getRut();
		numeroMultas = multas.multas(rutMultas);
		multas.cerrarSession();
		
		return SUCCESS;
	}


	public String multa(){
		ControllerConexion muta = new ControllerConexion();
		String rut = request.getParameter("rut");
		System.out.println(rut);
		numeroMultas = muta.multas(rut);
		muta.cerrarSession();
		return SUCCESS;
	}

	private ArrayList<ModelMulta> numeroMultas;
	private HttpServletRequest request;
	private Map<String, Object> session;
	
	public ArrayList<ModelMulta> getNumeroMultas() {
		return numeroMultas;
	}
	public void setNumeroMultas(ArrayList<ModelMulta> numeroMultas) {
		this.numeroMultas = numeroMultas;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
