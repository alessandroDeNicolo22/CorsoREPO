package com.progettoCorso.data.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.progettoCorso.data.dto.Request.StudenteRequest;
import com.progettoCorso.data.dto.Response.StudenteResponse;
import com.progettoCorso.data.entity.Studente;
import com.progettoCorso.data.repository.StudenteRepository;
@Service
@Transactional
public class StudenteServiceImpl implements StudenteService{

	@Autowired
	StudenteRepository repo;

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

}
