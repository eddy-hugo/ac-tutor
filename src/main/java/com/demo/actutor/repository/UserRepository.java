package com.demo.actutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.actutor.dto.UserDTO;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserDTO, Long> {

	UserDTO findByEmail(String email);
	
}