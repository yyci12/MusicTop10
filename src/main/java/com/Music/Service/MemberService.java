package com.Music.Service;

import java.util.List;

import com.Music.Dto.MemberDto;

public interface MemberService {
	
	public List<MemberDto> selectList();
	
	public int insert_Member(MemberDto dto);
}
