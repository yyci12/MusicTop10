package com.Music.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Music.Crawling.Crawling;
import com.Music.Dto.MemberDto;
import com.Music.Dto.chat_room_Dto;
import com.Music.Service.MemberService;
import com.Music.Service.chat_room_Service;


@Controller
@RequestMapping("/")
public class LoginController {
	
	
	@Autowired 
	private MemberService service;
	
	//autowired chat service
	@Autowired
	private chat_room_Service cR_service;
	
	@GetMapping("/")
	public String root(Model model) {
		System.out.println("log: ");
		Crawling list = new Crawling();
		try {
			System.out.println("log: "+list.Crawling());
			model.addAttribute("list",list.Crawling());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@GetMapping("/inputform")
	public String inputform() {
		return "inputform";
	}
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	//go chat page
	@GetMapping("/chat")
	public String chatpage(Model model) {
		List<chat_room_Dto> list = cR_service.select_CRList();
		model.addAttribute("list_1",list);
		return "chat";
	}
	//go chat_room_open page
	@GetMapping("/chat_room_open")
	public String chatopen() {
		
		return "chat_room_open";
	}
	//chat room make form get
	@GetMapping("chat_room_make")
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
