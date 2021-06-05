package webCondominio.action;

import com.khipu.ApiClient;
import com.khipu.api.client.PaymentsApi;
import com.khipu.api.model.PaymentsResponse;
import com.opensymphony.xwork2.ActionSupport;

public class ActionGetPago extends ActionSupport {

    @Override
    public String execute() throws Exception {


        int receiverId = 381468;
        String secret = "d749349a39c35148ea43352381b2c9ff60bbb6ce";
        String apiVersion = this.apiVersion; // Parámetro api_version
        String notificationToken = this.notificationToken; // Parámetro notification_token
        double amount = this.originalMount;

        if (apiVersion.equals("1.3")) {
            ApiClient apiClient = new ApiClient();
            apiClient.setKhipuCredentials(receiverId, secret);
            apiClient.setPlatform("demo-client", "2.0");
            // apiClient.setDebugging(true);
            PaymentsApi paymentsApi = new PaymentsApi();
            paymentsApi.setApiClient(apiClient);

            PaymentsResponse response = paymentsApi.paymentsGet(notificationToken);
            if (response.getReceiverId().longValue() == receiverId) {
                if (response.getStatus().equals("done") && response.getAmount() == amount) {
                    // marcar el pago como completo y entregar el bien o servicio
                }
            } else {
                // receiverId no coincide
            }
        } else {
            // Usar versión anterior de la API de notificación
        }


        return SUCCESS;
    }

    private String apiVersion;
    private String notificationToken;
    private double originalMount;
    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getNotificationToken() {
        return notificationToken;
    }

    public void setNotificationToken(String notificationToken) {
        this.notificationToken = notificationToken;
    }
}
