package com.Music.Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Music.Dto.chat_room_Dto;
import com.Music.Dto.chat_room_in_Dto;

public interface chat_room_Service {
	//service chat_room
	public List<chat_room_Dto> select_CRList();
	public int Insert(chat_room_Dto dto);
	public List <chat_room_Dto> select_CR(@Param("croom_no") String croom_no);
	
	public List<chat_room_in_Dto> select_chatList();
	public int Insertchat_in(chat_room_in_Dto dto);
}
