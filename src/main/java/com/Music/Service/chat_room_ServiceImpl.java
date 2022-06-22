package com.Music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Music.Dto.chat_room_Dto;
import com.Music.Dto.chat_room_in_Dto;
import com.Music.Mapper.chat_room_Mapper;

@Service
public class chat_room_ServiceImpl implements chat_room_Service{

	//serviceImplements
	@Autowired
	private chat_room_Mapper chat_room_mapper ;
	
	@Override
	public List<chat_room_Dto> select_CRList() {
		// TODO Auto-generated method stub
		return chat_room_mapper.select_CRList();
	}

	@Override
	public int Insert(chat_room_Dto dto) {
		// TODO Auto-generated method stub
		return chat_room_mapper.Insert(dto);
	}
	
	@Override
	public String select_CR(String chat_room_No) {
		// TODO Auto-generated method stub
		return chat_room_mapper.select_CR(chat_room_No);
	}
	
	@Override
	public List<chat_room_in_Dto> select_chatList(){
		// TODO Auto-generated method stub
		return chat_room_mapper.select_chatList();
	}
	@Override
	public int Insertchat_in(chat_room_in_Dto dto) {
		// TODO Auto-generated method stub
		return chat_room_mapper.Insertchat_in(dto);
	}
}
