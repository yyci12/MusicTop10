package com.Music.Service;

import java.util.List;

import com.Music.Dto.chat_room_Dto;

public interface chat_room_Service {
	//service chat_room
	public List<chat_room_Dto> select_CRList();
	public int Insert(chat_room_Dto dto);
}
