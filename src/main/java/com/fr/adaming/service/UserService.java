package com.fr.adaming.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.User;


@Service
public class UserService implements IUserService{
	private Logger log = Logger.getLogger(UserService.class);

	@Autowired
	private IUserDao dao;

	@Override
	public User create(User user) {
		if (user.getId()==null || user.getId()==0) {
			try {
				dao.save(user);
				log.info("user enregistré");
			} catch (Exception e) {
				if (e instanceof DataIntegrityViolationException) {
					log.debug("l'email doit être unique");
				}else {
					log.error(e.getMessage());
				}
			}
			return user;
		}else {
			if (dao.existsById(user.getId())) {
				log.debug("l'objet user a un Id différent de null");
				user = null;
				return user;
			}else {
				log.info("user enregistré");
				return dao.save(user);
			}
		}	
	}

	@Override
	public List<User> findAll() {
		List<User> list = dao.findAll();
		if (list.isEmpty()) {
			log.info("la liste est vide");
		}else {
			log.info("opération effectuée");
		}
		return list;
	}

	@Override
	public User findById(Integer id) {
		User user = null;
		try {
			user = dao.findById(id).get();
		}catch (Exception e) {
			if (e instanceof IllegalArgumentException) {
				log.debug("l'id est null !");
			}else {
				log.error(e.getMessage());
			}
		}
		return user;
	}

	@Override
	public User update(User user) {
		if (user.getId()==null) {
			log.debug("l'id est null !");
			return null;
		}else {
			if (dao.existsById(user.getId())) {
				log.info("user modifié");
				return dao.save(user);
			}else {
				log.debug("l'utilisateur n'existe pas !");
				return null;
			}
		}	
	}

	@Override
	public String delete(Integer id) {
			try {
				dao.deleteById(id);
			} catch (Exception e) {
				if (e instanceof InvalidDataAccessApiUsageException ) {
					log.debug("l'id est null !");
				}else if (e instanceof EmptyResultDataAccessException) {
					log.debug("l'id n'existe pas !");
				}else{
					log.error(e.getMessage());
				}
			}
			String message = "SUCCESS";
			return message;
		}
	
}
