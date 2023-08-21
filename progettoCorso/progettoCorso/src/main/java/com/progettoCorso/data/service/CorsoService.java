package com.progettoCorso.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.progettoCorso.data.dto.Request.CorsoRequest;
import com.progettoCorso.data.dto.Response.CorsoResponse;
import com.progettoCorso.data.dto.Response.StudenteResponse;
@Service
public interface CorsoService {
	public ArrayList<CorsoResponse>getAllCorso();
	public CorsoResponse getCorsoById(Integer idCorso);
	public void saveNewCorso(CorsoRequest oCorsoRequest);
	public void deleteById(Integer idCorso);
	public List<StudenteResponse>getAllPartecipantiResponse(Integer idCorso);
	public Page<CorsoResponse> getPage(int pageIndex, int pageSize);
	public Page<StudenteResponse> getPartecipanti(int id,int pageIndex, int pageSize);
}
