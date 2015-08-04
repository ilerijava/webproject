package com.tutev.service;

import com.tutev.entity.Kisi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service("KisiServis")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class KisiServis {

  @Autowired
  BaseServis baseServis;

  @Autowired
  AdresServis adresServis;

  public BaseServis getBaseServis() {
    return baseServis;
  }

  public void setBaseServis(BaseServis baseServis) {
    this.baseServis = baseServis;
  }

  public AdresServis getAdresServis() {
    return adresServis;
  }

  public void setAdresServis(AdresServis adresServis) {
    this.adresServis = adresServis;
  }

  @Transactional(readOnly = false)
  public Kisi save(Kisi kisi) {
    if (kisi.getTcKimlikNo() == null) {
      return null;
    }
    return (Kisi) baseServis.save(kisi);
  }

  @Transactional(readOnly = false)
  public void update(Kisi kisi) {
    if (kisi.getId() == null && kisi.getTcKimlikNo() == null) {
      return;
    }
    baseServis.update(kisi);
  }

  @Transactional(readOnly = false)
  public void delete(Kisi kisi) {
    baseServis.delete(kisi);
    adresServis.delete(kisi.getAdres());
  }

  public List<Kisi> getAll() {
    return (List<Kisi>) baseServis.get(Kisi.class);
  }

  public Kisi get(Kisi kisi) {
    return (Kisi) baseServis.getById(Kisi.class, kisi.getId());
  }
}
