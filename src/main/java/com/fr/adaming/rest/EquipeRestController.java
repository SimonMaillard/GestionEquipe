package com.fr.adaming.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.dto.EquipeDto;
import com.fr.adaming.entity.Equipe;
import com.fr.adaming.service.IEquipeService;

@RestController
@RequestMapping(path = "api")
public class EquipeRestController {

	@Autowired
	private IEquipeService service;

	@RequestMapping(path = "/equipes", method = RequestMethod.POST)
	public Equipe create(@Valid @RequestBody EquipeDto equipeDto) {
		Equipe equipe = service.create(new Equipe(equipeDto.getNom(), equipeDto.getNiveau()));
		return equipe;
	}

	@RequestMapping(path = "/equipes", method = RequestMethod.GET)
	public List<Equipe> findAll() {
		return service.findAll();
	}

	@RequestMapping(path = "/equipes/{id}", method = RequestMethod.POST)
	public Equipe findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@RequestMapping(path = "/equipes", method = RequestMethod.PUT)
	public Equipe update(@Valid @RequestBody EquipeDto equipeDto) {
		Equipe equipe = service.update(new Equipe(equipeDto.getNom(), equipeDto.getNiveau()));
		return equipe;
	}

	@RequestMapping(path = "/equipes", method = RequestMethod.DELETE)
	public String delete(Integer id) {
		return service.delete(id);
	}

	
}
