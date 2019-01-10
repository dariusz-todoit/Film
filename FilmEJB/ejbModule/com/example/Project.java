package com.example;

import java.io.Serializable;
import java.util.List;
// import java.util.Set;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class Project implements Serializable {
  
  private static final long serialVersionUID = 2L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ID", nullable=false)
  private int id;
  @Column(name="NAME", nullable=false)
  protected String name;
  
  @OneToMany(mappedBy="project", fetch = FetchType.EAGER)
  protected List<Note> notes;
  
  public Project () {};
  
  public Project (int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getID () {
    return id;
  }
  
  public String getName () {
    return name;
  }
  
}