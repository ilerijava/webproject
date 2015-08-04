package com.tutev.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("rawtypes")
public class BaseServis {

  @Autowired
  private SessionFactory sessionFactory;

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public Object save(Object o) {
    try {
      Session session = getSession();
      session.save(o);
      session.flush();
      Object savedObject = get(o.getClass());
      return savedObject;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void delete(Object o) {
    try {
      Session session = getSession();
      session.delete(o);
      session.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void update(Object o) {
    try {
      Session session = getSession();
      session.update(o);
      session.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Object get(Class cls) {
    Object o = null;
    try {
      Session session = getSession();
      o = session.createCriteria(cls).addOrder(Order.desc("id")).list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return o;
  }

  public Object getById(Class cls, Long id) {
    Object o = null;
    try {
      Session session = getSession();
      Criteria criteria = session.createCriteria(cls);
      criteria.add(Restrictions.idEq(id));
      o = criteria.uniqueResult();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return o;
  }

  public Object get(String[] parameterNames, Object[] parameterValues,
                    Class cls) {
    Object o = null;
    try {
      Criteria criteria = getSession().createCriteria(cls);

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

  public Session getSession() {
    Session currentSession = getSessionFactory().openSession();
    return currentSession;
  }
}
