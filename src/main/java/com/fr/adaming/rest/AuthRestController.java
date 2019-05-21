package com.fr.adaming.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.dto.LoginDto;
import com.fr.adaming.dto.UserDto;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IAuthService;

@RestController
@RequestMapping(path = "api")
public class AuthRestController {
	
	@Autowired
	private IAuthService service;

	@RequestMapping(path = "/auth", method = RequestMethod.POST)
	public User login(@Valid @RequestBody LoginDto loginDto) {
		User user = service.login(loginDto.getEmail(), loginDto.getPwd());
		return user;
	}

	@RequestMapping(path = "/auth", method = RequestMethod.PUT)
	public User register(@Valid @RequestBody UserDto userDto) {
		User user = service.register(new User(userDto.getNom(), userDto.getPrenom(), userDto.getEmail(), userDto.getPwd(), userDto.getEquipe()));
		return user;
	}
	
	

}
