package com.Music.Mapper;


import java.util.List;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.Music.Controller.LoginController;
import com.Music.Dto.chat_room_Dto;
import com.Music.Dto.chat_room_in_Dto;

@Mapper
public interface chat_room_Mapper {
	//sql and mapping
	@Select("SELECT * FROM CHAT_ROOM") 
	List <chat_room_Dto> select_CRList();
	
	@Insert("insert into CHAT_ROOM values(NULL, #{artist_Name}, #{r_Contents})")
	public int Insert(chat_room_Dto dto);
	
	@Select("SELECT * FROM CHAT_ROOM WHERE CROOM_NO = #{croom_no}")
	List <chat_room_Dto> select_CR(@Param("croom_no") String croom_no);

	
	
	//CHAT_ROOM_MESSAGE mapping
	@Select("SELECT * FROM CHAT_ROOM_MESSAGE WHERE CROOM_NO = ")
	List <chat_room_in_Dto> select_chatList();
	
	
	
	public String R_N = LoginController.chat_room_No;
	@Insert("insert into CHAT_ROOM_MESSAGE values(NULL, #R_N# , #{r_Contents})")
	public int Insertchat_in(chat_room_in_Dto dto);
	
}
