package com.sdmadruga.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdmadruga.dsmovie.etities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
