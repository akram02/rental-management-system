package app.controller;

import app.entity.Item;
import app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/items")
public class ItemController {
	@Autowired
	private ItemService itemService;

	// Specify id and display a item
	@GetMapping(value = "{id}")
	public ModelAndView get(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("item", itemService.findById(id));
		modelAndView.setViewName("item");
		return modelAndView;
	}

	// Search items by some params
	@GetMapping(path = "/")
	public ModelAndView search(
			@RequestParam(name = "gender", defaultValue = "") String genderId,
			@RequestParam(name = "size", defaultValue = "") String sizeId,
			@RequestParam(name = "color", defaultValue = "") String colorId
	) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("items", findBy(genderId, sizeId, colorId));
		modelAndView.setViewName("home");
		return modelAndView;
	}

	// Receive some params and pass them to the appropriate service
	private List<Item> findBy(String genderId, String sizeId, String colorId) {
		List<Item> items;
		if (!genderId.equals("") && !sizeId.equals("") && !colorId.equals("")) {
			items = itemService.findByGenderAndSizeAndColor(genderId, sizeId, colorId);
		} else if (!genderId.equals("") && !sizeId.equals("")) {
			items = itemService.findByGenderAndSize(genderId, sizeId);
		} else if (!genderId.equals("") && !colorId.equals("")) {
			items = itemService.findByGenderAndColor(genderId, colorId);
		} else if (!sizeId.equals("") && !colorId.equals("")) {
			items = itemService.findBySizeAndColor(sizeId, colorId);
		} else if (!genderId.equals("")) {
			items = itemService.findByGender(genderId);
		} else if (!sizeId.equals("")) {
			items = itemService.findBySize(sizeId);
		} else if (!colorId.equals("")) {
			items = itemService.findByColor(colorId);
		} else {
			items = itemService.findAll();
		}
		return items;
	}
}