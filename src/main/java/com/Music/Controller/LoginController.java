package com.Music.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private String id = null;

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
	public String detailform(Model melon, Model bugs, Model genie) {
		Crawling list = new Crawling();
		try {
			genie.addAttribute("genie", list.Crawling_genie());
			melon.addAttribute("list", list.Crawling());
			bugs.addAttribute("bugs", list.Crawling_bugs());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "detail";
	}

	@GetMapping("/inputform")
	public String inputform() {
		return "inputform";
	}

	@GetMapping("/mypage")
	public String mypage(Model session) {
		session.addAttribute("session", loginsession);
		session.addAttribute("myid", id);

		if (loginsession == 1) {
			return "mypage";
		} else {
			return "/";
		}
	}

	@GetMapping("/Withdrawal")
	public String Withdrawal(MemberDto dto) {
		dto.setUser_Id(id);
		member_service.Delete_Member(dto);
		if(loginsession == 0) {
			return "redirect:/";
		}else {
			loginsession = 0;
			id = null;
			return "redirect:/";
		}
	}

	// go chat page
	@GetMapping("/chat")
	public String chatpage(Model model, Model session) {
		List<chat_room_Dto> list = cR_service.select_CRList();
		session.addAttribute("session", loginsession);

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
	public String chatR_insert(chat_room_Dto dto, Model session) {
		int res = 0;
		res = cR_service.Insert(dto);
		session.addAttribute("session", loginsession);
		if (res > 0) {
			return "redirect:chat";
		} else {
			return "redirect:chat";
		}
	}

	@GetMapping("/go_to_chat_room")
	public String go_chatR(HttpServletRequest request, Model model, Model session, HttpServletResponse response)
			throws IOException {
		if (loginsession == 1) {
			chat_room_No = request.getParameter("room_no");
			List<chat_room_Dto> list = cR_service.select_CR(chat_room_No);
			System.out.print(chat_room_No);
			model.addAttribute("roomlist", list);
			session.addAttribute("myid", id);
			session.addAttribute("session", loginsession);
			return "chat_room";
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 정보를 확인해주세요.'); history.go(-1);</script>");
			out.flush();

			return "chat";
		}
	}

	@GetMapping("/sign_up")
	public String sign_up() {

		return "sign_up";
	}

	@PostMapping("/sign_up_form")
	public String sign_up_form(MemberDto dto, Model session) {
		int res = 0;
		res = member_service.insert_Member(dto);
		session.addAttribute("session", loginsession);
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
	public String login_form(MemberDto dto, Model session) {
		session.addAttribute("session", loginsession);
		List<MemberDto> M_list = member_service.selectList(dto);
		if (M_list != null) {
			loginsession = 1;
			MemberDto str = M_list.get(0);
			String[] strtos = str.toString().split(", ");
			session.addAttribute("session", loginsession);
			id = strtos[1];

			return "redirect:/";
		} else {
			return "redirect:/";
		}
	}

}
