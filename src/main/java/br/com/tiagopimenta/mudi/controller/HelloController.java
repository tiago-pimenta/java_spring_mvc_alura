package br.com.tiagopimenta.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
//	public String hello(HttpServletRequest request) {
//		
//		request.setAttribute("nome", "Mundo");
//		
//		return "hello";
//		
//	}
	
	public String hello(Model model) {
		
		model.addAttribute("nome", "Mundo");
		
		return "hello";
		
	}
	
}
