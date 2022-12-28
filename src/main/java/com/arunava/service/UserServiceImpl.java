package com.arunava.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arunava.dto.LoginDto;
import com.arunava.model.User;
import com.arunava.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<?> register(User user) {

		User userDetails = new User();
		userDetails.setFname(user.getFname());
		userDetails.setLname(user.getLname());
		userDetails.setEmail(user.getEmail());
		userDetails.setPassword(passwordEncoder.encode(user.getPassword()));

		User saveUser = userRepository.save(userDetails);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> login(LoginDto loginDto, HttpSession request) throws Exception {
		Authentication authentication;
		try {
			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			// set session
			request.setAttribute("userDetails", loginDto.getEmail());
		} catch (Exception e) {
			throw new Exception("Credentials Invalid");
		}
		return new ResponseEntity<>("login Successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> addManyUser(List<User> user) throws Exception {

		for (User ud : user) {
			Optional<User> findByEmail = userRepository.findByEmail(ud.getEmail());
			if (findByEmail.isPresent()) {
				throw new Exception("user exists");
			}else {
				 userRepository.save(ud);			 
			}
		
		}
		return new ResponseEntity<>(user,HttpStatus.CREATED);

 		
	}

}
