package com.Music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Music.Crawling.Crawling;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@RequestMapping("/")
	public String root(Model model) {
		System.out.println("log: ");
		Crawling list = new Crawling();
		System.out.println("log: "+list);
		model.addAttribute("list",list);
		
		return "index";
	}
}
