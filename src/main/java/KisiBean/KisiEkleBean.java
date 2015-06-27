package KisiBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
public class KisiEkleBean implements Serializable{

	IlServis ilServis = new IlServis();
	IlceServis ilceServis = new IlceServis();
	KisiServis kisiServis = new KisiServis();
	AdresServis adresServis = new AdresServis();

	private String ad;
	private String soyad;
	private String kimlikNo;
	private String sifre;
	private String adres;
	private String ilID;
	private String ilceID;
	private Kisi kisi;

	private List<Il> ilList;
	private List<Ilce> ilceList;

	
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

	public String getKimlikNo() {
		return kimlikNo;
	}

	public void setKimlikNo(String kimlikNo) {
		this.kimlikNo = kimlikNo;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
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

	public Kisi getKisi() {
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}

	public void kaydet() {
		Kisi kisi = new Kisi();
		kisi.setAd(ad);
		kisi.setSoyad(soyad);
		kisi.setSifre(sifre);
		kisi.setTcKimlikNo(kimlikNo);
		
		Adres ads = new Adres();
		ads.setAdresTanim(adres);
		
		Il il = ilServis.getById(getIlID());
		ads.setIl(il);
		
		Ilce ilce = ilceServis.getById(getIlceID());
		
		ads.setIlce(ilce);
		
		Adres adres2 = adresServis.save(ads);
		kisi.setAdres(adres2);
		
		kisiServis.save(kisi);
	}
	
	
	public void ilChange(){
		System.out.println("geldi");
		if(getIlID() != null){
			List<Ilce> temp = new ArrayList<Ilce>();
			for (Ilce ilce : ilceList) {
				if(ilce.getIl().getId().equals(getIlID())){
					temp.add(ilce);
				}
			}
			
			ilceList = temp;
		}
	}

}
