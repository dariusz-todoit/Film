package com.example;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue(value="O")
public class OrdinaryUser extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="MAXIMUM_NUMBER_OF_NOTES")
	public int maxNumOfNotes;
	
  public OrdinaryUser () {};
	
	public OrdinaryUser (String login, int maxNumOfNotes) {
		this.login = login;
		this.maxNumOfNotes = maxNumOfNotes;
	}
}
