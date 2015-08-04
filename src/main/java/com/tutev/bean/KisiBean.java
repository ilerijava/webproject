package com.tutev.bean;

import com.tutev.entity.Adres;
import com.tutev.entity.Il;
import com.tutev.entity.Ilce;
import com.tutev.entity.Kisi;
import com.tutev.entity.Tema;
import com.tutev.service.AdresServis;
import com.tutev.service.IlServis;
import com.tutev.service.IlceServis;
import com.tutev.service.KisiServis;
import com.tutev.service.TemaServis;
import com.tutev.util.MessageUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "kisiView")
@ViewScoped
public class KisiBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @ManagedProperty(value = "#{IlServis}")
  IlServis ilServis;

  @ManagedProperty(value = "#{IlceServis}")
  IlceServis ilceServis;

  @ManagedProperty(value = "#{KisiServis}")
  KisiServis kisiServis;

  @ManagedProperty(value = "#{AdresServis}")
  AdresServis adresServis;

  @ManagedProperty("#{TemaServis}")
  private TemaServis temaServis;

  private List<Kisi> kisiList;

  private Kisi selectedKisi = new Kisi();

  private List<Il> ilList = new ArrayList<Il>();
  private List<Ilce> ilceList = new ArrayList<Ilce>();
  private List<Tema> temaList;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  @PostConstruct
  public void initialize() {
    setTemaList(temaServis.getTemaList());
    setKisiList(kisiServis.getAll());
    setIlList((ilServis.getAll()));
    if (selectedKisi.getAdres().getIl().getId() == null) {
      getIlceList().clear();
    } else {
      getIlceList().clear();
      setIlceList(ilceServis.getAllById(selectedKisi.getAdres().getIl()
          .getId().toString()));
    }
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
    if (selectedKisi.getAdres().getIl().getId() == null) {
      getIlceList().clear();
    } else {
      getIlceList().clear();
      setIlceList(ilceServis.getAllById(selectedKisi.getAdres().getIl()
          .getId().toString()));
    }
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
     // adresServis.update(selectedKisi.getAdres());
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
    MessageUtil.addInfoMessage(selectedKisi.getAd() + " "
        + selectedKisi.getSoyad() + " Silindi");
  }

  public void bosKisiEkle() {
    selectedKisi = new Kisi();
  }

  public void ilceGetirByIl(ValueChangeEvent event) {
    if (selectedKisi.getAdres().getIl().getId() == null) {
      MessageUtil.addErrorMessage("İl bilgisi boş olamaz.");
      return;
    }

    ilceList = ilceServis.getAllById(selectedKisi.getAdres().getIl()
        .getId().toString());
  }

  public IlServis getIlServis() {
    return ilServis;
  }

  public void setIlServis(IlServis ilServis) {
    this.ilServis = ilServis;
  }

  public IlceServis getIlceServis() {
    return ilceServis;
  }

  public void setIlceServis(IlceServis ilceServis) {
    this.ilceServis = ilceServis;
  }

  public KisiServis getKisiServis() {
    return kisiServis;
  }

  public void setKisiServis(KisiServis kisiServis) {
    this.kisiServis = kisiServis;
  }

  public AdresServis getAdresServis() {
    return adresServis;
  }

  public void setAdresServis(AdresServis adresServis) {
    this.adresServis = adresServis;
  }

  public TemaServis getTemaServis() {
    return temaServis;
  }

  public void setTemaServis(TemaServis servis) {
    this.temaServis = servis;
  }
}
