package com.example;

import java.util.List;


public interface FilmInterface {
  void deleteNote (int id);
  void updateNote (int id, String text);
  int newNote (String text, int projectId);
  List<Object[]> getNotes ();
  List<Object[]> getNoteToCategory ();
  void addNoteToCategory (int noteID, int categoryID);
  void removeNoteToCategory (int noteID, int categoryID);
  List<Note> getNoteToCategory2 ();
  List<Note> getNotes2 ();
  int addAdminUser (String login, int permissionLevel);
  List<AdminUser> getAdminUsers ();
  String updateNoteWithDelay1 (int id, String text);
  String updateNoteWithDelay2 (int id, String text);  
}
