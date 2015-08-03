package com.tutev.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutev.dao.GenericDao;
import com.tutev.entity.Kisi;
import com.tutev.entity.Kullanici;
import com.tutev.entity.KullaniciYetkiRol;
import com.tutev.entity.Result;
import com.tutev.entity.Rol;
import com.tutev.entity.Yetki;
import com.tutev.util.QueryResult;

@Service("rolService")
@SuppressWarnings("unchecked")
public class RolServis {

	@Autowired
	private transient BaseServis baseServis;

	GenericDao genericDao = new GenericDao();

	public Result save(Rol rol) {
		Result r = new Result();

		try {

			if (rol == null || rol.getTanim().trim().equals("")) {
				r.setObject(rol);
				r.setIslemSonuc(Boolean.FALSE);
				r.getMessages().add("Rol Bo� Olmamal�d�r");
				return r;
			}

			baseServis.save(rol);
			r.setObject(rol);
			r.setIslemSonuc(Boolean.TRUE);
			r.getMessages().add("Rol Eklendi");

		} catch (Exception e) {
			r.setIslemSonuc(Boolean.FALSE);
			r.setException(e);
		}
		return r;
	}

	public Result update(Rol rol) {
		Result r = new Result();
		try {

			if (rol == null || rol.getTanim().trim().equals("")) {
				r.setObject(rol);
				r.getMessages().add("Rol Bo� Olmamal�d�r");
				r.setIslemSonuc(Boolean.TRUE);
				return r;
			}

			baseServis.update(rol);
			r.setObject(rol);
			r.setIslemSonuc(Boolean.TRUE);
			r.getMessages().add("Rol G�ncellendi");
		} catch (Exception e) {
			r.setIslemSonuc(Boolean.FALSE);
			r.setException(e);
		}
		return r;
	}

	public Result delete(Rol rol) {
		Result r = new Result();
		try {
			baseServis.delete(rol);
			r.setObject(rol);
			r.setIslemSonuc(Boolean.TRUE);
			r.getMessages().add("Rol Silindi");
		} catch (Exception e) {
			r.setIslemSonuc(Boolean.FALSE);
			r.setException(e);
		}
		return r;
	}

	public Result deleteById(Long id) {
		Result r = new Result();
		try {
			Rol rol = getById(id);
			baseServis.delete(rol);
			r.setIslemSonuc(Boolean.TRUE);
			r.getMessages().add("Rol Silindi");
		} catch (Exception e) {
			r.setIslemSonuc(Boolean.FALSE);
			r.setException(e);
		}
		return r;
	}

	public Rol getById(Long id) {
		Criteria criteria = baseServis.getSession().createCriteria(Rol.class);
		criteria.add(Restrictions.idEq(id));
		return (Rol) criteria.uniqueResult();
	}

	public List<Rol> getAll() {
		Criteria criteria = baseServis.getSession().createCriteria(Rol.class);
		criteria.addOrder(Order.asc("id"));
		return (List<Rol>) criteria.list();
	}

	public QueryResult getByFilter(int first, int pageSize,
			SortOrder sortOrder, Map<String, String> filters) {
		Criteria criteria = baseServis.getSession().createCriteria(Rol.class);
		return baseServis.getByFilter(first, pageSize, sortOrder, filters,
				criteria);
	}

	public List<Yetki> getYetkiByRolId(Long id) {

		return null;
	}

	public Kullanici getUserByName(String username) {
		String[] parameterNames = { "username" };
		Object[] parameterValues = { username };

		List<Kullanici> list = (List<Kullanici>) genericDao.get(parameterNames,
				parameterValues, Kullanici.class);

		// Object object = genericDao.getById(Kullanici.class, 1L);
		Criteria criteria = baseServis.getSession().createCriteria(
				Kullanici.class);
		criteria.add(Restrictions.eq("username", username));
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<KullaniciYetkiRol> getKullaniciRolByKullaniciId(Long id) {
		String[] parameterNames = { "kullanici.id" };
		Object[] parameterValues = { id };

		List<KullaniciYetkiRol> list = (List<KullaniciYetkiRol>) genericDao
				.get(parameterNames, parameterValues, KullaniciYetkiRol.class);

		Criteria criteria = baseServis.getSession().createCriteria(
				KullaniciYetkiRol.class);
		criteria.add(Restrictions.eq("kullanici.id", id));
		return list;
	}
}
