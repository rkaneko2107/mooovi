package com.mooovi.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mooovi.business.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
