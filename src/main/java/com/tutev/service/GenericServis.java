package com.tutev.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutev.entity.Adres;


@Service("genericService")
@Transactional
public class GenericServis {
	
	@Autowired
	private transient BaseServis baseServis;
	
	public List<Adres> getIlByName(String key) {
		Criteria criteria = baseServis.getSession().createCriteria(Adres.class);
		Criteria criteriaTip = criteria.createAlias("kod", "kod");
		criteria.add(Restrictions.ilike("tanim", key,MatchMode.ANYWHERE));
		criteria.addOrder(Order.asc("tanim"));
		return (List<Adres>)criteria.list();
	}

	public Adres getIlById(Long id) {
		Criteria criteria = baseServis.getSession().createCriteria(Adres.class);
		criteria.add(Restrictions.idEq(id));
		return (Adres) criteria.uniqueResult();
	}
}
