package com.javawebtutor.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
@Entity
@Table(name="Admin")
public class Admin implements java.io.Serializable {
	 @Id @GeneratedValue
	    private Long id;
	    private String P_name;
	    private int P_age;
	    private int P_weight;
	    private String P_height;
	    private String Tablets;
	    private String P_disease;
	   
	   
	    
		
		private String D_name;
	    private String D_spec;
	    private float D_fees;
		public Admin( String p_name, int p_age, int p_weight,
				String p_height, String tablets, String p_disease,
				  String d_name, String d_spec,
				float d_fees) {
			super();
			P_name = p_name;
			P_age = p_age;
			P_weight = p_weight;
			P_height = p_height;
			Tablets = tablets;
			P_disease = p_disease;
			
			
			D_name = d_name;
			D_spec = d_spec;
			D_fees = d_fees;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getP_name() {
			return P_name;
		}
		public void setP_name(String p_name) {
			P_name = p_name;
		}
		public int getP_age() {
			return P_age;
		}
		public void setP_age(int p_age) {
			P_age = p_age;
		}
		public int getP_weight() {
			return P_weight;
		}
		public void setP_weight(int p_weight) {
			P_weight = p_weight;
		}
		public String getP_height() {
			return P_height;
		}
		public void setP_height(String p_height) {
			P_height = p_height;
		}
		public String getTablets() {
			return Tablets;
		}
		public void setTablets(String tablets) {
			Tablets = tablets;
		}
		public String getP_disease() {
			return P_disease;
		}
		public void setP_disease(String p_disease) {
			P_disease = p_disease;
		}
		
		public String getD_name() {
			return D_name;
		}
		public void setD_name(String d_name) {
			D_name = d_name;
		}
		public String getD_spec() {
			return D_spec;
		}
		public void setD_spec(String d_spec) {
			D_spec = d_spec;
		}
		public float getD_fees() {
			return D_fees;
		}
		public void setD_fees(float d_fees) {
			D_fees = d_fees;
		}
		
		public Admin(){
			
		}

}
