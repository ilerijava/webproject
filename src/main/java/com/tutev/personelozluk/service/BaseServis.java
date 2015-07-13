
package com.tutev.personelozluk.service;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tutev.personelozluk.util.QueryResult;

@Repository("baseService")
public class BaseServis {
	
	@Autowired
	private transient SessionFactory sessionFactory;

	@Transactional(readOnly=false)
    public void save(Object o) {
        try {
        	getSession().save(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public void saveOrUpdate(Object o) {
        try {
        	Session session = getSession();
            session.saveOrUpdate(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public void delete(Object o) {
        try {
        	Session session = getSession();
            session.delete(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public void update(Object o) {
        try {
        	Session session = getSession();
            session.update(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Transactional(propagation=Propagation.REQUIRED)
    public Object getById(@SuppressWarnings("rawtypes") Class cls, Long id) {
        Object o=null;
        try {
            Session session = getSession();
            Criteria criteria = session.createCriteria(cls);
            criteria.add(Restrictions.idEq(id));
            o= criteria.uniqueResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
	
	public QueryResult getByFilter(int first, int pageSize,SortOrder sortOrder, Map<String, String> filters,Criteria criteria) {
		QueryResult qr = new QueryResult();	
		criteria.setProjection(Projections.rowCount());
		qr.setCount(((Long) criteria.uniqueResult()).intValue());
		
        criteria.setProjection(null);
        criteria.setResultTransformer(Criteria.ROOT_ENTITY);		
		qr.setList(criteria.setFirstResult(first).setMaxResults(pageSize).list());
		return qr;
	}

    public Session getSession() {
        return getSessionFactory().getCurrentSession();
    }
    
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
