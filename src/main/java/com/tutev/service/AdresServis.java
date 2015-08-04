package com.tutev.service;

import com.tutev.dao.GenericDao;
import com.tutev.entity.Adres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service("AdresServis")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class AdresServis {

  @Autowired
  BaseServis baseServis;

  public BaseServis getBaseServis() {
    return baseServis;
  }

  public void setBaseServis(BaseServis baseServis) {
    this.baseServis = baseServis;
  }

  @Transactional(readOnly = false)
  public Adres save(Adres adres) {
    return (Adres) baseServis.save(adres);
  }

  @Transactional(readOnly = false)
  public void update(Adres adres) {
    if (adres.getId() == null) {
      return;
    }
    baseServis.update(adres);
  }

  @Transactional(readOnly = false)
  public void delete(Adres adres) {
    baseServis.delete(adres);
  }

  public List<Adres> getAll() {
    return (List<Adres>) baseServis.get(Adres.class);
  }
}
