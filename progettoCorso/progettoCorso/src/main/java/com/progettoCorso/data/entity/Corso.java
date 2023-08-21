package com.progettoCorso.data.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="Corso")
public class Corso {
	//***Sezione Attributi***\\\
		@Column(name="IDCorso")
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		
		@Column(name="Corso")
		private String corso;
		
		@Column(name="Durata")
		private String durata;
		
		@ManyToOne//1 docente su + corsi
		@JoinColumn(name="IDDocente")
		private Docente oDocente;
		
		@ManyToOne
		@JoinColumn(name="IDAula")
		private Aula oAula;
		
		@Column(name="Datainizio")
		private Date dataInizio;
		
		@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)// + studenti su + corsi( Il caricamento EAGER indica che l'oggetto di campo/relazione sarà caricato
		//al momento della creazione dell'oggetto padre che lo contiene.)
		@JoinTable(name = "Corsodiscente", joinColumns = {@JoinColumn(name="IDCorso")},inverseJoinColumns = {@JoinColumn(name="IDDiscente")})
		private List<Studente> partecipanti = new ArrayList<Studente>();
}
