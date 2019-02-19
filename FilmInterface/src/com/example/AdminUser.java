package com.example;


import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue(value="A")
public class AdminUser extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="PERMISSION_LEVEL")
	public int permissionLevel;
	
	public AdminUser () {};
	
	public AdminUser (String login, int permissionLevel) {
		this.login = login;
		this.permissionLevel = permissionLevel;
	}
}
