package webCondominio.controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.khipu.ApiClient;
import com.khipu.ApiException;
import com.khipu.api.client.PaymentsApi;
import com.khipu.api.model.PaymentsCreateResponse;
import com.opensymphony.xwork2.ActionSupport;

import webCondominio.model.ModelLoginUsuario;
import webCondominio.model.ModelPago;


public class ControllerPago extends ActionSupport implements ServletRequestAware, SessionAware{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7371405797191879037L;


	public String execute() throws ApiException {
		
		/*System.out.println("<<<<<<<<<<<<<<<"+((ModelLoginUsuario)session.get("user")).getRut());
		System.out.println("<<<<<<<<<<<<"+request.getParameter("fecha"));
		this.fecha = request.getParameter("fecha");
		
		Date fechaConv = Date.valueOf(fecha);
		System.out.println("<<<<<<<<<<<<"+fecha);
		//this.rut = request.getParameter(rut);
		this.rut = ((ModelLoginUsuario)session.get("user")).getRut();
		System.out.println("<<<<<<<<<<<<"+rut);
		ControllerConexion getPago = new ControllerConexion();
		ArrayList<ModelPago> arrayPago = getPago.getPagos(fechaConv, rut);
		getPago.cerrarSession();
		
		Integer montoComun = arrayPago.get(0).getMontoGastoComun();
		Integer montoMulta = arrayPago.get(0).getMontoMulta();
		Integer montoReserva = arrayPago.get(0).getMontoReserva();
		
		Double montoFinal= Double.valueOf((montoComun + montoMulta + montoReserva)) ;*/
		
		Double montoPrueba = 10000.00;
		
		
		int receiverId = 381468;
		String secretKey = "d749349a39c35148ea43352381b2c9ff60bbb6ce";

		ApiClient apiClient = new ApiClient();
		apiClient.setKhipuCredentials(receiverId, secretKey);
		apiClient.setPlatform("demo-client", "2.0");
		// apiClient.setDebugging(true);
		PaymentsApi paymentsApi = new PaymentsApi();
		paymentsApi.setApiClient(apiClient);

		Map<String, Object> options = new HashMap<>();
		options.put("transactionId", "Gastos Condominio");//Cambiar
		options.put("returnUrl", "http://localhost:8081/condominio-web/return.action#");
		options.put("cancelUrl", "http://localhost:8081/condominio-web/return.action#");
		options.put("pictureUrl", "https://media.revistagq.com/photos/5f45010acb266484bb785c78/16:9/w_1920%2cc_limit/dragon-ball-z.jpg");
		options.put("notifyUrl", "http://mi-ecomerce.com/backend/notify");
		options.put("notifyApiVersion", "1.3");

		PaymentsCreateResponse response;

			response = paymentsApi.paymentsPost("Compra de prueba de la API" //Motivo de la compra
			        , "CLP" //Monedas disponibles CLP, USD, ARS, BOB
			        , montoPrueba //Monto
			        ,options	//campos opcionales
			        );


		System.out.println(response);
		urlPago=response.getPaymentUrl();
		return SUCCESS;
	}
	
	private String fecha;
	private String rut;
	private String urlPago;
	private HttpServletRequest request;
	private Map<String,Object> session;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getUrlPago() {
		return urlPago;
	}

	public void setUrlPago(String url) {
		this.urlPago = url;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
