package webCondominio.model;

public class ModelPago {
	
	private Integer montoGastoComun;
	private Integer montoMulta;
	private Integer montoReserva;
	
	public Integer getMontoGastoComun() {
		return montoGastoComun;
	}
	public void setMontoGastoComun(Integer montoGastoComun) {
		this.montoGastoComun = montoGastoComun;
	}
	public Integer getMontoMulta() {
		return montoMulta;
	}
	public void setMontoMulta(Integer montoMulta) {
		this.montoMulta = montoMulta;
	}
	public Integer getMontoReserva() {
		return montoReserva;
	}
	public void setMontoReserva(Integer montoReserva) {
		this.montoReserva = montoReserva;
	}
	public ModelPago(Integer montoGastoComun, Integer montoMulta, Integer montoReserva) {
		super();
		this.montoGastoComun = montoGastoComun;
		this.montoMulta = montoMulta;
		this.montoReserva = montoReserva;
	}
	
	
}
