
package com.javawebtutor.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin_Login")
public class User implements Serializable {
    
    
   
    private String userId;
    private String password;

    public User() {
    }

    
    public User(String userId, String password){
        
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
