package com.tutev.personelozluk.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.tutev.personelozluk.entity.Adres;
import com.tutev.personelozluk.entity.Il;
import com.tutev.personelozluk.entity.Ilce;
import com.tutev.personelozluk.entity.Kisi;
import com.tutev.personelozluk.entity.Tema;
import com.tutev.personelozluk.service.AdresServis;
import com.tutev.personelozluk.service.IlServis;
import com.tutev.personelozluk.service.IlceServis;
import com.tutev.personelozluk.service.KisiServis;
import com.tutev.personelozluk.service.TemaServis;
import com.tutev.personelozluk.util.MessageUtil;

@ManagedBean(name = "kisiView")
@ViewScoped
public class KisiBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Kisi> kisiList;

	IlServis ilServis = new IlServis();
	IlceServis ilceServis = new IlceServis();
	KisiServis kisiServis = new KisiServis();
	AdresServis adresServis = new AdresServis();

	@ManagedProperty("#{temaServis}")
	private TemaServis temaServis;

	private Kisi selectedKisi = new Kisi();

	private List<Il> ilList = new ArrayList<Il>();
	private List<Ilce> ilceList = new ArrayList<Ilce>();
	private List<Tema> temaList;

	@PostConstruct
	public void initialize() {
		setKisiList(kisiServis.getAll());
		setIlList((ilServis.getAll()));
		setIlceList((ilceServis.getAll()));
		setTemaList(temaServis.getTemaList());
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

	public List<Tema> getTemaList() {
		return temaList;
	}

	public void setTemaList(List<Tema> temaList) {
		this.temaList = temaList;
	}

	public void listeYenile() {
		setKisiList(kisiServis.getAll());
	}

	public void kaydet() {
		if (selectedKisi.getId() == null) {
			Adres savedAdres = adresServis.save(selectedKisi.getAdres());
			selectedKisi.setAdres(savedAdres);
			kisiServis.save(selectedKisi);
			MessageUtil.addInfoMessage(selectedKisi.getAd() + " "
					+ selectedKisi.getSoyad() + " Eklendi");
		} else {
			adresServis.update(selectedKisi.getAdres());
			kisiServis.update(selectedKisi);
			MessageUtil.addInfoMessage(selectedKisi.getAd() + " "
					+ selectedKisi.getSoyad() + " Düzenlendi");
		}
	}

	public void sil() {
		if (selectedKisi.getId() == null) {
			MessageUtil.addErrorMessage("Kişi bilgisi boş olamaz.");
			return;
		}

		kisiServis.delete(selectedKisi);
		MessageUtil.addInfoMessage("Kişi Silindi");
	}

	public void bosKisiEkle() {
		selectedKisi = new Kisi();
	}

	public void ilceGetirByIl() {
		if (selectedKisi.getAdres().getIl().getId() == null) {
			MessageUtil.addErrorMessage("İl bilgisi boş olamaz.");
			return;
		}

		ilceList = ilceServis.getAllById(selectedKisi.getAdres().getIl()
				.getId().toString());
	}

	public void setTemaServis(TemaServis servis) {
		this.temaServis = servis;
	}
}
