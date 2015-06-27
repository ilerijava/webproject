/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.personelozluk.service;

import java.util.List;

import com.tutev.personelozluk.dao.GenericDao;
import com.tutev.personelozluk.entity.Firma;

/**
 *
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
