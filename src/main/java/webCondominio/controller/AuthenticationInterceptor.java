package webCondominio.controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

import webCondominio.model.ModelLoginUsuario;

public class AuthenticationInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3489469070787718499L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		ModelLoginUsuario usuario =(ModelLoginUsuario)session.get("user");
		if(usuario==null) {
			return ActionSupport.LOGIN;
		}
		return actionInvocation.invoke();
	}

}
