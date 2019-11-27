package com.tictactoe.test;

public class RoomFields {
	
	private String RoomName;
	private int roomid;
	public RoomFields(String r__name, int room_id) {
		this.RoomName = r__name;
		this.roomid = room_id;
	}
	
	public String getRoomName() {
		return RoomName;
	}
	
	public int getroomID() {
		return roomid;
	}
}
