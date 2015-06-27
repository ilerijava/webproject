/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.personelozluk.service;

import java.util.List;

import com.tutev.personelozluk.dao.GenericDao;
import com.tutev.personelozluk.entity.Adres;

/**
 *
 * @author Tutev
 */
public class AdresServis {
	GenericDao genericDao = new GenericDao();

	public void save(Adres adres) {
		if (adres.getId() == null) {
			return;
		}
		genericDao.save(adres);
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

	@SuppressWarnings("unchecked")
	public List<Adres> getAll() {
		return (List<Adres>) genericDao.get(Adres.class);
	}
}
