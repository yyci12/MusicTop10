package com.Music.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.Music.Dto.MemberDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	@Select("SELECT * FROM TEST_DB") 
	List <MemberDto> selectList();
	
	@Select("SELECT * FROM TEST_DB WHERE NAME= #{name}")
	MemberDto selectOne(int myno);
	
	@Insert("INSERT INTO TEST_DB VALUES(#{name},#{age},#{addr})")
	int insert(MemberDto dto);

}