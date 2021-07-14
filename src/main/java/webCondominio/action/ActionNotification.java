package webCondominio.action;

import com.khipu.ApiClient;
import com.khipu.ApiException;
import com.khipu.api.client.PaymentsApi;
import com.khipu.api.model.PaymentsResponse;
import com.opensymphony.xwork2.ActionSupport;
import webCondominio.controller.ControllerConexion;

import java.util.Map;

public class ActionNotification extends ActionSupport {
    @Override
    public String execute() throws ApiException {

        System.out.println(this.api_version+"---"+this.notification_token);
        int receiverId = 381468;
        String secret = "d749349a39c35148ea43352381b2c9ff60bbb6ce";
        String apiVersion = this.api_version; // Parámetro api_version
        String notificationToken = this.notification_token; // Parámetro notification_token
        //double amount = 16000.0;

        if (apiVersion.equals("1.3")) {
            ApiClient apiClient = new ApiClient();
            apiClient.setKhipuCredentials(receiverId, secret);
            apiClient.setPlatform("demo-client", "2.0");
            // apiClient.setDebugging(true);
            PaymentsApi paymentsApi = new PaymentsApi();
            paymentsApi.setApiClient(apiClient);

            PaymentsResponse response = paymentsApi.paymentsGet(notificationToken);
            if (response.getReceiverId().longValue() == receiverId) {
                ControllerConexion conexion = new ControllerConexion();
                Map<String,String> datosRespuesta = conexion.getPagoResponse(response.getPaymentId());
                conexion.cerrarSession();
                double monto = Double.parseDouble(datosRespuesta.get("monto"));
                if (response.getStatus().equals("done") && response.getAmount() == monto) {
                    // marcar el pago como completo y entregar el bien o servicio
                    ControllerConexion conexion1 = new ControllerConexion();
                    if (datosRespuesta.get("tipo").equals("multa")){
                        conexion1.setPagoMulta(Integer.parseInt(datosRespuesta.get("id_plantilla")));
                        conexion1.cerrarSession();
                    }
                    if (datosRespuesta.get("tipo").equals("gastoComun")){
                        conexion1.setPagoAuto(Integer.parseInt(datosRespuesta.get("id_plantilla")));
                        conexion1.cerrarSession();
                    }

                    System.out.println(response);
                }
            } else {
                // receiverId no coincide
            }
        } else {
            // Usar versión anterior de la API de notificación
        }


        return SUCCESS;
    }

    private String api_version;
    private String notification_token;

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getNotification_token() {
        return notification_token;
    }

    public void setNotification_token(String notification_token) {
        this.notification_token = notification_token;
    }

}
