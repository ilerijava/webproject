package com.tutev.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller("loginView")
@Scope("session")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -1246714304296999364L;

	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String abc = request.getQueryString();
	}

	@SuppressWarnings("finally")
	public String doLogin() {
		try {
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();
			RequestDispatcher dispatcher = ((ServletRequest) context
					.getRequest())
					.getRequestDispatcher("/j_spring_security_check");

			dispatcher.forward((ServletRequest) context.getRequest(),
					(ServletResponse) context.getResponse());
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return null;
		}
	}

	public void authorizedUserControl() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();

		if (!authentication.getPrincipal().toString().equals("anonymousUser")) {
			NavigationHandler nh = FacesContext.getCurrentInstance()
					.getApplication().getNavigationHandler();
			nh.handleNavigation(FacesContext.getCurrentInstance(), null,
					"/pages/index.xhtml?faces-redirect=true");
//			System.out.println(SecurityContextHolder.getContext()
//					.getAuthentication().getPrincipal());
		}
	}
}
