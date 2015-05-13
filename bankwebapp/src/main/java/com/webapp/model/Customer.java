package com.webapp.model;

import java.sql.Timestamp;

public class Customer {

	private long idCustomer;
	private String name;
	private String gender;
	private Timestamp created;
	private Timestamp updated;
	public long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

}
