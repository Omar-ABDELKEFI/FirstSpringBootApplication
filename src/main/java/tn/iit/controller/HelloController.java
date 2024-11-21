package tn.iit.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@GetMapping({"/", "/index", "/home"})
	public String index(Model model) { //url: http://localhost:8080/hello/
		model.addAttribute("date", LocalTime.now());
		return "hello"; // va à la page hello.html
	}
	
	@GetMapping("/index2")
	public ModelAndView index2() { //url: http://localhost:8080/hello/index2
		ModelAndView modelAndView = new ModelAndView(); // Objet de spring
		//fixe la vue
		modelAndView.setViewName("hello");// va à la page hello.html
		// envoi de données à la vue
		modelAndView.addObject("date", LocalDate.now());
		return modelAndView; 
	}
	
	@PostMapping("/save")
	public String save(Model model, @RequestParam("nom") String nom) {
		
		model.addAttribute("nom", nom);
		return "hello";
	}
}
