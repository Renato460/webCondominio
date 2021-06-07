package webCondominio.action;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;

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
			
			String rutPersona = request.getParameter("rut");
			System.out.println(rutPersona);
			
			Integer idHorario = Integer.parseInt(request.getParameter("horarios"));
			
			System.out.println(idHorario);
	    	
			Integer idServicio;
			switch (servicioNombre) {
			case "QUINCHO":
				idServicio = 1;
				break;
			case "ESTACIONAMIENTO":
				idServicio = 2;
				break;
			case "SALE EVENTOS":
				idServicio = 3;
				break;
			case "MULTICANCHA":
				idServicio = 4;
				break;
			default: idServicio =0;break;
			};
			
			exito = setReserva.setReservaUsuario(fechaConv, rutPersona, idServicio , idHorario);
			setReserva.cerrarSession();
			System.out.println();
			
			return SUCCESS;
		}catch(Exception ex) {
			System.out.println(ex);

			return ERROR;
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
