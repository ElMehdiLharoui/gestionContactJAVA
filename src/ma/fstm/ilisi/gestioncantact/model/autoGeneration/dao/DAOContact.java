package ma.fstm.ilisi.gestioncantact.model.dao;


import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ma.fstm.ilisi.gestioncantact.model.bo.Contact;
import ma.fstm.ilisi.gestioncantact.model.dao.hib.hibutil;

public class DAOContact implements IDAOContact{
	private static DAOContact daoContact=null;
    public static DAOContact getDAOContact(){
       if(daoContact==null)daoContact=new DAOContact();
       return daoContact;
    }
	  @Override
	public void create(Contact c) 
	{
		Session session=hibutil.getSessionFactory().getCurrentSession();
		Transaction txTransaction = null;
		try {
			txTransaction=session.beginTransaction();
			session.save(c);
	        txTransaction.commit();
			session.close();
		} catch (HibernateException e) {
			txTransaction.rollback();
		    System.err.println(e);
		}
		
	} 
	  @Override
	public List<Contact> retrieve() 
	{
	     SessionFactory sessionFactory= hibutil.getSessionFactory();
	        Session session= sessionFactory.getCurrentSession();
	        session.beginTransaction();
	        try { 
			List<Contact> contacts= (List<Contact>) session.createQuery("from Contact").list();
	           session.close();
	           return contacts;
	        } catch (HibernateException e) {
	            System.err.println(e);
	          return null;
	        }
	} 
	  @Override
	public boolean update(Contact c)
	{
	    SessionFactory sessionFactory= hibutil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        try
        {
            session.update(c);
            tx.commit();
            return true;
        }catch (HibernateException e){
            tx.rollback();
            System.err.println(e);
            return false;
        }
	}
	/*  public boolean update_id(int id)
	  {
		  return update(RetreveById(id));
	  }*/
	  @Override
	public boolean delete(Contact c) 
	{
		
		  SessionFactory sessionFactory= hibutil.getSessionFactory();
	        Session session= sessionFactory.getCurrentSession();
	        Transaction tx=session.beginTransaction();
	        try {
	            session.delete(c);
	            tx.commit();
	            return true;
	        }catch (HibernateException e){
	            System.err.println(e);
	            return false;
	        } 
		
	}
	public boolean delete(int id) {
		return delete(RetreveById(id));
	}
	public Contact RetreveById(int id)
	{
		 SessionFactory sessionFactory= hibutil.getSessionFactory();
	     Session session= sessionFactory.getCurrentSession();
	     Transaction tx=session.beginTransaction();
	     try {
	            Contact contact= (Contact) session.get(Contact.class,id);
	            tx.commit();
	            return contact;
	        }catch (HibernateException e){
	            System.err.println(e);
	            return null;
	        }
	}
}
