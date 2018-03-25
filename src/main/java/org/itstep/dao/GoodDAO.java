package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.model.Good;
import org.itstep.util.HibernateUtil;

public class GoodDAO {

 private Session session;

 public void save(Good good) {

 session = HibernateUtil.getSessionFactory().openSession();

 session.getTransaction().begin();

 session.save(good);

 session.getTransaction().commit();

 session.close();
 }

 public Good get(String asin) {

 session = HibernateUtil.getSessionFactory().openSession();

 session.getTransaction().begin();

 Good good = session.get(Good.class, asin);

 session.getTransaction().commit();

 session.close();
 
 return good;
 }
 
 public List<Good> getByNameAndPassword(String name, String shop_url) {

 session = HibernateUtil.getSessionFactory().openSession();

 session.getTransaction().begin();

 Query query = session.createNativeQuery("SELECT * FROM good WHERE name=:name AND shop_url=:url", Good.class);
 
 query.setParameter("name", name);
 
 query.setParameter("pass", shop_url);

 List<Good> result = query.getResultList();

 session.getTransaction().commit();

 session.close();
 
 return result;
 }

 public void delete(Good good) {
 
 session = HibernateUtil.getSessionFactory().openSession();

 session.getTransaction().begin();

 session.delete(good);

 session.getTransaction().commit();

 session.close();
 }
 
}