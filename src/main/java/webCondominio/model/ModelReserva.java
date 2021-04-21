package webCondominio.model;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "RESERVA", schema= "ESPADMIN")
public class ModelReserva {

	@Id
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Date getHora_termino() {
		return hora_termino;
	}
	public void setHora_termino(Date hora_termino) {
		this.hora_termino = hora_termino;
	}
	public int getId_perfil() {
		return id_perfil;
	}
	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public ModelReserva (){
		
	}
	
	private int id_reserva;
	private Date fecha;
	private Date hora_inicio;
	private Date hora_termino;
	private int id_perfil;
	private int id_servicio;
}
