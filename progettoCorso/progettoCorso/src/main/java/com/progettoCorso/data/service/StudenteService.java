package com.progettoCorso.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.progettoCorso.data.dto.Request.StudenteRequest;
import com.progettoCorso.data.dto.Response.StudenteResponse;

@Service
public interface StudenteService {
	public ArrayList<StudenteResponse> getAllStudenti();
	public StudenteResponse findById(Integer id);
	public void saveStudente (StudenteRequest oRequest);
	public void deleteStudente (Integer id);
	public Boolean checkElimina(Integer id);
	public Page<StudenteResponse>getPage(int pageIndex, int pageSize);
	public List<StudenteResponse> getStudentiByID();
}
