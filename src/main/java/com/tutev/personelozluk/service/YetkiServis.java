package com.tutev.personelozluk.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutev.personelozluk.entity.Kullanici;
import com.tutev.personelozluk.entity.Result;
import com.tutev.personelozluk.entity.Yetki;
import com.tutev.personelozluk.util.QueryResult;


@Service("yetkiService")
public class YetkiServis{
	
	@Autowired
	private transient BaseServis baseServis;

	public Result save(Yetki yetki) {
		Result r=new Result();
		
		try {
			
			if(yetki==null || yetki.getTanim().trim().equals("")){
				r.setObject(yetki);
				r.setIslemSonuc(Boolean.FALSE);
				r.getMessages().add("Tanım Boş Olamaz");
				return r;
			}
			
			baseServis.save(yetki);
			r.setObject(yetki);
			r.setIslemSonuc(Boolean.TRUE);
			r.getMessages().add("Yetki Eklendi");
			
		}catch (Exception e) {
			r.setIslemSonuc(Boolean.FALSE);
			r.setException(e);
		}
		return r;
	}

	public Result update(Yetki yetki) {
		Result r=new Result();
		try {
			
			if(yetki==null || yetki.getTanim().trim().equals("")){
				r.setObject(yetki);
				r.getMessages().add("Tanım Boş Olamaz");
				r.setIslemSonuc(Boolean.TRUE);
				return r;
			}
			
			baseServis.update(yetki);
			r.setObject(yetki);
			r.setIslemSonuc(Boolean.TRUE);
			r.getMessages().add("Yetki Güncellendi");
		}catch (Exception e) {
			r.setIslemSonuc(Boolean.FALSE);
			r.setException(e);
		}
		return r;
	}

	public Result delete(Yetki yetki) {
		Result r=new Result();
		try {
			baseServis.delete(yetki);
			r.setObject(yetki);
			r.setIslemSonuc(Boolean.TRUE);
			r.getMessages().add("Yetki Silindi");
		}catch (Exception e) {
			r.setIslemSonuc(Boolean.FALSE);
			r.setException(e);
		}
		return r;
	}

	public Result deleteById(Long id) {
		Result r=new Result();
		try {
			Yetki yetki=getById(id);
			baseServis.delete(yetki);
			r.setIslemSonuc(Boolean.TRUE);
			r.getMessages().add("Yetki Silindi");
		}catch (Exception e) {
			r.setIslemSonuc(Boolean.FALSE);
			r.setException(e);
		}
		return r;
	}

	public Yetki getById(Long id) {
		Criteria criteria=baseServis.getSession().createCriteria(Yetki.class);
		criteria.add(Restrictions.idEq(id));
		return (Yetki)criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Yetki> getAll() {
		Criteria criteria=baseServis.getSession().createCriteria(Yetki.class);
		criteria.addOrder(Order.asc("id"));
		return (List<Yetki>)criteria.list();
	}

	public QueryResult getByFilter(int first, int pageSize,SortOrder sortOrder, Map<String, String> filters) {
		Criteria criteria=baseServis.getSession().createCriteria(Yetki.class);
			return baseServis.getByFilter(first, pageSize, sortOrder, filters, criteria);
		}
	
	@Transactional
	public Kullanici getUserByUsernameAndPassword(String kullaniciAdi,String sifre) {
		Criteria criteria=baseServis.getSession().createCriteria(Kullanici.class);
		criteria.add(Restrictions.eq("username", kullaniciAdi));
		criteria.add(Restrictions.eq("password", sifre));
		return (Kullanici) criteria.uniqueResult();

	}
	
}
