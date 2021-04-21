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
		ControllerConexion user = new ControllerConexion();
		List<ModelUsuario> contra = user.login(usuario);
		try {
			if((contra.get(0).getUsuario().equals(usuario))&&(contra.get(0).getPassword().equals(pass))) 
			{
				user.cerrarSession();
				return SUCCESS;
			}else {
				user.cerrarSession();
			return ERROR;
			}
		}catch(Exception ex){
			user.cerrarSession();
			return ERROR;
		}
	}

	public String reserva() {
		return SUCCESS;
	}
	public String multas() {
		
		return SUCCESS;
	}

	private String usuario;
	private String pass;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


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
