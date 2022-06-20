package com.Music.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Music.Dto.MemberDto;
import com.Music.Service.MemberService;


@Controller
@RequestMapping("/mylogin")
public class LoginController {
	
	@Autowired 
	private MemberService service;
	
	@GetMapping("/inputform")
	public String inputform() {
		
		return "inputform";
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
