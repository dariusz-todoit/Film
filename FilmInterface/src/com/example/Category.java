package com.example;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class Category implements Serializable {
  
  private static final long serialVersionUID = 2L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ID", nullable=false)
  public int id;
  @Column(name="NAME", nullable=false)
  public String name;
  
  @ManyToMany(mappedBy="categories", fetch = FetchType.EAGER)
  protected List<Note> notes;
  
  public Category () {};
  
  public Category (int id, String name) {
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