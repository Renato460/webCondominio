package webCondominio.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class ActionDisponibilidad extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */

	public String execute() {
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

		}
		;
		
		return SUCCESS;
	}

	private static final long serialVersionUID = -8825604381551501047L;

	private HttpServletRequest request;

	private String fecha;
	private Integer idServicio;
	private String servicio;



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
