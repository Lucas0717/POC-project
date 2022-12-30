package com.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import com.demo.exception.UserAlreadyExistEception;
import com.demo.exception.UserNotExistExceotion;
import com.demo.model.User;
import com.demo.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	// @Transactional(isolation = Isolation.SERIALIZABLE)
	public void add(User user) {
		if (userRepository.existsById(user.getId())) {
			throw new UserAlreadyExistEception("User Aleady Exists");
		}
//		System.out.println(user.getId());
//		System.out.println(user.getEmail());
//		System.out.println(user.getPassword());
//		System.out.println(user.getFirstName());
//		System.out.println(user.getLastName());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}
	
	public void authenticate(User user) {

		
		Optional<User> curUser = userRepository.findById(user.getId());
		String dePass = passwordEncoder.encode(user.getPassword());
		if (curUser.get() == null || !dePass.equals(curUser.get().getPassword())) {
			throw new UserNotExistExceotion("User doesn't exist");
		}
	}
	
	@Transactional
	public void update(User user) {
		userRepository
        .findById(user.getId()) // returns Optional<User>
        .ifPresent(user1 -> {
            user1.setPassword(passwordEncoder.encode(user.getPassword()));
            user1.setEmail(user.getEmail());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            userRepository.save(user1);
        });
	}
	
	public User searchById(Long id) {
		User user = userRepository.findById(id).get();
		if (user == null) {
			throw new UserNotExistExceotion("User doesn't exist");
		}
		return user;
	}
	
	@Transactional
	public void deleteById(Long id) {
		User user = userRepository.findById(id).get();
		if (user == null) {
			throw new UserNotExistExceotion("User doesn't exist");
		}
		userRepository.deleteById(id);
	}
	
}
