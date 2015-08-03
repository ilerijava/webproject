/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.service;

import java.io.Serializable;
import java.util.List;

import com.tutev.dao.GenericDao;
import com.tutev.entity.Il;

@SuppressWarnings("unchecked")
public class IlServis  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7808345258454958968L;
	
	GenericDao genericDao = new GenericDao();

	public Il save(Il il) {
		return (Il) genericDao.save(il);
	}

	public void update(Il il) {
		if (il.getId() == null) {
			return;
		}
		genericDao.saveOrUpdate(il);
	}

	public void delete(Il il) {
		genericDao.delete(il);
	}


	public List<Il> getAll() {
		return (List<Il>) genericDao.get(Il.class);
	}

	public Il getById(String id) {
		return (Il) genericDao.getById(Il.class, new Long(id));
	}
}
