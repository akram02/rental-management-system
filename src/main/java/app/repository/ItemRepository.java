package app.repository;

import app.entity.Color;
import app.entity.Gender;
import app.entity.Item;
import app.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	Item findByIdEquals(Integer id);

	List<Item> findByGenderEqualsAndSizeEqualsAndColorEquals(Gender gender, Size size, Color color);

	List<Item> findByGenderEqualsAndSizeEquals(Gender gender, Size size);

	List<Item> findByGenderEqualsAndColorEquals(Gender gender, Color color);

	List<Item> findBySizeEqualsAndColorEquals(Size size, Color color);

	List<Item> findByGenderEquals(Gender gender);

	List<Item> findBySizeEquals(Size size);

	List<Item> findByColorEquals(Color color);
}