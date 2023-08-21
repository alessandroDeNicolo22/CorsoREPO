package com.progettoCorso.data.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.progettoCorso.data.dto.Request.DocenteRequest;
import com.progettoCorso.data.dto.Response.DocenteResponse;
import com.progettoCorso.data.entity.Docente;
import com.progettoCorso.data.repository.DocenteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class DocenteServiceImpl implements DocenteService{

	@Autowired
	DocenteRepository repo;

	@Override
	public ArrayList<DocenteResponse> getAllDocenti() {
		ArrayList<Docente> elenco = (ArrayList<Docente>) repo.findAll();
		return elenco.stream()
				.map(docente -> new DocenteResponse(docente.getId(), docente.getNome(), docente.getCognome()))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public DocenteResponse findById(Integer id) {
		Docente oDocente = repo.findById(id).orElse(null);
		return new DocenteResponse(oDocente.getId(),oDocente.getCognome(),oDocente.getNome());
	}

	@Override
	public void saveDocente(DocenteRequest oDocenteRequest) {
		repo.save(new Docente(oDocenteRequest.getId(),oDocenteRequest.getNome(),oDocenteRequest.getCognome()));
	}

	@Override
	public void deleteDocente(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Boolean checkElimina(Integer id) {
		if(repo.nDocenti(id)==0) {
			return true;
		}else {
			return false;
		}

	}

	@Override
	public Page<DocenteResponse> getPage(int pageIndex, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
		Page<Docente> docentePage = repo.findAll(pageRequest);
		return docentePage.map(this::entityToDTO);
	}

	private DocenteResponse entityToDTO(Docente oDocente) {
		return new DocenteResponse(oDocente.getId(),
				oDocente.getCognome(),
				oDocente.getNome());
	}

}
