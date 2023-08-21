package com.progettoCorso.data.service;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.progettoCorso.data.dto.Request.DocenteRequest;
import com.progettoCorso.data.dto.Response.DocenteResponse;

@Service
public interface DocenteService {
	public ArrayList<DocenteResponse> getAllDocenti();
	public DocenteResponse findById(Integer id);
	public void saveDocente (DocenteRequest oDocenteRequest);
	public void deleteDocente (Integer id);
	public Boolean checkElimina(Integer id);
	public Page<DocenteResponse> getPage(int pageIndex, int pageSize);
}
