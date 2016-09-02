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
 * Servlet implementation class addBeer
 */
@WebServlet("/addBeer")
public class addBeer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBeer() {
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
		
		Beer addBeer = new Beer();
		
		addBeer.setBeerName(request.getParameter("name"));
		addBeer.setCountryOfOrigin(request.getParameter("country_of_origin"));
		addBeer.setStyle(request.getParameter("style"));
		addBeer.setAbv(Double.parseDouble(request.getParameter("abv")));
		
		DAOBeer.writeToDB(addBeer);
		
		request.getRequestDispatcher("read.jsp").forward(request, response);
		
	} //doPost

}  //class
