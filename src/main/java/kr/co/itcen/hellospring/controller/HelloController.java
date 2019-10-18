package kr.co.itcen.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		String data = "Hello World";
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data", data);
		mav.setViewName("hello");
		
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String hello3(Model model) {
		String data = "Hello World3";
		model.addAttribute("data", data);
		
		return "hello";
	}
	
	@RequestMapping("/hello4")
	public String hello4(
			@RequestParam(value="email", required=true, defaultValue="") String email,
			@RequestParam(value="age", required=true, defaultValue="0") int age,
			Model model) {
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		return "hello";
	}
	
	@RequestMapping("/hello5")
	public String hello5(
			@ModelAttribute User user,
			Model model) {
		System.out.println(user);
		model.addAttribute("email", user.getEmail());
		model.addAttribute("age", user.getAge());
		return "hello";
	}
	
	@RequestMapping("/hello6")
	public void hello6(
			HttpServletRequest request,
			HttpServletResponse response,
			Writer out,
			Model model) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward();
		out.write("<h1>Hello World</h1>");
	}
	
	@ResponseBody // response body 하고 같은 표현법 (out.write("<h1>Hello World</h1>"))
	@RequestMapping("/hello7")
	public String hello7() {
		return "<h1>Hello World</h1>";
	}

}
