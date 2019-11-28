package com.tictactoe.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Player
 */
public class Player extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Player() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Database db = new Database();
		ArrayList<Playerfields> plyr = db.player();
		PrintWriter out = response.getWriter(); 
		for(Playerfields printRow :  plyr) {
			printRow.getPlayername();
			//out.println(printRow.getPlayername() + " Win: " + printRow.getwin() + " Lost: " + printRow.getlost() +  " Draw: " + printRow.getdraw());
			out.println(printRow.getPlayername() + " Score: " + printRow.getwin());
			
		}
	}

}
