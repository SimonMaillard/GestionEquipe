package com.fr.adaming.rest;

import java.util.List;
import java.util.logging.LogManager;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fr.adaming.dto.UserDto;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(path ="api")
public class UserRestController {

	
	@Autowired
	private IUserService service;

	@ApiOperation(value = "create", notes = "l'id doit être null ou égal à 0 et différent d'un id existant")
	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public User create(@Valid @RequestBody UserDto userDto) {
		User user = service.create(new User(userDto.getNom(), userDto.getPrenom(), userDto.getEmail(), userDto.getPwd(), userDto.getEquipe()));
		return user;
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@ApiOperation(value = "update", notes = "l'id doit déjà exister dans la DB")
	@RequestMapping(path = "/users", method = RequestMethod.PUT)
	public User update(@RequestBody User user) {
		service.update(user);
		return user;
	}

	@RequestMapping(path = "/users", method = RequestMethod.DELETE)
	public String delete(Integer id) {
		service.delete(id);
		return "user delete";
	}

	
}
