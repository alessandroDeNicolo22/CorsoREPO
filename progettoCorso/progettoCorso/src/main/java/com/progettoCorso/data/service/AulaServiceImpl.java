package com.progettoCorso.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.progettoCorso.data.dto.Request.AulaRequest;
import com.progettoCorso.data.dto.Response.AulaResponse;
import com.progettoCorso.data.entity.Aula;
import com.progettoCorso.data.entity.Corso;
import com.progettoCorso.data.repository.AulaRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.progettoCorso.data.entity.QCorso;
@Service
@Transactional
public class AulaServiceImpl implements AulaService{

	@Autowired
	AulaRepository repo;
	@Autowired
	EntityManager entitymanager;

	@Override
	public ArrayList<AulaResponse> getAllAule() {
		ArrayList<Aula> elenco = (ArrayList<Aula>) repo.findAll();
		return elenco.stream()
				.map(aula -> new AulaResponse(aula.getId(), aula.getDescrizione(), aula.getNumeroPosti()))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public AulaResponse findById(Integer id) {
		Aula oAula = repo.findById(id).orElse(null);
		return new AulaResponse(oAula.getId(),oAula.getDescrizione(),oAula.getNumeroPosti());
	}

	@Override
	public void saveAula(AulaRequest oAulaRequest) {
		repo.save(new Aula(oAulaRequest.getId(), oAulaRequest.getDescrizione(), oAulaRequest.getNumeroPosti()));
	}

	@Override
	public void deleteAula(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Boolean checkAula(Integer id) {
		QCorso corso = QCorso.corso1;
		JPAQueryFactory queryFactory = new JPAQueryFactory(entitymanager);
		long numCorsi = queryFactory.selectFrom(corso).where(corso.oAula.id.eq(id)).fetchCount();
//		ho utilizzato fetchCount() per ottenere il numero di corsi associati all'aula e restituito direttamente il risultato della condizione numCorsi == 0 come valore booleano.
		System.out.println(numCorsi);
		if(numCorsi==0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Page<AulaResponse> getPage(int pageIndex, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
        Page<Aula> aulaPage = repo.findAll(pageRequest);
		return aulaPage.map(this::entityToDTO);
	}

	private AulaResponse entityToDTO(Aula oAula) {
		return new AulaResponse(oAula.getId(),oAula.getDescrizione(),oAula.getNumeroPosti());
	}

}
