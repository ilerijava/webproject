/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutev.personelozluk.dao;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.tutev.personelozluk.entity.Kisi;

/**
 *
 * @author Tutev
 */
public class GenericDao {

	SessionFactory tSessionFactory;

	public Object save(Object object) {
		try {
			Session session = gettSessionFactory().openSession();
			session.beginTransaction();
			session.save(object);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public Object saveOrUpdate(Object object) {
		try {
			Session session = gettSessionFactory().openSession();
			session.saveOrUpdate(object);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public void delete(Object object) {
		try {
			Session session = gettSessionFactory().openSession();
			session.delete(object);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object get(Class cls) {
		Object o = null;
		try {
			Session session = gettSessionFactory().openSession();
			o = session.createCriteria(cls).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}

	public Object getById(Long id) {
		Object o = null;
		try {
			Session session = gettSessionFactory().openSession();
			o = session.get(id.toString(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}

	public SessionFactory gettSessionFactory() {
		return THibernateUtil.getSessionFactory();
	}

	public Object get(String[] parameterNames, String[] parameterValues,
			Class cls) {
		Object o = null;
		try {
			Session session = gettSessionFactory().openSession();

			Criteria criteria = session.createCriteria(cls);

			for (int i = 0; i < parameterNames.length; i++) {
				criteria = criteria.add(Restrictions.eq(parameterNames[i],
						parameterValues[i]));
			}
			o = criteria.list();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			return o;
		}

	}

}
