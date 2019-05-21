package com.fr.adaming.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IEquipeDao;
import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;

@Service
public class EquipeService implements IEquipeService{
	private Logger log = Logger.getLogger(EquipeService.class);

	@Autowired
	private IEquipeDao dao;

	@Override
	public Equipe create(Equipe equipe) {
		if (equipe==null) {
			log.debug("enregistrer equipe null impossible");
			return equipe = null;
		}else {
			try {
				dao.save(equipe);
			} catch (Exception e) {
				if (e instanceof DataIntegrityViolationException) {
					log.debug("nom-niveau non null OU nom déjà attribué !");
					return equipe = null;
				}else {
					log.error(e.getMessage());
					return equipe = null;
				}
			}
			return equipe;
		}
	}

	@Override
	public List<Equipe> findAll() {
		return dao.findAll();
	}

	@Override
	public Equipe findById(Integer id) {
		Equipe equipe = null;
		try {
			equipe = dao.findById(id).get();
		} catch (Exception e) {
			if (e instanceof InvalidDataAccessApiUsageException) {
				log.debug("id must be not null !");
			}else if (e instanceof NoSuchElementException) {
				log.debug("Unknown Id !");
			}else {
				log.error(e.getMessage());
			}
		}
		return equipe;
	}

	@Override
	public Equipe update(Equipe equipe) {
		try {
			dao.save(equipe);
		} catch (Exception e) {
			if (e instanceof InvalidDataAccessApiUsageException) {
				log.debug("equipe must be not null");
			}else if (e instanceof DataIntegrityViolationException) {
				log.debug("nom already exist or null OR niveau null");
			}else {
				log.error(e.getMessage());
			}
		}
		return equipe;
	}

	@Override
	public String delete(Integer id) {
		dao.deleteById(id);
		return "SUCCESS";
	}
	
	
}
