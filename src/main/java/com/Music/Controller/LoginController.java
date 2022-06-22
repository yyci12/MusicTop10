package com.Music.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Music.Crawling.Crawling;
import com.Music.Dto.MemberDto;
import com.Music.Dto.chat_room_Dto;
import com.Music.Mapper.chat_room_Mapper;
import com.Music.Service.MemberService;
import com.Music.Service.chat_room_Service;

@Controller
@RequestMapping("/")
public class LoginController {

	private int loginsession = 0;

	public static String chat_room_No;
	@Autowired
	private MemberService member_service;

	// autowired chat service
	@Autowired
	private chat_room_Service cR_service;

	@GetMapping("/")
	public String root(Model melon, Model banner, Model bugs, Model genie, Model session) {
		Crawling list = new Crawling();

		try {
			genie.addAttribute("genie", list.Crawling_genie());
			banner.addAttribute("banner", list.Crawling2());
			melon.addAttribute("list", list.Crawling());
			bugs.addAttribute("bugs", list.Crawling_bugs());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.addAttribute("session", loginsession);
		return "index";

	}

	@GetMapping("/detail")
	public String detailform() {

		return "detail";
	}

	@GetMapping("/inputform")
	public String inputform() {
		return "inputform";
	}

	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}

	// go chat page
	@GetMapping("/chat")
	public String chatpage(Model model) {
		List<chat_room_Dto> list = cR_service.select_CRList();
		System.out.print(list);

		model.addAttribute("list_1", list);
		return "chat";
	}

	// go chat_room_open page
	@GetMapping("/chat_room_open")
	public String chatopen() {

		return "chat_room_open";
	}

	// chat room make form get
	@GetMapping("chat_room_make")
	public String chatR_insert(chat_room_Dto dto) {
		int res = 0;
		res = cR_service.Insert(dto);

		if (res > 0) {
			return "redirect:chat";
		} else {
			return "redirect:chat";
		}
	}

	@GetMapping("/go_to_chat_room")
	public String go_chatR(HttpServletRequest request, Model model) {
		chat_room_No = request.getParameter("room_no");
		List<chat_room_Dto> list = cR_service.select_CR(chat_room_No);
		System.out.print(chat_room_No);
		model.addAttribute("roomlist", list);

		return "chat_room";
	}

	@GetMapping("/mychatt")
	public ModelAndView chatt() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat_room");
		return mv;
	}

	@GetMapping("/sign_up")
	public String sign_up() {

		return "sign_up";
	}

	@PostMapping("/sign_up_form")
	public String sign_up_form(MemberDto dto) {
		int res = 0;
		res = member_service.insert_Member(dto);
		System.out.println("sign_up_log");
		if (res > 0) {
			System.out.println(dto);
			return "redirect:/";
		} else {
			System.out.println(dto);
			return "redirect:/";
		}
	}

	@PostMapping("/login_form")
	public String login_form(MemberDto dto) {
		System.out.println(dto);
		List<MemberDto> M_list = member_service.selectList(dto);
		if (M_list == null) {
			return "redirect:/";
		} else {
			return "redirect:/";
		}
	}

}
