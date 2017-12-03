package com.javawebtutor.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javawebtutor.hibernate.util.HibernateUtil;
import com.javawebtutor.model.AdminUser;
import com.javawebtutor.model.User;

public class AdminLoginService {
	 public boolean authenticateUser(String userId, String password) {
	       AdminUser user = getUserByUserId(userId);          
	        if(user!=null && user.getUserId().equals(userId) && user.getPassword().equals(password)){
	            return true;
	        }else{ 
	            return false;
	        }
	    }

	    public AdminUser getUserByUserId(String userId) {
	        Session session = HibernateUtil.openSession();
	        Transaction tx = null;
	        AdminUser user = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from AdminUser where userId='"+userId+"'");
	            user = (AdminUser)query.uniqueResult();
	            tx.commit();
	        } catch (Exception e) {
	            
	           e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return user;
	    }
	    
	  
	   
	    }
	

