package com.progettoCorso.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@Table(name="Discente")
@AllArgsConstructor
@RequiredArgsConstructor
public class Studente {
	//***Sezione Attributi***\\\
	@Column(name="IDDiscente")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="Cognome")
	private String cognome;

	@Column(name="Nome")
	private String nome;

	@Column(name="Matricola")
	private String matricola;
}
