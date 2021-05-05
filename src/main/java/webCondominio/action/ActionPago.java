package webCondominio.action;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelPago;


public class ActionPago extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 4394787954075841625L;

	public String excute() {
		
		
		
		return SUCCESS;
	}
	
	public String listaJson () {
		
		this.fecha = Date.valueOf(request.getParameter("fecha"));
		this.rut = request.getParameter(rut);
		
		ControllerConexion getPago = new ControllerConexion();
		this.arrayPago = new ArrayList<ModelPago>();
		arrayPago = getPago.getPagos(fecha, rut);
		
		return SUCCESS;
	}
	
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	private Date fecha;
	private String rut;
	private ArrayList<ModelPago> arrayPago;
	private HttpServletRequest request;
	
	public ArrayList<ModelPago> getArrayPago() {
		return arrayPago;
	}

	public void setArrayPago(ArrayList<ModelPago> arrayPago) {
		this.arrayPago = arrayPago;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

}
