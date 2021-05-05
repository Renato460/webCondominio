package webCondominio.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;
import webCondominio.model.ModelLoginUsuario;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelPago;


public class ActionPago extends ActionSupport implements ServletRequestAware, SessionAware{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 4394787954075841625L;

	public String execute() {
		
		
		
		return SUCCESS;
	}
	
	public String listaJson () {
		System.out.println("<<<<<<<<<<<<<<<"+((ModelLoginUsuario)session.get("user")).getRut());
		System.out.println("<<<<<<<<<<<<"+request.getParameter("fecha"));
		this.fecha = request.getParameter("fecha");
		
		//Date fechaConv = Date.valueOf(fecha);
		System.out.println("<<<<<<<<<<<<"+fecha);
		Date fechaPrueba= Date.valueOf(java.time.LocalDate.now());
		//this.rut = request.getParameter(rut);
		this.rut = ((ModelLoginUsuario)session.get("user")).getRut();
		System.out.println("<<<<<<<<<<<<"+rut);
		ControllerConexion getPago = new ControllerConexion();
		this.arrayPago = getPago.getPagos(fechaPrueba, rut);
		getPago.cerrarSession();
		return SUCCESS;
	}
	
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	private String fecha;
	private String rut;
	private ArrayList<ModelPago> arrayPago;
	private HttpServletRequest request;
	private Map<String,Object> session;
	
	public ArrayList<ModelPago> getArrayPago() {
		return arrayPago;
	}

	public void setArrayPago(ArrayList<ModelPago> arrayPago) {
		this.arrayPago = arrayPago;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
