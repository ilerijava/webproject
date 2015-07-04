package com.tutev.personelozluk.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;

import com.tutev.personelozluk.entity.Adres;
import com.tutev.personelozluk.entity.Il;
import com.tutev.personelozluk.entity.Ilce;
import com.tutev.personelozluk.entity.Kisi;
import com.tutev.personelozluk.service.AdresServis;
import com.tutev.personelozluk.service.IlServis;
import com.tutev.personelozluk.service.IlceServis;
import com.tutev.personelozluk.service.KisiServis;

@ManagedBean(name = "kisiView")
@ViewScoped
public class KisiBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Kisi> kisiList;
	
	IlServis ilServis = new IlServis();
	IlceServis ilceServis = new IlceServis();
	KisiServis kisiServis = new KisiServis();
	AdresServis adresServis = new AdresServis();


	private Kisi selectedKisi = new Kisi();

	private List<Il> ilList = new ArrayList<Il>();
	private List<Ilce> ilceList = new ArrayList<Ilce>();

	@PostConstruct
	public void initialize() {
		kisiList = (kisiServis.getAll());
		setIlList((ilServis.getAll()));
		setIlceList((ilceServis.getAll()));
	}

	public List<Kisi> getKisiList() {
		return kisiList;
	}

	public void setKisiList(List<Kisi> kisiList) {
		this.kisiList = kisiList;
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
	
	public Kisi getSelectedKisi() {
		return selectedKisi;
	}

	public void setSelectedKisi(Kisi selectedKisi) {
		this.selectedKisi = selectedKisi;
	}
	
	public void listeYenile(){
		setKisiList(kisiServis.getAll());
	}
		
	public void kaydet(){
		if(selectedKisi.getId()==null){
			Adres savedAdres = adresServis.save(selectedKisi.getAdres());
			selectedKisi.setAdres(savedAdres);
			kisiServis.save(selectedKisi);						
		}else{
			adresServis.update(selectedKisi.getAdres());
			kisiServis.update(selectedKisi);						
		}
	}
	
	public void sil(){
		System.out.println(selectedKisi.getAd());
		System.out.println(selectedKisi.getSoyad());
        /*FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kişi Silindi", kisi.getAd() + " " + kisi.getSoyad());
        FacesContext.getCurrentInstance().addMessage(null, message);*/
	}
	
	public void bosKisiEkle(){
		selectedKisi = new Kisi();
	}
	


}
