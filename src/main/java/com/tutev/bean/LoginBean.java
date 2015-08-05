package com.tutev.bean;

import com.tutev.util.MessageUtil;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import java.io.Serializable;

@ManagedBean(name = "loginView")
@RequestScoped
public class LoginBean implements Serializable {
	/**
   *
   */
	private static final long serialVersionUID = 6196800544465885933L;

	private String userName = null;
	private String password = null;

	@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager authenticationManager = null;

	public String login() {
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();

			if (auth.getPrincipal() instanceof String) {
				Authentication request = new UsernamePasswordAuthenticationToken(
						this.getUserName(), this.getPassword());

				Authentication result = authenticationManager
						.authenticate(request);

				SecurityContextHolder.getContext().setAuthentication(result);
			}
		} catch (AuthenticationException e) {
			MessageUtil.addInfoMessage(e.getMessage());
			return "incorrect";
		}
		return "correct";
	}

  public String index() {
    return "index";
  }

	public String logout() {
		SecurityContextHolder.clearContext();
		return "loggedout";
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
