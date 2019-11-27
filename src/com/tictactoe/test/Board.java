package com.tictactoe.test;

public class Board {
	
	private final String __value1;
	private final String __value2;
	private final String __value3;
	private final String __value4;
	private final String __value5;
	private final String __value6;
	private final String __value7;
	private final String __value8;
	private final String __value9; 
	private final long __roomid;
	private final String __oponent;
	private final String __creator;
	private final int __playerid_1;
	private final int __playerid_2;
	private final String __cell1;
	private final String __cell2;
	
	public Board(String val1,String val2,String val3,String val4,String val5,String val6,String val7,String val8,String val9, long rmid, String oponent, String creator, int playerid_1, int playerid_2, String cell1, String cell2) {
		
		this.__value1 = val1;
		this.__value2 = val2;
		this.__value3 = val3;
		this.__value4 = val4;
		this.__value5 = val5;
		this.__value6 = val6;
		this.__value7 = val7;
		this.__value8 = val8;
		this.__value9 = val9;
		this.__roomid = rmid;
		this.__oponent = oponent;
		this.__creator = creator;
		this.__playerid_1 = playerid_1;
		this.__playerid_2 =  playerid_2;
		this.__cell1 = cell1;
		this.__cell2 = cell2;
	}
	public String value1() {
		
		return __value1;
	}
	
	public String value2() {
			
		return __value2;
	}
	
	
	public String value3() {
		
		return __value3;
	}
	
	public String value4() {
		
		return __value4;
	}
	
	
	public String value5() {
		
		return __value5;
	}
	
	
	public String value6() {
		
		return __value6;
	}
	
	
	public String value7() {
		
		return __value7;
	}
	
	
	public String value8() {
		
		return __value8;
	}
	
	
	public String value9() {
		
		return __value9;
	}
	
	public long roomID() {
		return __roomid;
	}

	public String getOponent() {
		return __oponent;
	}
	
	public String getCreator() {
		return __creator;
	}
	
	public int getPlayerID1() {
		return __playerid_1;
	}
	
	public int getPlayerID2() {
		return __playerid_1;
	}
	
	public String getCell1() {
		return __cell1;
	}
	
	public String getCell2() {
		return __cell2;
	}
}
