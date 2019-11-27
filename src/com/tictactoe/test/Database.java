package com.tictactoe.test;

import java.sql.*;
import java.util.ArrayList;

public class Database {
	
	private static int playerID = 0;
	private static String playername = "";
	private static String userCell = "";
    public boolean validate(String username, String password) throws ClassNotFoundException{
    	boolean resp = false;
    	ResultSet rs;
    	try 
    	{	
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoegame?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true", "root", ""); 
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users where username = ? AND password = ?");
    		preparedStatement.setString(1, username);
    		preparedStatement.setString(2, password);
    		rs = preparedStatement.executeQuery();
    		
    		
    		if(rs.next()) {
    			
    			this.playername = rs.getString("playername");
    			this.userCell = rs.getString("cell");
    			this.playerID = rs.getInt("id");
    			resp = true;
    		}
    		
    	}catch(Exception e) {
  	  		System.out.println(e.getMessage());
  	  	}
    	
    	return resp;
    }
    
    public static void createuser(String username, String password, String firstname, String lastname) {
    
    	try 
    	{	
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoegame?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true", "root", ""); 
    		PreparedStatement preparedStatement = connection.prepareStatement("insert into users(username, password, firstname,lastname,playername,win,lost,draw,cell) values(? , ? , ? , ?, ?, ?, ?, ?,?)");
    		preparedStatement.setString(1, username);
    		preparedStatement.setString(2, password);
    		preparedStatement.setString(3, firstname);
    		preparedStatement.setString(4, lastname);
    		preparedStatement.setString(5, username);
    		preparedStatement.setInt(6, 0);
    		preparedStatement.setInt(7, 0);
    		preparedStatement.setInt(8, 0);
    		preparedStatement.setString(9, "X");
    		preparedStatement.execute();
    	
    	}catch(Exception e) {
  	  		System.out.println(e.getMessage());
  	  	}
    	
    }

    public static ArrayList<Board> bdlist(int rmid){
    	
    	
    	
    	ArrayList<Board> rows = new ArrayList<>();
    	Board board;
    	
    	Connection con = null;
    	try {
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoegame?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true", "root", ""); 
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM board WHERE id = ?");
    		preparedStatement.setInt(1, rmid);
    		ResultSet resultSet = preparedStatement.executeQuery();
  		  
  		  	while(resultSet.next())
  		  	{
  		  		
  		  		board = new Board(resultSet.getString("val1"),resultSet.getString("val2"),resultSet.getString("val3"),resultSet.getString("val4"), resultSet.getString("val5"), resultSet.getString("val6"),resultSet.getString("val7"), resultSet.getString("val8"), resultSet.getString("val9"),resultSet.getLong("id"), resultSet.getString("oponent"), resultSet.getString("creator"), resultSet.getInt("playerid_1"), resultSet.getInt("playerid_2"), resultSet.getString("cell1"), resultSet.getString("cell2"), resultSet.getString("winner"));
  		  		rows.add(board);
  			}
  		  
  		  
  	  	}catch(Exception e) {
  	  		System.out.println(e.getMessage());
  	  	}
  	
  	
  
    

		return rows;
       
    }
    
    public void updateCell(String cell,int row, int position,int roomid) {
    	
    	Connection con = null;
    	
    	try 
    	{
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoegame?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true", "root", ""); 
    		
    		PreparedStatement preparedStatement = null;
    		//Row 1
			
    		if(row == 1) 
    		{    			
    			if(position == 0) {
    				preparedStatement = connection.prepareStatement("UPDATE board SET val1 = ? WHERE id=?");
        			preparedStatement.setString(1, cell);
        			preparedStatement.setInt(2, roomid);
        			
    			}
    			if(position == 1) { 
    				preparedStatement = connection.prepareStatement("UPDATE board SET val2 = ? WHERE id=?");
    				preparedStatement.setString(1, cell);
    				preparedStatement.setInt(2, roomid);
    			}
   			   if(position == 2) { 
    				preparedStatement = connection.prepareStatement("UPDATE board SET val3 = ? WHERE id=?");
    				preparedStatement.setString(1, cell);
    				preparedStatement.setInt(2, roomid);
   			   }
    		}
    		
    		
    		
    		//Row 2
			
    		if(row == 2) 
    		{    			
    			if(position == 0) {
    				preparedStatement = connection.prepareStatement("UPDATE board SET val4 = ? WHERE id=?");
        			preparedStatement.setString(1, cell);
        			preparedStatement.setInt(2, roomid);
    			}
    			if(position == 1) { 
    				preparedStatement = connection.prepareStatement("UPDATE board SET val5 = ? WHERE id=?");
    				preparedStatement.setString(1, cell);
    				preparedStatement.setInt(2, roomid);
    			}
   			   if(position == 2) { 
    				preparedStatement = connection.prepareStatement("UPDATE board SET val6 = ? WHERE id=?");
    				preparedStatement.setString(1, cell);
    				preparedStatement.setInt(2, roomid);
    			}
    		}
    		
    		
    		
    		//Row 3
			
    		if(row == 3) 
    		{    			
    			if(position == 0) {
    				preparedStatement = connection.prepareStatement("UPDATE board SET val7 = ? WHERE id=?");
        			preparedStatement.setString(1, cell);
        			preparedStatement.setInt(2, roomid);
    			}
    			if(position == 1) { 
    				preparedStatement = connection.prepareStatement("UPDATE board SET val8 = ? WHERE id=?");
    				preparedStatement.setString(1, cell);
    				preparedStatement.setInt(2, roomid);
    			}
   			   if(position == 2) { 
    				preparedStatement = connection.prepareStatement("UPDATE board SET val9 = ? WHERE id=?");
    				preparedStatement.setString(1, cell);
    				preparedStatement.setInt(2, roomid);
    			}
    		}
    		
    		
    		
    		preparedStatement.executeUpdate();
    		
    		
    		
    		
  		  
  	  	}catch(Exception e) {
  	  		System.out.println(e.getMessage());
  	  	}
    
    }
    
