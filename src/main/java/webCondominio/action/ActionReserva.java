package webCondominio.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.khipu.ApiClient;
import com.khipu.api.client.PaymentsApi;
import com.khipu.api.model.PaymentsCreateResponse;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelLoginUsuario;

public class ActionReserva extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6962268678772073193L;
	
	@Override
	public String execute() {
		try {
			ControllerConexion setReserva = new ControllerConexion();
		
			this.fecha = request.getParameter("fecha");
					
			Date fechaConv = Date.valueOf(fecha);
			System.out.println(fechaConv.toString());
			
			String servicioNombre = request.getParameter("servicio");
			System.out.println(servicioNombre);
			
			String rut = request.getParameter("rut");
			System.out.println(rut);
			
			Integer idHorario = Integer.parseInt(request.getParameter("horarios"));
			
			System.out.println(idHorario);
	    	
			int idServicio = idServicio(servicioNombre);

			
			exito = setReserva.setReservaUsuario(fechaConv, rut, idServicio , idHorario);
			setReserva.cerrarSession();
			System.out.println();

			return SUCCESS;

		}catch(Exception ex) {
			System.out.println(ex);

			return ERROR;
		}
	}

	private int idServicio(String servicioNombre){
		switch (servicioNombre) {
			case "QUINCHO":
				return 1;

			case "ESTACIONAMIENTO":
				return 2;

			case "SALA EVENTOS":
				return 3;

			case "MULTICANCHA":
				return 4;

			default:
				return 0;

		}
	}

	
	private String fecha;
	private String rut;
	private String servicio;
	private String horarios;
	private boolean exito;
	private HttpServletRequest request;



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



	public String getServicio() {
		return servicio;
	}



	public void setServicio(String servicio) {
		this.servicio = servicio;
	}



	public String getHorarios() {
		return horarios;
	}



	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}



	public boolean isExito() {
		return exito;
	}



	public void setExito(boolean exito) {
		this.exito = exito;
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

}
