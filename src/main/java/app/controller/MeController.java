package app.controller;

import app.entity.User;
import app.service.RentalService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(path = "/me")
public class MeController {
	@Autowired
	private UserService userService;

	@Autowired
	private RentalService rentalService;

	// Display my page
	@GetMapping
	public ModelAndView mypage(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("me", userService.findByUsername(principal.getName()));
		modelAndView.setViewName("me");
		return modelAndView;
	}

	// Display my orders
	@GetMapping(path = "/orders")
	public ModelAndView myorders(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		User me = userService.findByUsername(principal.getName());
		modelAndView.addObject("me", me);
		modelAndView.addObject("rentals", rentalService.findByUserId(me.getId()));
		modelAndView.setViewName("order");
		return modelAndView;
	}
}
