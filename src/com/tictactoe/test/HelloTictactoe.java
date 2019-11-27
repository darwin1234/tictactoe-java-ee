package com.tictactoe.test;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//Servlet Name 
@WebServlet("/InsertData") 
public class HelloTictactoe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     * @throws SQLException 
     */
    public HelloTictactoe()   {
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		HttpSession session = request.getSession();
		session.setAttribute("___cellStatus___", "X");

 	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*************Variables*********************/
		String v1 = null, v2 = null, v3 = null, v4 = null, v5 = null, v6 = null, v7 = null, v8 = null, v9 = null , status = null , player = null, oponent = null , creator = null, winner = null;
		long room_id = 0;
		int playerid_1 = 0 , playerid_2 = 0;
		
		
		PrintWriter out = response.getWriter(); 
		Database db = new Database();
		
		Map<String, String[]> check = request.getParameterMap();
//		
		HttpSession session = request.getSession();
		int roomid = (int) session.getAttribute("roomid"); 

		String username = (String) session.getAttribute("username");
		
		if(!check.isEmpty()) {
			
			String cell_selected = request.getParameter("cell_selected");
			int row =  Integer.parseInt(request.getParameter("row"));
			int position = Integer.parseInt(request.getParameter("position"));
			//db.updateCell(cell_selected,row,position,roomid);
			String selectedcellSession  = (String) session.getAttribute("seleted_cell");
			db.updateCell(selectedcellSession ,row,position,roomid);

		}
		
		
		ArrayList<Board> bd = Database.bdlist(roomid);
		
		int i = 0;
		for (Board __s : bd){	
			i++;
			v1= __s.value1(); 
			v2= __s.value2(); 
			v3= __s.value3();
			v4= __s.value4();
			v5= __s.value5(); 
			v6= __s.value6();
			v7= __s.value7();
			v8= __s.value8();
			v9= __s.value9();
			room_id = __s.roomID();
			oponent = __s.getOponent();
			creator = __s.getCreator();
			playerid_1 = __s.getPlayerID1();
			playerid_2 = __s.getPlayerID2();
		
			
			
		}
		
	
		
		if(v1.equals("O") && v2.equals("O") && v3.equals("O")){
			status = "Winner";
			player = "O";
		    winner = db.updateforwinner(room_id, oponent, playerid_2);
		}
		else if(v1.equals("X") && v2.equals("X") && v3.equals("X")) {
			status = "Winner"; player = "X";
			winner = db.updateforwinner(room_id, creator, playerid_1);
		}
		else if(v4.equals("O") && v5.equals("O") && v6.equals("O")) {
			status = "Winner"; player = "O";
		    winner = db.updateforwinner(room_id, oponent, playerid_2);
		}
		else if(v4.equals("X") && v5.equals("X") && v6.equals("X")) {
			status = "Winner"; player = "X";
			winner = db.updateforwinner(room_id, creator, playerid_1);
		}
		else if(v7.equals("O") && v8.equals("O") && v9.equals("O")) {
			status = "Winner"; player = "O";
			winner = db.updateforwinner(room_id, oponent, playerid_2);
		}
		else if(v7.equals("X") && v8.equals("X") && v9.equals("X")) {
			status = "Winner"; player = "X";
			winner = db.updateforwinner(room_id, creator, playerid_1);
		}
		else if(v1.equals("O") && v4.equals("O") && v7.equals("O")) {
			status = "Winner"; player = "O";
			winner = db.updateforwinner(room_id, oponent, playerid_2);	
		}
		else if(v1.equals("X") && v4.equals("X") && v7.equals("X")) {
			status = "Winner"; player = "X";
			winner = db.updateforwinner(room_id, creator, playerid_1);
		}
		else if(v2.equals("O") && v5.equals("O") && v8.equals("O")) {
			status = "Winner"; player = "O";
			winner = db.updateforwinner(room_id, oponent, playerid_2);
		}
		else if(v2.equals("X") && v5.equals("X") && v8.equals("X")) {
			status = "Winner"; player = "X";
			winner = db.updateforwinner(room_id, creator, playerid_1);
		}
		else if(v3.equals("O") && v6.equals("O") && v9.equals("O")) {
			status = "Winner"; player = "O";
			winner = db.updateforwinner(room_id, oponent, playerid_2);
		}
		else if(v3.equals("X") && v6.equals("X") && v9.equals("X")) {
			status = "Winner"; player = "X";
			winner = db.updateforwinner(room_id, creator, playerid_1);
		}
		else if(v1.equals("O") && v5.equals("O") && v9.equals("O")) {
			status = "Winner"; player = "O";
			winner = db.updateforwinner(room_id, creator, playerid_2);
		}
		else if(v1.equals("X") && v5.equals("X") && v9.equals("X")) {
			status = "Winner"; player = "X";
			winner = db.updateforwinner(room_id, creator, playerid_1);
		}
		else if(v3.equals("O") && v5.equals("O") && v7.equals("O")) {
			status = "Winner"; player = "O";
			winner = db.updateforwinner(room_id, oponent, playerid_2);
		}
		else if(v3.equals("X") && v5.equals("X") && v7.equals("X")) {
			status = "Winner"; player = "X";
			winner = db.updateforwinner(room_id, creator, playerid_1);
		}
		else {}
		
		
		out.println(v1 +"@"+ v2 +"@"+ v3 + "@" + v4 +"@"+ v5 + "@" + v6 + "@"+ v7 +"@"+ v8 +"@"+v9 + "@" + status + "@" + player + "@" + username + "@" + room_id + "@" + oponent + "@" + creator + "@" + "X" + "@" + "O" + "@" + winner);
		
	
	}

	
}
