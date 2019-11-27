package com.tictactoe.test;

public class Playerfields {
	private String playername;
	private int win;
	private int lost;
	private int draw;
	
	public Playerfields(String __playername, int __win, int __lost, int __draw) {
		this.playername = __playername;
		this.win =  __win;
		this.lost = __lost;
		this.draw = __draw;
	}
	
	public String getPlayername() {
		return playername;
	}
	
	public int getwin() {
		return win;
	}
	public int getlost() {
		return lost;
	}
	
	public int getdraw() {
		return draw;
	}
}
