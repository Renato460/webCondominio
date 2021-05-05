package webCondominio.model;

public class ModelHorario {

	private int idHorario;
	private String horario;
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public ModelHorario(int idHorario, String horario) {
		super();
		this.idHorario = idHorario;
		this.horario = horario;
	}
	
	
}
