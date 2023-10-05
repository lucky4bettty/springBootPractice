package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {
	@RequestMapping("/admin/nav")
    public String showLoginPage() {
        return "admin/nav";
    }
}
