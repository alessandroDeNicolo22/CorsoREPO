package com.progettoCorso.data.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class DocenteRequest {
	//***Sezione Attributi***\\
	@JsonProperty
	private Integer id;

	@JsonProperty
	private String cognome;

	@JsonProperty
	private String nome;
}
