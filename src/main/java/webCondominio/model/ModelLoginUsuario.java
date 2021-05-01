package webCondominio.model;

public class ModelLoginUsuario {
	private String usuario;

	private String password;

	public ModelLoginUsuario(String usuario, String password) {
		
		this.usuario = usuario;
		this.password = password;
	}

	public ModelLoginUsuario() {
		super();
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
}
