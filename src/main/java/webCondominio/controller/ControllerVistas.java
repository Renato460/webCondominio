package webCondominio.controller;
import com.opensymphony.xwork2.ActionSupport;


public class ControllerVistas extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute() {
		ControllerConeccion usuario = new ControllerConeccion();
		name="Nombre Prueba";
		tipo="residente";
		
		return SUCCESS;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	private String tipo;
}
