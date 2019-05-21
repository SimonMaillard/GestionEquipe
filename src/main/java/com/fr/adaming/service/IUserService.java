package com.fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fr.adaming.entity.User;

@Service
public interface IUserService {
	
	public User create(User user);
	public List<User> findAll();
	public User findById(Integer id);
	public User update(User user);
	public String delete(Integer id);

}
