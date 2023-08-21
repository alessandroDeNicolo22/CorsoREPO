package com.progettoCorso.data.service;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.progettoCorso.data.dto.Request.AulaRequest;
import com.progettoCorso.data.dto.Response.AulaResponse;

@Service
public interface AulaService {
	public ArrayList<AulaResponse> getAllAule();
	public AulaResponse findById(Integer id);
	public void saveAula(AulaRequest oAulaRequest);
	public void deleteAula(Integer id);
	public Boolean checkAula(Integer id);
	public Page<AulaResponse> getPage(int pageIndex, int pageSize);
}
