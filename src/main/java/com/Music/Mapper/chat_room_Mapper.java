package com.Music.Mapper;


import java.util.List;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.Music.Dto.chat_room_Dto;

@Mapper
public interface chat_room_Mapper {
	//sql and mapping
	@Select("SELECT * FROM CHAT_ROOM") 
	List <chat_room_Dto> select_CRList();
	
	@Insert("insert into CHAT_ROOM values(NULL, #{artist_Name}, #{r_Contents})")
	public int insert(chat_room_Dto dto);

}
