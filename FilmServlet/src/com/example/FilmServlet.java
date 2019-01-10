package com.example;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FilmServlet")
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @EJB
  FilmInterface hw;  
	
  public FilmServlet() {
    super();
  }

	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String result = "Servlet asks EJB and gets response: ";

    int newNoteId = hw.newNote("nowa notatka z serwletu", 1);
    result = result + "\n " + newNoteId;
    
    for (Object[] row : hw.getNotes()) {
      result = result + "\n " + (Integer) row[0] + " " + (String) row[1] + " " + (Integer) row[2] + " " + (String) row[3];
    }
    
    hw.updateNote(newNoteId, "update from the bean");
    
    for (Object[] row : hw.getNotes()) {
      result = result + "\n " + (Integer) row[0] + " " + (String) row[1] + " " + (Integer) row[2] + " " + (String) row[3];
    }
    
    for (Object[] row : hw.getNoteToCategory()) {
      result = result + "\n " + (Integer) row[0] + " " + (String) row[1] + " " + (Integer) row[2] + " " + (String) row[3];
    }
    
    hw.addNoteToCategory (60, 1);
    
    for (Object[] row : hw.getNoteToCategory()) {
      result = result + "\n " + (Integer) row[0] + " " + (String) row[1] + " " + (Integer) row[2] + " " + (String) row[3];
    }
    
    hw.removeNoteToCategory (60, 1);
    
    for (Object[] row : hw.getNoteToCategory()) {
      result = result + "\n " + (Integer) row[0] + " " + (String) row[1] + " " + (Integer) row[2] + " " + (String) row[3];
    }
    
    response.getWriter().append(result);
	}

}
