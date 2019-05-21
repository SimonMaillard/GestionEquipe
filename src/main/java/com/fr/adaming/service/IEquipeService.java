package com.fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fr.adaming.entity.Equipe;

@Service
public interface IEquipeService {
	
	public Equipe create(Equipe equipe);
	public List<Equipe> findAll();
	public Equipe findById(Integer id);
	public Equipe update(Equipe equipe);
	public String delete(Integer id);

}
