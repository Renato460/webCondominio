package webCondominio.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class ActionPagoExitoso extends ActionSupport implements SessionAware {

    @Override
    public String execute() throws Exception {


        return SUCCESS;
    }

    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
