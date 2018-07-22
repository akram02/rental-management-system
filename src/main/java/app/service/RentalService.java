package app.service;

import app.entity.Rental;
import app.entity.Status;
import app.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RentalService {
	@Autowired
	private RentalRepository rentalRepository;

	// Display your rental list
	public List<Rental> findByUserId(Integer userId) {
		return rentalRepository.findByUserIdEquals(userId);
	}

	// Order item and if it is rented you can make a reservation, and not rented you can rent it
	public void orderRental(Integer userId, Integer itemId) {
		// Create a new rental
		Rental rental = new Rental(userId, itemId);
		// Determine if it is rented
		if (rentalRepository.findByItemIdEqualsAndStatusEquals(itemId, Status.RENTED).size() > 0) {
			rental.setStatus(Status.RESERVED);
		} else {
			rental.setStatus(Status.RENTED);
		}
		rentalRepository.save(rental);
	}

	// Return the item and rent the first reservation
	public void returnRental(Integer userId, Integer itemId) {
		List<Rental> rentals;
		// Return the item
		rentals = rentalRepository.findByUserIdEqualsAndItemIdEqualsAndStatusEquals(userId, itemId, Status.RENTED);
		if (rentals.size() == 1) {
			returnProcess(rentals);
		}
		// Rent the first reservation
		rentals = rentalRepository.findByItemIdEqualsAndStatusEqualsOrderByUpdatedAt(itemId, Status.RESERVED);
		if (rentals.size() > 0) {
			rendProcess(rentals);
		}
	}

	private void returnProcess(List<Rental> rentals) {
		Rental rental = rentals.get(0);
		rental.setStatus(Status.RETURNED);
		rental.setUpdatedAt(new Date());
		rentalRepository.save(rental);
	}

	private void rendProcess(List<Rental> rentals) {
		Rental rental = rentals.get(0);
		rental.setStatus(Status.RENTED);
		rental.setUpdatedAt(new Date());
		rentalRepository.save(rental);
	}
}
