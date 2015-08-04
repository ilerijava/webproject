/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.service;

import com.tutev.dao.GenericDao;
import com.tutev.entity.Kisi;

import java.util.List;

/**
 * @author Tutev
 */
@SuppressWarnings("unchecked")
public class KisiServis {
  GenericDao genericDao = new GenericDao();

  AdresServis adresServis = new AdresServis();

  public Kisi save(Kisi kisi) {
    if (kisi.getTcKimlikNo() == null) {
      return null;
    }
    return (Kisi) genericDao.save(kisi);
  }

  public void update(Kisi kisi) {
    if (kisi.getId() == null && kisi.getTcKimlikNo() == null) {
      return;
    }
    genericDao.saveOrUpdate(kisi);
  }

  public void delete(Kisi kisi) {
    genericDao.delete(kisi);
    adresServis.delete(kisi.getAdres());
  }

  public List<Kisi> getAll() {
    return (List<Kisi>) genericDao.get(Kisi.class);
  }

  public Kisi get(Kisi kisi) {
    return (Kisi) genericDao.getById(Kisi.class, kisi.getId());
  }
}
