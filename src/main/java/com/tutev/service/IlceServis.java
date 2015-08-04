package com.tutev.service;

import com.tutev.entity.Il;
import com.tutev.entity.Ilce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("IlceServis")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class IlceServis {

  @Autowired
  BaseServis baseServis;

  @Autowired
  IlServis ilServis;

  public BaseServis getBaseServis() {
    return baseServis;
  }

  public void setBaseServis(BaseServis baseServis) {
    this.baseServis = baseServis;
  }

  public IlServis getIlServis() {
    return ilServis;
  }

  public void setIlServis(IlServis ilServis) {
    this.ilServis = ilServis;
  }

  @Transactional(readOnly = false)
  public Ilce save(Ilce ilce) {
    return (Ilce) baseServis.save(ilce);
  }

  @Transactional(readOnly = false)
  public void update(Ilce ilce) {
    if (ilce.getId() == null) {
      return;
    }
    baseServis.update(ilce);
  }

  @Transactional(readOnly = false)
  public void delete(Ilce ilce) {
    baseServis.delete(ilce);
  }

  public List<Ilce> getAll() {
    return (List<Ilce>) baseServis.get(Ilce.class);
  }

  public Ilce getById(String id) {
    return (Ilce) baseServis.getById(Ilce.class, new Long(id));
  }

  public List<Ilce> getAllById(String ilID) {
    Il il = ilServis.getById(ilID);
    String[] parameterNames = {"il"};
    Object[] parameterValues = {il};

    List<Ilce> list = (List<Ilce>) baseServis.get(parameterNames,
        parameterValues, Ilce.class);
    return list;
  }
}
