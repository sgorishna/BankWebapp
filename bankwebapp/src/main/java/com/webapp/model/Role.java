package com.webapp.model;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idRole;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

}
