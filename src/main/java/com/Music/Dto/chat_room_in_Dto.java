package com.Music.Dto;

public class chat_room_in_Dto {
	
	private int message_No;
	private int cRoom_No;
	private String user_Id;
	private String m_Contents;
	private String m_Time;
	
	public chat_room_in_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chat_room_in_Dto(int message_No, int cRoom_No, String user_Id, String m_Contents, String m_Time) {
		super();
		this.message_No = message_No;
		this.cRoom_No = cRoom_No;
		this.user_Id = user_Id;
		this.m_Contents = m_Contents;
		this.m_Time = m_Time;
	}
	
	
	public int getMessage_No() {
		return message_No;
	}
	public void setMessage_No(int message_No) {
		this.message_No = message_No;
	}
	public int getcRoom_No() {
		return cRoom_No;
	}
	public void setcRoom_No(int cRoom_No) {
		this.cRoom_No = cRoom_No;
	}
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getM_Contents() {
		return m_Contents;
	}
	public void setM_Contents(String m_Contents) {
		this.m_Contents = m_Contents;
	}
	public String getM_Time() {
		return m_Time;
	}
	public void setM_Time(String m_Time) {
		this.m_Time = m_Time;
	}
	
	
}
