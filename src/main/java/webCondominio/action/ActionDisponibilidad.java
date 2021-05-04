package webCondominio.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;

public class ActionDisponibilidad extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */

	public String execute() {
		try {
			this.fecha = request.getParameter("fecha");
			String servicioNombre = request.getParameter("servicio");

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

			};
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-mm-dd");
	    	java.util.Date date = sdf.parse(fecha);
	    	Date fechaDisp = new Date(date.getTime());
	    	
			ControllerConexion horarios = new ControllerConexion();
			this.dispo = horarios.getDisponibilidad(fechaDisp,idServicio); 
			return SUCCESS;			
		}catch(Exception ex) {
			System.out.println(ex);
			return ERROR;
		}
	}

	private static final long serialVersionUID = -8825604381551501047L;

	private HttpServletRequest request;

	private String fecha;
	private Integer idServicio;
	private String servicio;
	private ArrayList<String> dispo;


	public ArrayList<String> getDispo() {
		return dispo;
	}



	public void setDispo(ArrayList<String> dispo) {
		this.dispo = dispo;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public Integer getIdServicio() {
		return idServicio;
	}



	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}



	public String getServicio() {
		return servicio;
	}



	public void setServicio(String servicio) {
		this.servicio = servicio;
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

}
