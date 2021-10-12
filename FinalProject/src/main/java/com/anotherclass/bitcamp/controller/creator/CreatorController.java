package com.anotherclass.bitcamp.controller.creator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreatorController {
	
	@RequestMapping("/creator")
	public String creator() {
		return "creator/creator";
	}
	
	@RequestMapping("/makeClass")
	public String creatClass() {
	    return "creator/makeClass";
	}
	   
	@RequestMapping("/modifyClass")
	public String modifyClass() {
	    return "creator/modifyClass";
	}
	   
	@RequestMapping("/creatorChannel")
	public String creatorChannel() {
	    return "creator/creatorChannel";
	}
	
	@RequestMapping("/classMain")
	public String classMain() {
	    return "user/classDetailPage/classMain";
	}
}