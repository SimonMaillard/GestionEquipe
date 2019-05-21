package com.fr.adaming.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IAuthDao;
import com.fr.adaming.entity.User;

@Service
public class AuthService implements IAuthService{
	private Logger log = Logger.getLogger(AuthService.class);

	@Autowired
	private IAuthDao authDao;
	
	@Override
	public User login(String email, String pwd) {
		return authDao.findByEmailAndPwd(email, pwd);
	}

	@Override
	public User register(User user) {
		if (user.getId()==null || user.getId()==0) {
			try {
				authDao.save(user);
			} catch (Exception e) {
				if (e instanceof DataIntegrityViolationException) {
					log.debug("l'email doit être unique");
				}else {
					log.error(e.getMessage());
				}
			}
			return user;
		}else {
			if (authDao.existsById(user.getId())) {
				log.debug("l'objet user a un Id différent de null");
				return null;
			}else {
				log.info("user enregistré");
				return authDao.save(user);
			}
		}
	}

}
