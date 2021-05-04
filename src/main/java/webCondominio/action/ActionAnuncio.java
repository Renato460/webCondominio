package webCondominio.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import webCondominio.controller.ControllerConexion;
import webCondominio.model.ModelAnuncios;

public class ActionAnuncio extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9125303765801040100L;

	@Override
	public String execute() {
		ControllerConexion anuncios = new ControllerConexion();
		anunciosLista= anuncios.anuncios();
		anuncios.cerrarSession();
		return SUCCESS;
	}
	
	private ArrayList<ModelAnuncios> anunciosLista;

	public ArrayList<ModelAnuncios> getAnunciosLista() {
		return anunciosLista;
	}

	public void setAnunciosLista(ArrayList<ModelAnuncios> anunciosLista) {
		this.anunciosLista = anunciosLista;
	}
}
