package com.Music.Service;

import java.util.List;

import com.Music.Dto.chat_room_Dto;
import com.Music.Dto.chat_room_in_Dto;

public interface chat_room_Service {
	//service chat_room
	public List<chat_room_Dto> select_CRList();
	public int Insert(chat_room_Dto dto);
	public String select_CR(String chat_room_No);
	
	public List<chat_room_in_Dto> select_chatList();
	public int Insertchat_in(chat_room_in_Dto dto);
}
