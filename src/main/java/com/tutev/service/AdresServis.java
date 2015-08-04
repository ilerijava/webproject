/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.service;

import com.tutev.dao.GenericDao;
import com.tutev.entity.Adres;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
public class AdresServis implements Serializable {

  private static final long serialVersionUID = 6070600959662672452L;

  GenericDao genericDao = new GenericDao();

  public Adres save(Adres adres) {
    return (Adres) genericDao.save(adres);
  }

  public void update(Adres adres) {
    if (adres.getId() == null) {
      return;
    }
    genericDao.saveOrUpdate(adres);
  }

  public void delete(Adres adres) {
    genericDao.delete(adres);
  }


  public List<Adres> getAll() {
    return (List<Adres>) genericDao.get(Adres.class);
  }
}
