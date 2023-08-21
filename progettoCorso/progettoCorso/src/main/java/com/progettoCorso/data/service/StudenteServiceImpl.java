package com.progettoCorso.data.service;

import java.util.ArrayList;
import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.progettoCorso.data.dto.Request.StudenteRequest;
import com.progettoCorso.data.dto.Response.StudenteResponse;
import com.progettoCorso.data.entity.QStudente;
import com.progettoCorso.data.entity.Studente;
import com.progettoCorso.data.repository.StudenteRepository;
import javax.persistence.EntityManager;
@Service
@Transactional
public class StudenteServiceImpl implements StudenteService{

	@Autowired
	StudenteRepository repo;
	@Autowired
	EntityManager entitymanager;

	@Override
	public ArrayList<StudenteResponse> getAllStudenti() {
		ArrayList<Studente> elenco = (ArrayList<Studente>) repo.findAll();
		return elenco.stream()
				.map(studente -> new StudenteResponse(studente.getId(),studente.getCognome() , studente.getNome(),studente.getMatricola()))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public StudenteResponse findById(Integer id) {
		Studente oStudente = repo.findById(id).orElse(null);
		return new StudenteResponse(oStudente.getId(),oStudente.getCognome(),oStudente.getNome(),oStudente.getMatricola());
	}

	@Override
	public void saveStudente(StudenteRequest oStudenteRequest) {
		System.out.println(oStudenteRequest);
		repo.save(new Studente(oStudenteRequest.getId(),oStudenteRequest.getCognome(),oStudenteRequest.getNome(),oStudenteRequest.getMatricola()));
	}

	@Override
	public void deleteStudente(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Boolean checkElimina(Integer id) {
		if(repo.nStudenti(id)==0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Page<StudenteResponse> getPage(int pageIndex, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
		Page<Studente> studentePage = repo.findAll(pageRequest);
		return studentePage.map(this::entityToDTO);
	}

	private StudenteResponse entityToDTO(Studente studente) {
		return new StudenteResponse(studente.getId(),
				studente.getCognome(),
				studente.getNome(),
				studente.getMatricola());
	}

	public List<StudenteResponse> getStudentiByID(){
		QStudente studente = QStudente.studente;
		JPAQueryFactory queryFactory = new JPAQueryFactory(entitymanager);
//		La ragione per cui passiamo un oggetto EntityManager a JPAQueryFactory è che EntityManager è responsabile dell'interazione con il database in un'applicazione Java che utilizza la Java Persistence API (JPA). 
//		JPAQueryFactory è una classe fornita da Querydsl che semplifica la creazione e l'esecuzione di query JPQL (Java Persistence Query Language) all'interno di un'applicazione JPA.
//		Ecco il motivo per cui passiamo un oggetto EntityManager a JPAQueryFactory:
//		Interazione con il Database: EntityManager è l'oggetto principale che gestisce l'interazione con il database per le operazioni di persistenza e le query. 
//		Esso comprende la logica per tradurre le query JPQL in query SQL o il linguaggio del database sottostante.
//		Fornire Contesto di Persistenza: EntityManager gestisce il contesto di persistenza, tracciando le entità caricate, modificate e rimosse. 
//		Questo contesto è importante per garantire che le operazioni di persistenza siano coerenti e che i cambiamenti siano riflessi correttamente nel database.
//		Gestione delle Transazioni: EntityManager gestisce il ciclo di vita delle transazioni e le commit. Quando eseguiamo query o operazioni di persistenza, spesso vogliamo che queste siano eseguite all'interno di una transazione.
//		Gestione delle Cache: EntityManager gestisce la cache di primo livello per le entità, che migliora le prestazioni riducendo il numero di accessi al database.
//		Fornire Contesto di Esecuzione: EntityManager fornisce il contesto di esecuzione necessario per eseguire correttamente le query e le operazioni di persistenza all'interno dell'applicazione JPA.
//		Passando un oggetto EntityManager a JPAQueryFactory, stiamo essenzialmente consentendo a JPAQueryFactory di utilizzare il contesto di persistenza e gli strumenti forniti da EntityManager per costruire e eseguire query in modo corretto e coerente rispetto all'ambiente JPA dell'applicazione.
		
		List<Studente> studenti = queryFactory
		    .selectFrom(studente)
		    .where(studente.id.between(0, 10))
		    .fetch();
		return studenti.stream().map(Studente -> new StudenteResponse(Studente.getId(), 
				Studente.getCognome(),
				Studente.getNome(), 
				Studente.getMatricola())).collect(Collectors.toCollection(ArrayList::new));
	}
//	    Ecco cosa fa il metodo in dettaglio:
//
//		studenti.stream(): Questo converte la lista studenti in uno stream di oggetti Studente. Uno stream è una sequenza di elementi su cui puoi applicare operazioni di trasformazione e filtraggio.
//
//		.map(Studente -> new StudenteResponse(...): Questo è un'operazione di mappatura che prende ciascun oggetto Studente nello stream e lo trasforma in un nuovo oggetto StudenteResponse. 
//		La lambda expression Studente -> new StudenteResponse(...) crea un nuovo oggetto StudenteResponse utilizzando i dati dell'oggetto Studente.
//
//		.collect(Collectors.toCollection(ArrayList::new)): Questo è un'operazione di collezione che raccoglie gli oggetti StudenteResponse trasformati nello stream e li immagazzina in una nuova istanza di ArrayList. 
//		Collectors.toCollection(ArrayList::new) specifica che desideriamo raccogliere gli elementi in un'istanza di ArrayList.
//
//		In sintesi, questo metodo prende la lista di oggetti Studente, crea un nuovo oggetto StudenteResponse per ciascuno di essi, e poi raccoglie tutti gli oggetti StudenteResponse in un'istanza di ArrayList. 
//		Alla fine, il risultato sarà una lista di oggetti StudenteResponse, che è la trasformazione degli oggetti Studente originali.

}
