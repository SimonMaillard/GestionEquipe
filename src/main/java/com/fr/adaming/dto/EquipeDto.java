package com.fr.adaming.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
public class EquipeDto {

	@NotNull
	private String nom;
	
	@NotNull
	private String niveau;
}
