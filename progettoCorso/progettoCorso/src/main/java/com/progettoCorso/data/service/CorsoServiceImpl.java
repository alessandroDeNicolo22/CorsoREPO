package com.progettoCorso.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.progettoCorso.data.dto.Request.CorsoRequest;
import com.progettoCorso.data.dto.Response.CorsoResponse;
import com.progettoCorso.data.dto.Response.StudenteResponse;
import com.progettoCorso.data.entity.Corso;
import com.progettoCorso.data.entity.Studente;
import com.progettoCorso.data.repository.CorsoRepository;
import org.springframework.data.domain.PageImpl;
@Service
@Transactional
public class CorsoServiceImpl implements CorsoService{

	@Autowired
	CorsoRepository repo;

	@Override
	public ArrayList<CorsoResponse> getAllCorso() {
		ArrayList<Corso> elenco = (ArrayList<Corso>) repo.findAll();
		return elenco.stream().map(corso->new CorsoResponse(
				corso.getId(),
				corso.getCorso(),
				corso.getODocente(),
				corso.getOAula(),
				corso.getDurata(),
				corso.getDataInizio(),
				corso.getPartecipanti())).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public CorsoResponse getCorsoById(Integer idCorso) {
		Corso oCorso = repo.findById(idCorso).get();
		return new CorsoResponse(
				oCorso.getId(),
				oCorso.getCorso(),
				oCorso.getODocente(),
				oCorso.getOAula(),
				oCorso.getDurata(),
				oCorso.getDataInizio(),
				oCorso.getPartecipanti());
	}

	@Override
	public void saveNewCorso(CorsoRequest oCorsoRequest) {
		repo.save(new Corso(
				oCorsoRequest.getId(),
				oCorsoRequest.getCorso(),
				oCorsoRequest.getDurata(),
				oCorsoRequest.getODocente(),
				oCorsoRequest.getOAula(),
				oCorsoRequest.getDataInizio(),
				oCorsoRequest.getPartecipanti()));
	}


	@Override
	public List<StudenteResponse> getAllPartecipantiResponse(Integer idCorso) {
		return repo.findById(idCorso).
				get().
				getPartecipanti().
				stream().
				map(studente->new StudenteResponse(
				studente.getId(),
				studente.getCognome(),
				studente.getNome(),
				studente.getMatricola())).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public void deleteById(Integer idCorso) {
    repo.deleteById(idCorso);
	}

	@Override
	public Page<CorsoResponse> getPage(int pageIndex, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
        Page<Corso> corsoPage = repo.findAll(pageRequest);
		return corsoPage.map(this::entityToDTO);
	}

	private CorsoResponse entityToDTO(Corso corso) {
		return new CorsoResponse(corso.getId(),
				corso.getCorso(),
				corso.getODocente(),
				corso.getOAula(),
				corso.getDurata(),
				corso.getDataInizio(),
				corso.getPartecipanti());
	}

	@Override
	public Page<StudenteResponse> getPartecipanti(int id, int pageIndex, int pageSize) {
	    PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
	    List<Studente> partecipanti = repo.findById(id).get().getPartecipanti();
	    ArrayList<StudenteResponse> elencoResponse = partecipanti.stream().map(studente->new StudenteResponse(studente.getId(), 
	    studente.getCognome(), studente.getNome(), studente.getMatricola())).collect(Collectors.toCollection(ArrayList::new));
	    
	    int startIndex = pageIndex * pageSize;
	    if (startIndex >= elencoResponse.size()) {
	        return Page.empty(); 
	    }
	    int endIndex = Math.min(startIndex + pageSize, partecipanti.size());

	    List<StudenteResponse> pageItems = elencoResponse.subList(startIndex, endIndex);

	    return new PageImpl<>(pageItems, pageRequest, elencoResponse.size());
	}

	}
	
