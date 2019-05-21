package com.fr.adaming.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import com.fr.adaming.entity.Equipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
public class UserDto {
	
	private String nom;

	private String prenom;
	
	@Email
	@NotNull 
	// @UniqueElements : s'utilise pas !!!! (c'est annotation hibernate)
	private String email;
	
	@NotNull
	private String pwd;
	
	private Equipe equipe;
}
