package com.akhil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({ "", "/" })
public class HomeController {

	@GetMapping({ "", "/" })
	@ResponseBody
	public String index() {
		System.out.println("In Index()");
		return "Hello User";
	}

}
