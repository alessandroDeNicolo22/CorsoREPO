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

@Data
@Entity
@Table(name="Aula")
@AllArgsConstructor
@RequiredArgsConstructor
public class Aula {
	
	//***Sezione Attributi***\\\
	@Column(name="IDAula")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="Descrizione")
	private String descrizione;

	@Column(name="Numeroposti")
	private Integer numeroPosti;	
}
