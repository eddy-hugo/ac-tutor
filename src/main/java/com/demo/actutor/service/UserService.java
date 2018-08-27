package com.demo.actutor.service;

import com.demo.actutor.dto.UserDTO;

public interface UserService {
	public UserDTO findUserByEmail(String email);
	public void saveUser(UserDTO user);
}
