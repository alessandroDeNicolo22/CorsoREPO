package com.progettoCorso.data.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AulaResponse {
	//***Sezione Attributi***\\
	@JsonProperty
	private Integer id;

	@JsonProperty
	private String descrizione;

	@JsonProperty
	private int numeroPosti;
}
