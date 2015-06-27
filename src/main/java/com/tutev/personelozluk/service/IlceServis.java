/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.personelozluk.service;

import java.util.List;

import com.tutev.personelozluk.dao.GenericDao;
import com.tutev.personelozluk.entity.Ilce;

/**
 *
 * @author Tutev
 */
public class IlceServis {
	GenericDao genericDao = new GenericDao();

	public void save(Ilce ilce) {
		if (ilce.getId() == null) {
			return;
		}
		genericDao.save(ilce);
	}

	public void update(Ilce ilce) {
		if (ilce.getId() == null) {
			return;
		}
		genericDao.saveOrUpdate(ilce);
	}

	public void delete(Ilce ilce) {
		genericDao.delete(ilce);
	}

	@SuppressWarnings("unchecked")
	public List<Ilce> getAll() {
		return (List<Ilce>) genericDao.get(Ilce.class);
	}

	public Ilce getById(String id) {
		return (Ilce) genericDao.getById(Ilce.class, new Long(id));
	}
}
