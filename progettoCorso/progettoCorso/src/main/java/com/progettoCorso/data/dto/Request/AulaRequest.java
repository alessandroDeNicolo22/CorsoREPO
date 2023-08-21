package com.progettoCorso.data.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class AulaRequest {
	
	//***Sezione Attributi***\\
		@JsonProperty
		private Integer id;

		@JsonProperty
		private String descrizione;

		@JsonProperty
		private int numeroPosti;
}
