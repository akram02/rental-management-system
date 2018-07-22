package app.service;

import app.entity.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsernameEquals(username);
	}

	public User register(User user) {
		// Save user after encrypt the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
