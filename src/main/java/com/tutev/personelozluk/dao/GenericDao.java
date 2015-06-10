/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutev.personelozluk.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

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
}
