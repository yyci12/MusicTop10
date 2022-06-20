package com.Music.Service;

import java.util.List;

import com.Music.Dto.MemberDto;

public interface MemberService {
	public List<MemberDto> selectList();
	public MemberDto selectOne(int myno);
	public int insert(MemberDto dto);
}
