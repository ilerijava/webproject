package com.tutev.personelozluk.service;

import java.util.List;

import com.tutev.personelozluk.dao.GenericDao;
import com.tutev.personelozluk.entity.Kisi;

public class LoginServis {
	GenericDao genericDao = new GenericDao();

	public Kisi login(String tcKimlikNo, String sifre) {
		String[] parameterNames = { "tcKimlikNo", "sifre" };
		String[] parameterValues = { tcKimlikNo, sifre };
		List<Kisi> list = (List<Kisi>) genericDao.get(parameterNames,
				parameterValues, Kisi.class);
		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

}
