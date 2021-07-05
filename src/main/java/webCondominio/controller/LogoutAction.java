package webCondominio.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import webCondominio.model.ModelLoginUsuario;

public class LogoutAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4411954889516271482L;
	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public String execute() {

		if (session.get("user")!=null){
			session.remove("user");
			return SUCCESS;
		}
		return SUCCESS;
	}
}
