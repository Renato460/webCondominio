package webCondominio.controller;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import webCondominio.model.ModelLoginUsuario;




public class ControllerVistas extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2319678465301617196L;

	/**
	 * 
	 */
	
	private Map<String,Object> session;
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String execute() {
			session.remove("user");
			if(isValid(usuario, pass)){
				ModelLoginUsuario nuevoUsuario= new ModelLoginUsuario(usuario,pass,nombre,rut,rol);
				session.put("user", nuevoUsuario);
				System.out.println(((ModelLoginUsuario)session.get("user")).getPassword());
				
				return vistasRoles(this.rol);
			}else{
				return INPUT;
			}


	}

	private String vistasRoles(String rol){
		switch (rol){
			case "1":
				return "admin";
			case "2":
				return "conserje";
			case "3":
				return "directiva";
			case "4":
				return "residente";
			default:
				return "INPUT";
		}
	}
	
	private boolean isValid(String usuario, String pass) {
		ControllerConexion user = new ControllerConexion();
		List<String> contra = user.login(usuario, pass);

		try {
			if(contra.get(0)!=null) {
				
				user.cerrarSession();
				rut=contra.get(0);
				nombre=contra.get(1);
				rol=contra.get(2);
				return true;
				
			}else {
				user.cerrarSession();
				return false;
			}
			
		}catch(Exception ex ) {
			user.cerrarSession();
			return false;
		}
	}

	private String usuario;
	private String pass;
	private String nombre;
	private String rut;
	private String rol;
	
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
