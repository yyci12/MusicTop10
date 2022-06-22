package com.Music.Service;

import java.util.List;

import com.Music.Dto.MemberDto;

public interface MemberService {
	
	public List<MemberDto> selectList(MemberDto dto);
	
	public int insert_Member(MemberDto dto);
	
	public int Delete_Member(MemberDto dto);
}
