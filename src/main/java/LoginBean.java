import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tutev.personelozluk.entity.Kisi;
import com.tutev.personelozluk.service.LoginServis;

@ManagedBean

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
					"Kullan�c� giri�i ba�ar�l�");
			FacesContext.getCurrentInstance().addMessage(null, message);
			FacesContext.getCurrentInstance().
			  getExternalContext().redirect("kisiListe.xhtml");
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hata",
					"Kullan�c� giri�i ba�ar�s�z");
			FacesContext.getCurrentInstance().
			  getExternalContext().redirect("login.xhtml");

		}
		

	}

}
