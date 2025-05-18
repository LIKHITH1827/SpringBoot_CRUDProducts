package com.example.api.repository;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.example.api.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>
{ 
	
	

	Users findByUsername(String username);
	
}
