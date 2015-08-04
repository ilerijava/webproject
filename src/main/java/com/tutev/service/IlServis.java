package com.tutev.service;

import com.tutev.entity.Il;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("IlServis")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class IlServis {

  @Autowired
  BaseServis baseServis;

  public BaseServis getBaseServis() {
    return baseServis;
  }

  public void setBaseServis(BaseServis baseServis) {
    this.baseServis = baseServis;
  }

  @Transactional(readOnly = false)
  public Il save(Il il) {
    return (Il) baseServis.save(il);
  }

  @Transactional(readOnly = false)
  public void update(Il il) {
    if (il.getId() == null) {
      return;
    }
    baseServis.update(il);
  }

  @Transactional(readOnly = false)
  public void delete(Il il) {
    baseServis.delete(il);
  }

  public List<Il> getAll() {
    return (List<Il>) baseServis.get(Il.class);
  }

  public Il getById(String id) {
    return (Il) baseServis.getById(Il.class, new Long(id));
  }
}
