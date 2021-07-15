package webCondominio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class ModelServicio {
	
	
	private int id_servicio;
	private String nombre_servicio;
	private double costo;

	public ModelServicio() {
	}

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
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}

}
