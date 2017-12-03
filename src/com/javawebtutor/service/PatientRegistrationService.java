package com.javawebtutor.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javawebtutor.hibernate.util.HibernateUtil;
import com.javawebtutor.model.Admin;
import com.javawebtutor.model.AdminUser;
import com.javawebtutor.model.User;
import com.javawebtutor.model.DoctorUser;
public class PatientRegistrationService {
	
public boolean register(Admin user){
	 Session session = HibernateUtil.openSession();
	 
	
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

public boolean isUserExists(Admin user){
	 Session session = HibernateUtil.openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Admin where userId='"+user.getId()+"'");
		 Admin u = (Admin)query.uniqueResult();
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
public List<Admin> getListOfUsers(){
    List<Admin> list = new ArrayList<Admin>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;        
    try {
        tx = session.getTransaction();
        tx.begin();
        list = session.createQuery("from Admin").list();                        
        tx.commit();
    } catch (Exception e) {
        if (tx != null) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
    return list;
}
	 
	
}


