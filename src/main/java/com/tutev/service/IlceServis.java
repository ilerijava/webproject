/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.service;

import java.util.List;

import com.tutev.dao.GenericDao;
import com.tutev.entity.Il;
import com.tutev.entity.Ilce;
import com.tutev.entity.Kisi;

/**
 *
 * @author Tutev
 */
public class IlceServis {
	GenericDao genericDao = new GenericDao();
	
	IlServis ilServis = new IlServis();

	public Ilce save(Ilce ilce) {
		return (Ilce) genericDao.save(ilce);
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

	public List<Ilce> getAllById(String ilID) {
		Il il = ilServis.getById(ilID);
		String[] parameterNames = { "il" };
		Object[] parameterValues = { il };

		List<Ilce> list = (List<Ilce>) genericDao.get(parameterNames,
				parameterValues, Ilce.class);
		return list;
	}
}
