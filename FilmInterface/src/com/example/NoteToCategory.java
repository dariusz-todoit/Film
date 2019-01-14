package com.example;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="NoteToCategory")
public class NoteToCategory implements Serializable {
	
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ID", nullable=false)
  private int id;

  private Note note;
  
  @JoinColumn(name="NOTEID")
  @ManyToOne(optional=false)
  public Note getNote() {
		return note;
	}
  
  public void setNote(Note value) {
		note = value;
	}
  
	private Category category;
  
	@JoinColumn(name="CATEGORYID")
  @ManyToOne(optional=false)
  public Category getCategory() {
		return category;
	}
  
  public void setCategory(Category value) {
		category = value;
	}
  
  
  public NoteToCategory () {}
  
  public NoteToCategory (Note note, Category category) {
    this.note = note;
    this.category = category;
  }
}
