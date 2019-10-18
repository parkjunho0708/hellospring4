package kr.co.itcen.hellospring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 
 * @RequestMapping Type + Method
 * 
 */

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@ResponseBody
	@RequestMapping({"/list", "", "/a/b/c/d/e/f"})
	public String list() {
		return "BoardController:list";
	}

	@ResponseBody
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "write.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Map<String, Object> map) {
		return "rediret:/board/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/view/{no}")
	public String view(@PathVariable("no") Long no) {
		return "BoardController:view:" + no;
	}

}
