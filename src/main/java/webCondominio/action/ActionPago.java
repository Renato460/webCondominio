package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;


public class ActionPago extends ActionSupport {
	/**
	 * 
	 */
	
	public ActionPago() {
		this.idPago="1";
		this.dPago="prueba de pago";
	}
	private static final long serialVersionUID = 4394787954075841625L;

	public String excute() {

		return SUCCESS;
	}
	
	private String idPago;
	private String dPago;

	public String getIdPago() {
		return idPago;
	}
	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}
	public String getdPago() {
		return dPago;
	}
	public void setdPago(String dPago) {
		this.dPago = dPago;
	}
	
	
}
