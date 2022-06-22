package com.Music.Dto;

public class MemberDto {
	
	private int user_No;
	private String user_Id;
	private String user_Pw;
	private String user_Em;
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDto(int user_No,String user_Id,String user_Pw,String user_Em) {
		super();
		this.user_No = user_No;
		this.user_Id = user_Id;
		this.user_Pw = user_Pw;
		this.user_Em = user_Em;
	}
	public int getUser_No() {
		return user_No;
	}
	public void setUser_No(int user_No) {
		this.user_No = user_No;
	}
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Pw() {
		return user_Pw;
	}
	public void setUser_Pw(String user_Pw) {
		this.user_Pw = user_Pw;
	}
	public String getUser_Em() {
		return user_Em;
	}
	public void setUser_Em(String user_Em) {
		this.user_Em = user_Em;
	}
	
	
	
}
