package com.progettoCorso.data.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.progettoCorso.data.dto.Request.AulaRequest;
import com.progettoCorso.data.dto.Response.AulaResponse;
import com.progettoCorso.data.entity.Aula;
import com.progettoCorso.data.repository.AulaRepository;
@Service
@Transactional
public class AulaServiceImpl implements AulaService{

	@Autowired
	AulaRepository repo;

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
		System.out.println(repo.nAule(id));
		if(repo.nAule(id)==0) {
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
