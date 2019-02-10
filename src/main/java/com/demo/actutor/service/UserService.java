package com.demo.actutor.service;

import com.demo.actutor.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
