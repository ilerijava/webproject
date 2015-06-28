package KisiBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.tutev.personelozluk.entity.Adres;
import com.tutev.personelozluk.entity.Il;
import com.tutev.personelozluk.entity.Ilce;
import com.tutev.personelozluk.entity.Kisi;
import com.tutev.personelozluk.service.AdresServis;
import com.tutev.personelozluk.service.IlServis;
import com.tutev.personelozluk.service.IlceServis;
import com.tutev.personelozluk.service.KisiServis;

@ManagedBean(name = "kisiEkle")
@ViewScoped
public class KisiEkleBean implements Serializable {

	private static final long serialVersionUID = 1L;
	IlServis ilServis = new IlServis();
	IlceServis ilceServis = new IlceServis();
	KisiServis kisiServis = new KisiServis();
	AdresServis adresServis = new AdresServis();

	private String ad;
	private String soyad;
	private String tcKimlikNo;
	private String sifre;
	private String adresTanim;
	private String ilID;
	private String ilceID;

	private Kisi selectedKisi = new Kisi();

	private List<Il> ilList = new ArrayList<Il>();
	private List<Ilce> ilceList = new ArrayList<Ilce>();

	@PostConstruct
	public void initialize() {
		setIlList((ilServis.getAll()));
		setIlceList((ilceServis.getAll()));
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTcKimlikNo() {
		return tcKimlikNo;
	}

	public void setTcKimlikNo(String tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getAdresTanim() {
		return adresTanim;
	}

	public void setAdresTanim(String adresTanim) {
		this.adresTanim = adresTanim;
	}

	public String getIlID() {
		return ilID;
	}

	public void setIlID(String ilID) {
		this.ilID = ilID;
	}

	public String getIlceID() {
		return ilceID;
	}

	public void setIlceID(String ilceID) {
		this.ilceID = ilceID;
	}

	public List<Il> getIlList() {
		return ilList;
	}

	public void setIlList(List<Il> ilList) {
		this.ilList = ilList;
	}

	public List<Ilce> getIlceList() {
		return ilceList;
	}

	public void setIlceList(List<Ilce> ilceList) {
		this.ilceList = ilceList;
	}

	public void kaydet() {
		Adres kayitliAdres = adresServis.save(selectedKisi.getAdres());

		selectedKisi.setAdres(kayitliAdres);

		kisiServis.save(selectedKisi);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Kiþi Kaydedildi", selectedKisi.getAd() + " "
						+ selectedKisi.getSoyad());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void ilChange() {
		List<Ilce> ilceler = ilceServis.getAllById(getIlID());
		ilceList.clear();
		ilceList.addAll(ilceler);
	}

	public Kisi getSelectedKisi() {
		return selectedKisi;
	}

	public void setSelectedKisi(Kisi selectedKisi) {
		this.selectedKisi = selectedKisi;
	}
}
