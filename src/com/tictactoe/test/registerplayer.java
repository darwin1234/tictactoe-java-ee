package com.tictactoe.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter; 

/**
 * Servlet implementation class registerplayer
 */
public class registerplayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerplayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		
		
		HttpSession session = request.getSession();
		String Test1 = (String) session.getAttribute("loginSession");
		
		out.println(Test1);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter out = response.getWriter(); 
		Database db = new Database();
		
		String username 	= request.getParameter("username");
		String password 	= request.getParameter("password");
		String firstname 	= request.getParameter("firstname");
		String lastname		= request.getParameter("lastname");
		
		db.createuser(username, password, firstname, lastname);
		out.println(username);
		
	}

}
