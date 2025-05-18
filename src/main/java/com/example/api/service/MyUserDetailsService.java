package com.example.api.service;

import java.awt.desktop.UserSessionEvent;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.api.model.UserPrincipal;
import com.example.api.model.Users;
import com.example.api.repository.UserRepo;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user= userRepo.findByUsername(username);
		if (user==null) {
		System.out.println("User not found");
	     throw new UsernameNotFoundException("user not found");
		}
	   return new UserPrincipal(user);
	}

}
