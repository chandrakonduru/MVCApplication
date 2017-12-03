package com.javawebtutor.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Doctor_Login")
public class DoctorUser implements Serializable {
    
    
   private String name;
    private String userId;
    private String password;

    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public DoctorUser() {
    }

    
    public DoctorUser(String name, String userId, String password){
        this.name=name;
        this.userId = userId;
        this.password = password;
    }


   @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }        
}
