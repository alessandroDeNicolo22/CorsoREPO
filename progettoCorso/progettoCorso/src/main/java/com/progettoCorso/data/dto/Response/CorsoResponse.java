package com.progettoCorso.data.dto.Response;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.progettoCorso.data.entity.Aula;
import com.progettoCorso.data.entity.Docente;
import com.progettoCorso.data.entity.Studente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CorsoResponse {
	//***Sezione Attributi***\\

		@JsonProperty
		private Integer id;

		@JsonProperty
		private String corso;

		@JsonProperty
		private Docente oDocente;

		@JsonProperty
		private Aula oAula;

		@JsonProperty
		private String durata;

		@JsonProperty
		private Date dataInizio;

		@JsonProperty
		private List<Studente> partecipanti;
}
