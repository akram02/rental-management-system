package app.controller;

import app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/home")
public class HomeController {
	@Autowired
	private ItemService itemService;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("items", itemService.findAll());
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
