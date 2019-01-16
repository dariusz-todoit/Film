package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;

@Entity
@Table(name="USERS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="USER_TYPE", discriminatorType=DiscriminatorType.STRING, length=1)
public abstract class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ID", nullable=false) 
  public int id;
	
	@Column(name="USER_TYPE")
	public String userType;
	
	@Column(name="LOGIN")
	public String login;
	
}
