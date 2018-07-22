package app.repository;

import app.entity.Rental;
import app.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
	List<Rental> findByUserIdEquals(Integer userId);

	List<Rental> findByItemIdEqualsAndStatusEquals(Integer itemId, Status status);

	List<Rental> findByItemIdEqualsAndStatusEqualsOrderByUpdatedAt(Integer itemId, Status status);

	List<Rental> findByUserIdEqualsAndItemIdEqualsAndStatusEquals(Integer userId, Integer itemId, Status status);
}