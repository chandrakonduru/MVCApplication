package com.javawebtutor.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javawebtutor.hibernate.util.HibernateUtil;
import com.javawebtutor.model.DoctorUser;
import com.javawebtutor.model.User;

public class DoctorLoginService {
	 public boolean authenticateUser(String userId, String password) {
	     DoctorUser user = getUserByUserId(userId);          
	        if(user!=null && user.getUserId().equals(userId) && user.getPassword().equals(password)){
	            return true;
	        }else{ 
	            return false;
	        }
	    }

	    public DoctorUser getUserByUserId(String userId) {
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;
	        DoctorUser user = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from DoctorUser where userId='"+userId+"'");
	            user = (DoctorUser)query.uniqueResult();
	            tx.commit();
	        } catch (Exception e) {
	            
	           e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return user;
	    }
	    
	    public List<DoctorUser> getListOfUsers(){
	        List<DoctorUser> list = new ArrayList<DoctorUser>();
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;        
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            list = session.createQuery("from DoctorUser").list();                        
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

