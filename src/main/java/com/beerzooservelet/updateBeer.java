package com.beerzooservelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beerzoo.Beer;
import com.beerzoo.DAOBeer;

/**
 * Servlet implementation class updateBeer
 */
@WebServlet("/updateBeer")
public class updateBeer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateBeer() {
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
		Beer updateBeer = new Beer();
		
		updateBeer.setBeerID(Integer.parseInt(request.getParameter("beer_id")));
		updateBeer.setBeerName(request.getParameter("name"));
		updateBeer.setCountryOfOrigin(request.getParameter("country_of_origin"));
		updateBeer.setStyle(request.getParameter("style"));
		updateBeer.setAbv(Double.parseDouble(request.getParameter("abv")));
		
		DAOBeer.updateBeerZoo(updateBeer);
		
		
		
	}  //doPost

}  //class
