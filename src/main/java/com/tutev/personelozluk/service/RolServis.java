package com.tutev.personelozluk.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutev.personelozluk.entity.Kullanici;
import com.tutev.personelozluk.entity.KullaniciYetkiRol;
import com.tutev.personelozluk.entity.Rol;
import com.tutev.personelozluk.entity.Result;
import com.tutev.personelozluk.entity.Yetki;
import com.tutev.personelozluk.util.QueryResult;

@Service("rolService")
public class RolServis {

	@Autowired
	private transient BaseServis baseServis;

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

	@SuppressWarnings("unchecked")
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
		Criteria criteria = baseServis.getSession().createCriteria(
				Kullanici.class);
		criteria.add(Restrictions.eq("username", username));
		return (Kullanici) criteria.uniqueResult();
	}

	public List<KullaniciYetkiRol> getKullaniciRolByKullaniciId(Long id) {
		Criteria criteria = baseServis.getSession().createCriteria(
				KullaniciYetkiRol.class);
		criteria.add(Restrictions.eq("kullanici.id", id));
		return criteria.list();
	}
}
