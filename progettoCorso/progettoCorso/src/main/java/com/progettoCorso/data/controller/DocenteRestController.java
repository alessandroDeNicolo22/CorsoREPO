package com.progettoCorso.data.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.progettoCorso.data.controller.API.DocenteAPI;
import com.progettoCorso.data.dto.Request.DocenteRequest;
import com.progettoCorso.data.dto.Response.DocenteResponse;
import com.progettoCorso.data.service.DocenteService;
@RestController
public class DocenteRestController implements DocenteAPI{
	@Autowired
	DocenteService service;

	@Override
	public ResponseEntity<ArrayList<DocenteResponse>> getAllDocenti(HttpServletRequest request) {
		return new ResponseEntity<ArrayList<DocenteResponse>>(service.getAllDocenti(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<DocenteResponse> findById(HttpServletRequest request, Integer id) {
		return new ResponseEntity<DocenteResponse>(service.findById(id),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> insertUpdate(HttpServletRequest request, DocenteRequest oDocenteRequest) {
		service.saveDocente(oDocenteRequest);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteById(HttpServletRequest request, Integer id) {
		service.deleteDocente(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Boolean> checkById(HttpServletRequest request, Integer id) {
		return ResponseEntity.ok(service.checkElimina(id));
//		return  new ResponseEntity<Boolean>(,HttpStatus.OK);
	}

	@Override
	public Page<DocenteResponse> getPage(HttpServletRequest request, int pageIndex, int pageSize) {
		return service.getPage(pageIndex, pageSize);
	}

}
