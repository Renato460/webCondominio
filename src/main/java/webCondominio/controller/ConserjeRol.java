package webCondominio.controller;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import webCondominio.model.ModelLoginUsuario;

import java.util.Map;

public class ConserjeRol implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        ModelLoginUsuario rol =(ModelLoginUsuario)session.get("user");
        if (rol.getRol().equals("2")){
            return invocation.invoke();
        }
        return ActionSupport.LOGIN;
    }
}
