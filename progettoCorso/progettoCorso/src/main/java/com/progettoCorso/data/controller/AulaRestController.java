package com.progettoCorso.data.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.progettoCorso.data.controller.API.AulaApi.AulaAPI;
import com.progettoCorso.data.dto.Request.AulaRequest;
import com.progettoCorso.data.dto.Response.AulaResponse;
import com.progettoCorso.data.service.AulaService;

@RestController
public class AulaRestController implements AulaAPI{

	@Autowired
	AulaService service;

	@Override
	public ResponseEntity<ArrayList<AulaResponse>> getAllAula(HttpServletRequest request) {
		return new ResponseEntity<ArrayList<AulaResponse>>(service.getAllAule(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<AulaResponse> findById(HttpServletRequest request, Integer id) {
		return new ResponseEntity<AulaResponse>(service.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> insertUpdate(HttpServletRequest request, AulaRequest oAulaReq) {
		service.saveAula(oAulaReq);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteById(HttpServletRequest request, Integer id) {
		service.deleteAula(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Boolean> checkById(HttpServletRequest request, Integer id) {
		return new ResponseEntity<Boolean>(service.checkAula(id),HttpStatus.OK);
	}

	@Override
	public Page<AulaResponse> getPage(HttpServletRequest request, int pageIndex, int pageSize) {	
		return service.getPage(pageIndex, pageSize);
	}

}
