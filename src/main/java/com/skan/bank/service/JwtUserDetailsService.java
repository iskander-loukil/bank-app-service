package com.skan.bank.service;

import com.skan.bank.model.User;
import com.skan.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String accountCode) throws UsernameNotFoundException {
		Optional<User> user = this.userRepository.findUserByAccountCode(accountCode);
		if (user.isPresent()){
			return new org.springframework.security.core.userdetails.User(user.get().getAccountCode(),
					user.get().getPassword(),
					new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User not found with account code: " + accountCode);
		}
	}

}