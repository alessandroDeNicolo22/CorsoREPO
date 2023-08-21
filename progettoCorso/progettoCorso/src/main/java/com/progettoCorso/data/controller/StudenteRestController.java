package com.progettoCorso.data.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.progettoCorso.data.controller.API.StudenteAPI;
import com.progettoCorso.data.dto.Request.StudenteRequest;
import com.progettoCorso.data.dto.Response.StudenteResponse;
import com.progettoCorso.data.service.StudenteService;

@RestController
public class StudenteRestController implements StudenteAPI{
	@Autowired
	StudenteService service;

	@Override
	public ResponseEntity<ArrayList<StudenteResponse>> getAllStudenti(HttpServletRequest request) {
		return new ResponseEntity<ArrayList<StudenteResponse>>(service.getAllStudenti(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudenteResponse> findById(HttpServletRequest request, Integer id) {
		return new ResponseEntity<StudenteResponse>(service.findById(id),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> insertUpdate(HttpServletRequest request, StudenteRequest oStudenteRequest) {
		service.saveStudente(oStudenteRequest);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteById(HttpServletRequest request, Integer id) {
		service.deleteStudente(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Boolean> checkById(HttpServletRequest request, Integer id) {
		return ResponseEntity.ok(service.checkElimina(id));
	}

	@Override
	public Page<StudenteResponse> getPage(HttpServletRequest request, int pageIndex, int pageSize) {
		return service.getPage(pageIndex, pageSize);
	}

	@Override
	public ResponseEntity<List<StudenteResponse>> getStudentiByID(HttpServletRequest request) {
		return ResponseEntity.ok(service.getStudentiByID());
	}

}
