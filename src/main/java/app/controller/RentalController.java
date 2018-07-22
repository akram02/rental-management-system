package app.controller;

import app.service.RentalService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping(path = "/rentals")
public class RentalController {
	@Autowired
	private RentalService rentalService;

	@Autowired
	private UserService userService;

	// Order item and if it is rented you can make a reservation, and not rented you can rent it
	@PostMapping(path = "/order")
	public String orderRental(Principal principal, @RequestParam("item_id") String itemId) {
		rentalService.orderRental(getUserId(principal), Integer.parseInt(itemId));
		return "redirect:/me/orders";
	}

	// Return the item and rent the first reservation
	@PostMapping(path = "/return")
	public String returnRental(Principal principal, @RequestParam("item_id") String itemId) {
		rentalService.returnRental(getUserId(principal), Integer.parseInt(itemId));
		return "redirect:/me/orders";
	}

	private Integer getUserId(Principal principal) {
		return userService.findByUsername(principal.getName()).getId();
	}
}
