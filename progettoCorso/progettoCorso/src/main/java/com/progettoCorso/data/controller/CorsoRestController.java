package com.progettoCorso.data.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.progettoCorso.data.controller.API.CorsoAPI;
import com.progettoCorso.data.dto.Request.CorsoRequest;
import com.progettoCorso.data.dto.Response.CorsoResponse;
import com.progettoCorso.data.dto.Response.StudenteResponse;
import com.progettoCorso.data.service.CorsoService;
@RestController
public class CorsoRestController implements CorsoAPI{

	@Autowired
	CorsoService service;

	@Override
	public ResponseEntity<ArrayList<CorsoResponse>> getAllCorsi(HttpServletRequest request) {
		return ResponseEntity.ok(service.getAllCorso());
	}

	@Override
	public ResponseEntity<CorsoResponse> findById(HttpServletRequest request, Integer id) {
		return ResponseEntity.ok(service.getCorsoById(id));
	}

	@Override
	public ResponseEntity<?> insert(HttpServletRequest request, CorsoRequest oCorsoRequest) {
		service.saveNewCorso(oCorsoRequest);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}


	@Override
	public ResponseEntity<?> deleteById(HttpServletRequest request, Integer id) {
		service.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<StudenteResponse>> getAllPartecipantiResponse(HttpServletRequest request, Integer id) {
		return ResponseEntity.ok(service.getAllPartecipantiResponse(id));
	}

	@Override
	public Page<CorsoResponse> getPage(HttpServletRequest request, int pageIndex, int pageSize) {
		return service.getPage(pageIndex, pageSize);
	}

	@Override
	public Page<StudenteResponse> getAllPartecipanti(HttpServletRequest request, Integer id, int pageIndex,
			int pageSize) {
		return service.getPartecipanti(id, pageIndex, pageSize);
	}

}
