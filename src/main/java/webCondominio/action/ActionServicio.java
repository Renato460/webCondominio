package webCondominio.action;

import java.util.List;


import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelServicio;

public class ActionServicio extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -175986249527242187L;

	@Override
	public String execute() {
		/*ControllerConexion reserva = new ControllerConexion();
		List<ModelServicio> reservas= reserva.getServicios();
		reserva.cerrarSession();
		System.out.println(reservas.get(0).getNombre_servicio());*/
		return SUCCESS;
	}
}
