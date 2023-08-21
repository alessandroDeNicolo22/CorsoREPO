package com.progettoCorso.data.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StudenteRequest {
	//***Sezione Attributi***\\

	@JsonProperty
	private Integer id;

	@JsonProperty
	private String cognome;

	@JsonProperty
	private String nome;

	@JsonProperty
	private String matricola;
}
