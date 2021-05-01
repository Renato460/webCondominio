package webCondominio.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO", schema= "ESPADMIN")
public class ModelUsuario {

	
	public ModelUsuario() {}

	private int id_usuario;
	
	@Id
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
	public int getId_perfil() {
		return id_perfil;
	}
	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date update_at) {
		this.updated_at = update_at;
	}
	public Date getInserted_at() {
		return inserted_at;
	}
	public void setInserted_at(Date inserted_at) {
		this.inserted_at = inserted_at;
	}
	public int getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	
	private String usuario;
	
	
	private String password;
	
	
	private int id_perfil;
	
		
	private Date updated_at;
	
	
	private Date inserted_at;
	
	
	private int is_valid;
	
	
	private int id_rol;
}
