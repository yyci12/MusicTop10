package com.Music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Music.Dto.chat_room_Dto;
import com.Music.Mapper.chat_room_Mapper;

@Service
public class chat_room_ServiceImpl implements chat_room_Service{

	@Autowired
	private chat_room_Mapper chat_room_mapper ;
	
	@Override
	public List<chat_room_Dto> select_CRList() {
		// TODO Auto-generated method stub
		return chat_room_mapper.select_CRList();
	}

}
