package webCondominio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ModelAnuncios {
	private int idAnuncio;
	private String descripcion;
	private String url;
	
	@Id
	public int getIdAnuncio() {
		return idAnuncio;
	}
	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ModelAnuncios(int idAnuncio,String descripcion, String url) {
		this.idAnuncio= idAnuncio;
		this.descripcion = descripcion;
		this.url = url;
	}
	
	
}
