package estagio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/")
	public ModelAndView listing() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("hidden_attribute", "hidden");
		return mv;
	}

	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}

	@GetMapping("/update...")
	public String edit() {
		return "insert";
	}

}
