package com.tictactoe.test;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubmitCell
 */
public class SubmitCell extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitCell() {
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
		HttpSession session = request.getSession();
		Map<String, String[]> check = request.getParameterMap();
		
		int roomid = (int) session.getAttribute("roomid"); 
		
		if(!check.isEmpty()) {
			
			//String cell_selected = request.getParameter("cell_selected");
			int row =  Integer.parseInt(request.getParameter("row"));
			int position = Integer.parseInt(request.getParameter("position"));
			//db.updateCell(cell_selected,row,position,roomid);
			String selectedcellSession  = (String) session.getAttribute("seleted_cell");
			int playerid = (int)session.getAttribute("PlayerID");
			db.updateCell(selectedcellSession ,row,position,roomid,playerid);

		}
		
		//int counter ++;
		//session.setAttribute("counter", counter );
		//if(roomid == room_id) {
			
		//}
	}

}
