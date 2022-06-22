package com.Music.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.Music.Dto.MemberDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	@Select("SELECT * FROM USER_TABLE WHERE USER_EM = #{user_Em} AND USER_PW = #{user_Pw}")
	List <MemberDto> selectList(MemberDto dto);
	
	@Insert("INSERT INTO USER_TABLE VALUES(null, #{user_Id},#{user_Pw},#{user_Em})")
	int insert_Member(MemberDto dto);
	
	@Delete("Delete FROM USER_TABLE WHERE USER_ID = #{user_Id}")
	int Delete_Member(MemberDto dto);
	

}
