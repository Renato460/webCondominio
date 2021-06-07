package webCondominio.model;

import java.util.Map;

public class ModelLoginUsuario {
	private String usuario;

	private String password;
	
	private String nombre;
	
	private String rut;
	
	private String rol;

	private Map <String, Object> pagos;


	public ModelLoginUsuario(String usuario, String password, String nombre, String rut, String rol) {

		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.rut = rut;
		this.rol = rol;
	}

	public Map<String, Object> getPagos() {
		return pagos;
	}

	public void setPagos(Map<String, Object> pagos) {
		this.pagos = pagos;
	}

	public ModelLoginUsuario() {

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
}