    public static ArrayList<RoomFields> rooms() {
    	ResultSet rs = null;
    	ArrayList<RoomFields> rows = new ArrayList<>();
    	RoomFields row;
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoegame?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true", "root", ""); 
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM board");
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
			row = new RoomFields(rs.getString("gamename"), rs.getInt("id"));
			rows.add(row);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
    	
    }
    
    public static ArrayList<Playerfields> player(){
    	ArrayList<Playerfields> pyr = new ArrayList<>();
    	ResultSet rs = null;
    	Playerfields row;
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoegame?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true", "root", ""); 
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT playername, MAX(win) as win, lost, draw FROM users");
			
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
			row = new Playerfields(rs.getString("playername"), rs.getInt("win"), rs.getInt("lost"), rs.getInt("draw"));
			pyr.add(row);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	return pyr;
    }
    
    public static void createRoom(String roomname,String creatorname, int playerid_1, String cell1) {
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoegame?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true", "root", ""); 
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO board(val1,val2,val3,val4,val5,val6,val7,val8,val9,gamename,creator,oponent,winner,playerid_1, playerid_2, cell1, cell2)  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, "-");
			preparedStatement.setString(2, "-");
			preparedStatement.setString(3, "-");
			preparedStatement.setString(4, "-");
			preparedStatement.setString(5, "-");
			preparedStatement.setString(6, "-");
			preparedStatement.setString(7, "-");
			preparedStatement.setString(8, "-");
			preparedStatement.setString(9, "-");
			preparedStatement.setString(10, roomname);
			preparedStatement.setString(11, creatorname);
			preparedStatement.setString(12,"-");
			preparedStatement.setString(13,"Not Yet Started!");
			preparedStatement.setInt(14, playerid_1);
			preparedStatement.setInt(15, 0);
			preparedStatement.setString(16, cell1);
			preparedStatement.setString(17, "-");
			preparedStatement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    }
    public String getPlayername() {
    	
    	return playername;
    }
   
    public int getplayerid() {
    	return playerID;
    }
    
    public void joingame(String Playername, int roomid, int playerid_2, String cell2) {  		
    	try 
    	{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoegame?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true", "root", ""); 
	    		PreparedStatement preparedStatement = null;
	    		preparedStatement = connection.prepareStatement("UPDATE board SET oponent =?, playerid_2 =?, cell2=? WHERE id=?");
	        	preparedStatement.setString(1, Playername);
	        	preparedStatement.setInt(2,playerid_2);
	           	preparedStatement.setString(3,cell2);
	        	preparedStatement.setLong(4, roomid);
	        	preparedStatement.executeUpdate();
	    } catch (ClassNotFoundException e) {
				e.printStackTrace();
	    } catch (SQLException e) {
				e.printStackTrace();
		}
    	
    }
    
    public static String getUsercell() {
    	
    	return userCell;
    }
    
    public String updateforwinner(long boardid, String winner, int playerid) {
    	String __winner = null;
    	try 
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoegame?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true", "root", ""); 
	    	PreparedStatement preparedStatement = null;
	    	preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id=?");
	    	preparedStatement.setInt(1, playerid);
	    	
	    	ResultSet rs = preparedStatement.executeQuery();
	    	//update
	    	preparedStatement =  connection.prepareStatement("UPDATE board SET winner=? WHERE id=?");
	    	while(rs.next()) {
	    		__winner = rs.getString("playername");
	    		preparedStatement.setString(1, __winner);
		    	preparedStatement.setLong(2, boardid);
	    	}
	    	
	    	
	    	preparedStatement.execute();
	    	
	    	
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
    	return __winner;
    }
    
    public static void checkwinner() {
    	
    }

}
