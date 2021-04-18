package webCondominio.controller;
import java.util.HashMap;
import java.util.Map;

import com.khipu.ApiClient;
import com.khipu.ApiException;
import com.khipu.api.client.PaymentsApi;
import com.khipu.api.model.PaymentsCreateResponse;
import com.opensymphony.xwork2.ActionSupport;


public class ControllerPago extends ActionSupport{
	private static final long serialVersionUID = 1L;

	public String execute() throws ApiException {
		System.out.println("---->"+ firstName);
		int receiverId = 381468;
		String secretKey = "d749349a39c35148ea43352381b2c9ff60bbb6ce";

		ApiClient apiClient = new ApiClient();
		apiClient.setKhipuCredentials(receiverId, secretKey);
		apiClient.setPlatform("demo-client", "2.0");
		// apiClient.setDebugging(true);
		PaymentsApi paymentsApi = new PaymentsApi();
		paymentsApi.setApiClient(apiClient);

		Map<String, Object> options = new HashMap<>();
		options.put("transactionId", "MTI-100");
		options.put("returnUrl", "https://www.google.com/?hl=es");
		options.put("cancelUrl", "https://www.google.com/search?q=error&hl=es&sxsrf=ALeKk03EmLOxOSsnvhtaIGD3KHUWDnDFzg%3A1618710949638&source=hp&ei=pZF7YMfMJLPV1sQP__yR6AE&iflsig=AINFCbYAAAAAYHuftQ8alK9FY4x8nSAKsjvpH0Gqc7E9&oq=error&gs_lcp=Cgdnd3Mtd2l6EAMyBwgAELEDEEMyBwgAELEDEEMyBAgAEEMyBQgAELEDMggIABCxAxCDATIICAAQsQMQgwEyBQgAELEDMggIABCxAxCDATICCAAyBQgAELEDOgcIIxDqAhAnOgQIIxAnOgsIABCxAxDHARCjAjoHCC4QQxCTAjoKCC4QsQMQgwEQQzoFCC4QsQM6BAguEENQmWtYzXBgl3JoAXAAeACAATqIAf0BkgEBNZgBAKABAaoBB2d3cy13aXqwAQo&sclient=gws-wiz&ved=0ahUKEwiHs5SZ2IbwAhWzqpUCHX9-BB0Q4dUDCAg&uact=5");
		options.put("pictureUrl", "https://media.revistagq.com/photos/5f45010acb266484bb785c78/16:9/w_1920%2cc_limit/dragon-ball-z.jpg");
		options.put("notifyUrl", "http://mi-ecomerce.com/backend/notify");
		options.put("notifyApiVersion", "1.3");

		PaymentsCreateResponse response;

			response = paymentsApi.paymentsPost("Compra de prueba de la API" //Motivo de la compra
			        , "CLP" //Monedas disponibles CLP, USD, ARS, BOB
			        , 100.0 //Monto
			        ,options	//campos opcionales
			        );


		System.out.println(response);
		urlPago=response.getPaymentUrl();
		return SUCCESS;
	}
	
	private String firstName;
	private String urlPago;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUrlPago() {
		return urlPago;
	}

	public void setUrlPago(String url) {
		this.urlPago = url;
	}
}
