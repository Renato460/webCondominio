package webCondominio.action;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ActionReserva extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6962268678772073193L;
	
	@Override
	public String execute() {
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	private Map<String, Object> session;
	
	private String fecha;
	private String rut;
	private String servicio;
	private String horario;	

}
