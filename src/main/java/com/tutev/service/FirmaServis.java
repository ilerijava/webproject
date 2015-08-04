/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.service;

import com.tutev.dao.GenericDao;
import com.tutev.entity.Firma;

import java.util.List;

/**
 * @author Tutev
 */
public class FirmaServis {
  GenericDao genericDao = new GenericDao();

  public void save(Firma firma) {
    if (firma.getId() == null) {
      return;
    }
    genericDao.save(firma);
  }

  public void update(Firma firma) {
    if (firma.getId() == null) {
      return;
    }
    genericDao.saveOrUpdate(firma);
  }

  public void delete(Firma firma) {
    genericDao.delete(firma);
  }

  @SuppressWarnings("unchecked")
  public List<Firma> getAll() {
    return (List<Firma>) genericDao.get(Firma.class);
  }
}
