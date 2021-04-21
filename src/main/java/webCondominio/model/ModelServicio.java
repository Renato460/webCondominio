package webCondominio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICIO", schema= "ESPADMIN")
public class ModelServicio {
	
	
	private int id_servicio;
	
	@Id
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getNombre_servicio() {
		return nombre_servicio;
	}
	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	private String nombre_servicio;
	private int costo;
}
