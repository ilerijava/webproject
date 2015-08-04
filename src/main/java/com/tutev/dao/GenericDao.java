/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutev.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;

public class GenericDao implements Serializable {

  private static final long serialVersionUID = 989736391622436170L;

  public Object save(Object object) {
    try {
      Session session = getSessionFactory().openSession();
      Transaction tx = session.beginTransaction();
      session.save(object);
      session.flush();
      tx.commit();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return object;
  }

  public Object saveOrUpdate(Object object) {
    try {
      Session session = getSessionFactory().openSession();
      Transaction tx = session.beginTransaction();
      session.saveOrUpdate(object);
      session.flush();
      tx.commit();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return object;
  }

  public void delete(Object object) {
    try {
      Session session = getSessionFactory().openSession();
      Transaction tx = session.beginTransaction();
      session.delete(object);
      session.flush();
      tx.commit();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Object get(Class cls) {
    Object o = null;
    try {
      Session session = getSessionFactory().openSession();
      o = session.createCriteria(cls).addOrder(Order.desc("id")).list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return o;
  }

  public Object getById(Class cls, Long id) {
    Object o = null;
    try {
      Session session = getSessionFactory().openSession();
      Transaction tx = session.beginTransaction();
      o = session.get(cls, id);
      session.flush();
      tx.commit();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return o;
  }

  public SessionFactory getSessionFactory() {
    return HibernateUtil.getSessionFactory();
  }

  public Object get(String[] parameterNames, Object[] parameterValues,
                    Class cls) {
    Object o = null;
    try {
      Session session = getSessionFactory().openSession();

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
