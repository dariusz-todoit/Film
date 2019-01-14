package com.example;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
// import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="NOTES")
public class Note implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="NOTEID", nullable=false) 
  public int noteId;
  @Column(name="NOTE", nullable=true)
  public String note;
  @Column(name="PROJECT_ID", nullable=false)
  private int projectID;
  
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name="NoteToCategory",
    joinColumns=@JoinColumn(name="NOTEID", referencedColumnName="NOTEID"),
    inverseJoinColumns=@JoinColumn(name="CATEGORYID", referencedColumnName="ID"))
  public List<Category> categories;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="PROJECT_ID", referencedColumnName="ID", insertable=false, updatable=false)
  public Project project;
  
  

  public Note(){};
  
  public Note (int noteId, String note, int projectID) {
    this.noteId = noteId;
    this.note = note;
    this.projectID = projectID;    
  }

  public void setNote (String note) {
    this.note = note;
  }
  
  public void setProjectID (int projectID) {
    this.projectID = projectID;
  }
  
  public String getNote () {
    return note;
  }
  
  public int getNoteID () {
    return noteId;
  }
  
  public int getProjectID () {
    return projectID;
  }
  
}