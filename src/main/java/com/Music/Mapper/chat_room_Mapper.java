package com.Music.Mapper;


import java.util.List;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import com.Music.Dto.chat_room_Dto;

@Mapper
public interface chat_room_Mapper {
	@Select("SELECT * FROM CHAT_ROOM") 
	List <chat_room_Dto> select_CRList();
	
	

}
