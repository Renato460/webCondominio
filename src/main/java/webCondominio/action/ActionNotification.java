package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionNotification extends ActionSupport {
    @Override
    public String execute(){
        this.notification_token="Pruebaaa";
        this.api_version="1.3";
        System.out.println(this.api_version+"---"+this.notification_token);
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
