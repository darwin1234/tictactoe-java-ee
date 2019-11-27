package com.tictactoe.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAccount
 */
public class LoginAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
		HttpSession session = request.getSession();
		session.setAttribute("loginSession", "3A7ED602876ACF5BBD5E7169B928267C3045B103790847736F63E8610524B27A72916B0BD8D813B618DF5005FFEFE9B27A4B0E7A7C7FC9B93F237447C01C90AF");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter(); 
		
		Database db = new Database();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			if(db.validate(username, password) == true) {
				out.println("successfull-" + username +"-" + password);
				HttpSession session = request.getSession();
				session.setAttribute("username", db.getPlayername());
				session.setAttribute("seleted_cell", db.getUsercell());
				session.setAttribute("PlayerID", db.getplayerid());
			}else {
				out.println("Failed to login!");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
