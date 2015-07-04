package com.tutev.personelozluk.bean;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tutev.personelozluk.entity.Kisi;
import com.tutev.personelozluk.service.LoginServis;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean {

	private String kullaniciAdi;

	private String sifre;

	private LoginServis loginServis = new LoginServis();

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public void login(ActionEvent event) throws Exception {

		Kisi kisi = loginServis.login(kullaniciAdi, sifre);

		FacesMessage message = null;
		if (kisi != null) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tebrikler",
					"Kullanýcý giriþi baþarýlý");
			FacesContext.getCurrentInstance().addMessage(null, message);
			FacesContext.getCurrentInstance().
			  getExternalContext().redirect("kisi.xhtml");
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hata",
					"Kullanýcý giriþi baþarýsýz");
			FacesContext.getCurrentInstance().
			  getExternalContext().redirect("login.xhtml");

		}
		

	}

}
