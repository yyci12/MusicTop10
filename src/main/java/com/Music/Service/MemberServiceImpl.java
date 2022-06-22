package com.Music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Music.Dto.MemberDto;
import com.Music.Mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper mapper ;
	
	@Override
	public List<MemberDto> selectList() {
		// TODO Auto-generated method stub
		return mapper.selectList();
	}

	
	@Override
	public int insert_Member(MemberDto dto) {
		// TODO Auto-generated method stub
		return mapper.insert_Member(dto);
	}

}
