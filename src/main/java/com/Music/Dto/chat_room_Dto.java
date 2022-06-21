package com.Music.Dto;

public class chat_room_Dto {
	private int cRoom_No;
	private String artist_Name;
	private String r_Contents;
	

	public chat_room_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chat_room_Dto(int cRoom_No, String artist_Name, String r_Contents) {
		super();
		this.cRoom_No = cRoom_No;
		this.artist_Name = artist_Name;
		this.r_Contents = r_Contents;
	}

	public int getcRoom_No() {
		return cRoom_No;
	}
	public void setcRoom_No(int cRoom_No) {
		this.cRoom_No = cRoom_No;
	}


	public String getArtist_Name() {
		return artist_Name;
	}
	public void setArtist_Name(String artist_Name) {
		this.artist_Name = artist_Name;
	}


	public String getR_Contents() {
		return r_Contents;
	}
	public void setR_Contents(String r_Contents) {
		this.r_Contents = r_Contents;
	}
	
	
}
