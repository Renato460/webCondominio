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


	public String execute() throws ApiException {
		
		String rut = ((ModelLoginUsuario)session.get("user")).getRut();
		System.out.println("<<<<<<<<<<<<"+rut);

		Integer id = Integer.parseInt(request.getParameter("id"));
		double monto = Double.parseDouble(request.getParameter("monto"));
		String descripcion = request.getParameter("desc");
		String tipo = request.getParameter("tipo");

		Map<String,Object> pagos = new LinkedHashMap<>();
		pagos.put("id", id);
		pagos.put("descripcion", descripcion);
		pagos.put("tipo", tipo);
		pagos.put("monto",monto);



		if(((ModelLoginUsuario)session.get("user")).getPagos()!=null){
			((ModelLoginUsuario)session.get("user")).getPagos().clear();
		}
		((ModelLoginUsuario)session.get("user")).setPagos(pagos);
		//System.out.println(((ModelLoginUsuario)session.get("user")).getPagos().get("tipo"));
		int receiverId = 381468;
		String secretKey = "d749349a39c35148ea43352381b2c9ff60bbb6ce";

		ApiClient apiClient = new ApiClient();
		apiClient.setKhipuCredentials(receiverId, secretKey);
		apiClient.setPlatform("demo-client", "2.0");
		// apiClient.setDebugging(true);
		PaymentsApi paymentsApi = new PaymentsApi();
		paymentsApi.setApiClient(apiClient);

		Map<String, Object> options = new HashMap<>();
		options.put("transactionId", id + descripcion);//Cambiar
		options.put("returnUrl", "http://186.78.176.254:8081/webCondominio_war_exploded/pagoExitosoChain.action");
		options.put("cancelUrl", "http://186.78.176.254:8081/webCondominio_war_exploded/return.action");
		options.put("pictureUrl", "https://icha.cl/wp-content/uploads/2017/06/Soho_general_hi_gl-1024x921.jpg");
		options.put("notifyUrl", "http://186.78.176.254:8081/webCondominio_war_exploded/notification.action");
		options.put("notifyApiVersion", "1.3");

		PaymentsCreateResponse response;

		response = paymentsApi.paymentsPost(
				descripcion //Motivo de la compra
				, "CLP" //Monedas disponibles CLP, USD, ARS, BOB
				, monto //Monto
				, options    //campos opcionales
		);
		ControllerConexion conexion = new ControllerConexion();
		conexion.setPagoResponse(response.getPaymentId(),monto,id,tipo);
		conexion.cerrarSession();
		this.urlPago = response.getPaymentUrl();
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
