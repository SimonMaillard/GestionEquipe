package com.fr.adaming.service;

import org.springframework.stereotype.Service;

import com.fr.adaming.entity.User;

@Service
public interface IAuthService {
	
	public User login(String email, String pwd);
	
	public User register(User user);

}
