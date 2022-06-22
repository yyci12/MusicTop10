package com.Music.Dto;

public class MusicDto {
	private	String rank;
	private String Title;
	private String Artist;
	private String Album;
	private String Detail;
	private String Img;
	
	
	public MusicDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MusicDto(String rank, String title, String artist, String album, String detail, String img) {
		super();
		this.rank = rank;
		Title = title;
		Artist = artist;
		Album = album;
		Detail = detail;
		Img = img;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
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

	public String getDetail() {
		return Detail;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}


}
