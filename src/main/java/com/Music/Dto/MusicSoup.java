package com.Music.Dto;

public class MusicSoup {
	private	int rank;
	private String name;
	private String Artist;
	private String Album;
	private String Detail_url;
	private String Img_Url;
	
	public MusicSoup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MusicSoup(int rank, String name, String artist, String album, String detail_url, String img_Url) {
		super();
		this.rank = rank;
		this.name = name;
		Artist = artist;
		Album = album;
		Detail_url = detail_url;
		Img_Url = img_Url;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String artist) {
		Artist = artist;
	}
	public String getAlbum() {
		return Album;
	}
	public void setAlbum(String album) {
		Album = album;
	}
	public String getDetail_url() {
		return Detail_url;
	}
	public void setDetail_url(String detail_url) {
		Detail_url = detail_url;
	}
	public String getImg_Url() {
		return Img_Url;
	}
	public void setImg_Url(String img_Url) {
		Img_Url = img_Url;
	}
	
}
