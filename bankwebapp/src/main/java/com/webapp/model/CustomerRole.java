package com.webapp.model;

import java.io.Serializable;

public class CustomerRole implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idCustomerRole;
	private Long idCustomer;
	private Long idRole;

	public Long getIdCustomerRole() {
		return idCustomerRole;
	}

	public void setIdCustomerRole(Long idCustomerRole) {
		this.idCustomerRole = idCustomerRole;
	}

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

}
