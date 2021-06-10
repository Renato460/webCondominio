package webCondominio.controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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


public class ControllerPago extends ActionSupport implements SessionAware, ServletRequestAware{


	/**
	 *
	 */
	private static final long serialVersionUID = -7371405797191879037L;


	public String execute() throws ApiException {
		



		String rut = ((ModelLoginUsuario)session.get("user")).getRut();
		System.out.println("<<<<<<<<<<<<"+rut);

		Integer id = Integer.parseInt(request.getParameter("id"));
		Double monto = Double.parseDouble(request.getParameter("monto"));
		String descripcion = request.getParameter("desc");
		String tipo = request.getParameter("tipo");

		Map<String,Object> pagos = new LinkedHashMap<>();
		pagos.put("id", id);
		pagos.put("descripcion", descripcion);
		pagos.put("tipo", tipo);
		pagos.put("monto",monto);

		//((ModelLoginUsuario)session.get("user")).getPagos().clear();
		((ModelLoginUsuario)session.get("user")).setPagos(pagos);
		System.out.println(((ModelLoginUsuario)session.get("user")).getPagos().get("tipo"));
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
		options.put("returnUrl", "http://localhost:8081/webCondominio_war_exploded/pagoExitosoChain.action");
		options.put("cancelUrl", "http://localhost:8081/webCondominio_war_exploded/return.action#");
		options.put("pictureUrl", "https://media.revistagq.com/photos/5f45010acb266484bb785c78/16:9/w_1920%2cc_limit/dragon-ball-z.jpg");
		options.put("notifyUrl", "http://localhost:8082/khipu");
		options.put("notifyApiVersion", "1.3");

		PaymentsCreateResponse response;

		response = paymentsApi.paymentsPost(descripcion //Motivo de la compra
				, "CLP" //Monedas disponibles CLP, USD, ARS, BOB
				, monto //Monto
				, options    //campos opcionales
		);


		System.out.println(response);
		urlPago = response.getPaymentUrl();
		return SUCCESS;
	}

	private String urlPago;
	private HttpServletRequest request;
	private Map<String,Object> session;

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
