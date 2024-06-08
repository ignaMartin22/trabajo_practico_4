package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping({"/index","/home","/inicio","/","/index.html"})
	public String getString(Model model) {
		model.addAttribute("titulo", "FI UNJU");
		return "index";
	}
}
