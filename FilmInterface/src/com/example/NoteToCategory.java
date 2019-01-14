package com.example;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NoteToCategory")
public class NoteToCategory implements Serializable {
	
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ID", nullable=false)
  private int id;

	@Column(name="NOTEID")
  private int noteID;
  
  @Column(name="CATEGORYID")
  private int categoryID;
  
  public NoteToCategory () {}
  
  public NoteToCategory (int noteID, int categoryID) {
    this.noteID = noteID;
    this.categoryID = categoryID;
  }
}
