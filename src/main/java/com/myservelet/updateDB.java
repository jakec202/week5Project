package com.myservelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animalsinzoo.Animal;
import com.animalsinzoo.DAO;

/**
 * Servlet implementation class updateDB
 */
@WebServlet("/updateDB")
public class updateDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Animal updateToDb = new Animal();
		
		updateToDb.setAnimalID(Integer.parseInt(request.getParameter("animal_id")));
		updateToDb.setAnimalSpecies(request.getParameter("animal_species"));
		updateToDb.setAnimalName(request.getParameter("animal_name"));
		updateToDb.setAnimalAge(Integer.parseInt(request.getParameter("animal_age")));
		updateToDb.setAnimalWeight(Double.parseDouble(request.getParameter("animal_weight")));
		
		DAO.updateToDatabase(updateToDb);
		
	}

}
