package com.Music.Mapper;


import java.util.List;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
	
	
	//chat_room_in mapping
	@Select("SELECT * FROM CHAT_ROOM_IN")
	List <chat_room_in_Dto> select_chatList();
	
	public String R_N = LoginController.chat_room_No;
	static final String sql = "insert into CHAT_ROOM_IN values(NULL,"+ R_N +", #{r_Contents})";
	@Insert(sql)
	public int Insertchat_in(chat_room_in_Dto dto);
	
}
