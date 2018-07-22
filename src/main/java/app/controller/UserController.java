package app.controller;

import app.entity.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	private UserService userService;

	// Display user registration page
	@GetMapping(path = "/register")
	public String getRegister(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	// Process user registration
	@PostMapping(path = "/register")
	public String postRegister(User user) {
		userService.register(user);
		return "redirect:/home";
	}
}