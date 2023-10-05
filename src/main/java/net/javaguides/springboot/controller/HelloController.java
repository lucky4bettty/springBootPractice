package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.model.Manager;
import net.javaguides.springboot.service.ManagerService;


@Controller
public class HelloController {
	
	@Autowired
	private ManagerService managerService;


	@RequestMapping("/hello")
	public String hello(Model model) {

		return "index";
	}
	

}
