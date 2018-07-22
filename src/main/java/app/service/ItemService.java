package app.service;

import app.entity.Color;
import app.entity.Gender;
import app.entity.Item;
import app.entity.Size;
import app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	public Item findById(Integer id) {
		return itemRepository.findByIdEquals(id);
	}

	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	public List<Item> findByGenderAndSizeAndColor(String genderId, String sizeId, String colorId) {
		return itemRepository.findByGenderEqualsAndSizeEqualsAndColorEquals(
				getGender(genderId), getSize(sizeId), getColor(colorId));
	}

	public List<Item> findByGenderAndSize(String genderId, String sizeId) {
		return itemRepository.findByGenderEqualsAndSizeEquals(getGender(genderId), getSize(sizeId));
	}

	public List<Item> findByGenderAndColor(String genderId, String colorId) {
		return itemRepository.findByGenderEqualsAndColorEquals(getGender(genderId), getColor(colorId));
	}

	public List<Item> findBySizeAndColor(String sizeId, String colorId) {
		return itemRepository.findBySizeEqualsAndColorEquals(getSize(sizeId), getColor(colorId));
	}

	public List<Item> findByGender(String genderId) {
		return itemRepository.findByGenderEquals(getGender(genderId));
	}

	public List<Item> findBySize(String sizeId) {
		return itemRepository.findBySizeEquals(getSize(sizeId));
	}

	public List<Item> findByColor(String colorId) {
		return itemRepository.findByColorEquals(getColor(colorId));
	}

	private Gender getGender(String genderId) {
		return Gender.getById(Integer.parseInt(genderId));
	}

	private Size getSize(String sizeId) {
		return Size.getById(Integer.parseInt(sizeId));
	}

	private Color getColor(String colorId) {
		return Color.getById(Integer.parseInt(colorId));
	}
}
