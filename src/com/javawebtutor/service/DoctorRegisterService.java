package com.javawebtutor.service;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javawebtutor.hibernate.util.HibernateUtil;
import com.javawebtutor.model.User;
import com.javawebtutor.model.DoctorUser;
public class DoctorRegisterService {
	
public boolean register(DoctorUser user){
	 Session session = HibernateUtil.openSession();
	 if(isUserExists(user)) 
		 return false;	
	
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 session.saveOrUpdate(user);		
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 session.close();
	 }	
	 return true;
}

public boolean isUserExists(DoctorUser user){
	 Session session = HibernateUtil.openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from DoctorUser where userId='"+user.getUserId()+"'");
		DoctorUser u = (DoctorUser)query.uniqueResult();
		 tx.commit();
		 if(u!=null) result = true;
	 }catch(Exception ex){
		ex.printStackTrace();
		 }
	 finally{
		 session.close();
	 }
	 return result;
}
}
