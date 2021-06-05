package webCondominio.model;


import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="MULTAS")
public class ModelMulta {

	public ModelMulta(int id_multa, String fechaIng, String descripcion, int monto) {
		
		this.id_multa = id_multa;
		this.fechaIng = fechaIng;
		this.descripcion = descripcion;
		this.monto = monto;
	}

	public ModelMulta() {

	}

	@Id
	public int getId_multa() {
		return id_multa;
	}
	public void setId_multa(int id_multa) {
		this.id_multa = id_multa;
	}
	public String getFechaIng() {
		return fechaIng;
	}
	public void setFechaIng(String fecha) {
		this.fechaIng = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getId_vivienda() {
		return id_vivienda;
	}
	public void setId_vivienda(int id_vivienda) {
		this.id_vivienda = id_vivienda;
	}
	public int getId_periodo() {
		return id_periodo;
	}
	public void setId_periodo(int id_periodo) {
		this.id_periodo = id_periodo;
	}
	private int id_multa;
	private String fechaIng;
	private String descripcion;
	private int monto;
	private int id_vivienda;
	private int id_periodo;
}
