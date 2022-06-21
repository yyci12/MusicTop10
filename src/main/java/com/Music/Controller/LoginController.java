package com.Music.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Music.Dto.MemberDto;
import com.Music.Dto.chat_room_Dto;
import com.Music.Service.MemberService;
import com.Music.Service.chat_room_Service;


@Controller
@RequestMapping("/")
public class LoginController {
	
	
	@Autowired 
	private MemberService service;
	
	@Autowired
	private chat_room_Service cR_service;
	
	@GetMapping("/inputform")
	public String inputform() {
		return "inputform";
	}
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	@GetMapping("/chat")
	public String chatpage(Model model) {
		List<chat_room_Dto> list = cR_service.select_CRList();
		model.addAttribute("list_1",list);
		return "chat";
	}
	@GetMapping("/chat_room_open")
	public String chatopen() {
		
		return "chat_room_open";
	}
	@GetMapping("/chat_room_make")
	public String chatR_insert(chat_room_Dto dto) {
		int res = 0;
		res = cR_service.Insert(dto);
		
		if(res>0) {
			return "redirect:chat";
		}
		else {
			return "redirect:chat";
		}
	}
	
	@GetMapping("/input")
	public String input(Model model,MemberDto dto) {
		int res =0;
		res =service.insert(dto);
		
		if(res>0) {
			model.addAttribute("dto",service.selectList());
			return "output";
		}else {
			return "input";
		}
	}
	
}
