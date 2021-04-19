package webCondominio.controller;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.model.ModelUsuario;


public class ControllerVistas extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute() {
		ControllerConeccion user = new ControllerConeccion();
		List<ModelUsuario> contra = user.login(usuario);
		try {
			if((contra.get(0).getUsuario().equals(usuario))&&(contra.get(0).getPassword().equals(pass))) {
				return SUCCESS;
			}else {
			return ERROR;
			}
		}catch(Exception ex){
			return ERROR;
		}
	}

	
	public String multas() {
		
		return SUCCESS;
	}

	private String usuario;
	private String pass;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


}
