package com.Music.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.Music.Dto.MemberDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	@Select("SELECT * FROM USER_TABLE") 
	List <MemberDto> selectList();
	
	@Select("SELECT * FROM USER_TABLE WHERE NAME= #{name}")
	MemberDto selectOne(int myno);
	
	@Insert("INSERT INTO USER_TABLE VALUES(#{name},#{age},#{addr})")
	int insert(MemberDto dto);

}
