/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.personelozluk.service;

import java.util.List;

import com.tutev.personelozluk.dao.GenericDao;
import com.tutev.personelozluk.entity.Kisi;

/**
 *
 * @author Tutev
 */
public class KisiServis {
	GenericDao genericDao = new GenericDao();

	public void save(Kisi kisi) {
		if (kisi.getTcKimlikNo() == null) {
			return;
		}
		genericDao.save(kisi);
	}

	public void update(Kisi kisi) {
		if (kisi.getId() == null && kisi.getTcKimlikNo() == null) {
			return;
		}
		genericDao.saveOrUpdate(kisi);
	}

	public void delete(Kisi kisi) {
		genericDao.delete(kisi);
	}

	@SuppressWarnings("unchecked")
	public List<Kisi> getAll() {
		return (List<Kisi>) genericDao.get(Kisi.class);
	}
	
	public Kisi get(Kisi kisi){
		return (Kisi) genericDao.getById(Kisi.class, kisi.getId());
	}
}
