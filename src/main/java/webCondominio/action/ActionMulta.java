package webCondominio.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelLoginUsuario;
import webCondominio.model.ModelMulta;

public class ActionMulta extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2305067569720645814L;
	
	@Override
	public String execute() {
		ControllerConexion multas = new ControllerConexion();
		System.out.println("---->>>>"+((ModelLoginUsuario)session.get("user")).getRut());
		//System.out.println("rut--------->"+((ModelLoginUsuario)session.get("user")).getRut());
		//numeroMultas = multas.multas(((ModelLoginUsuario)session.get("user")).getRut());
		
		String rutMultas = ((ModelLoginUsuario)session.get("user")).getRut();
		numeroMultas = multas.multas(rutMultas);
		multas.cerrarSession();
		
		return SUCCESS;
	}
	private ArrayList<ModelMulta> numeroMultas;
	private String rutUsuario;
	private Map<String, Object> session;
	
	public String getRutUsuario() {
		return rutUsuario;
	}
	public void setRutUsuario(String rutUsuario) {
		this.rutUsuario = rutUsuario;
	}
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
}
