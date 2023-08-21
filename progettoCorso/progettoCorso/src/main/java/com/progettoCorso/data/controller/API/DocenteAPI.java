package com.progettoCorso.data.controller.API;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.progettoCorso.data.dto.Request.DocenteRequest;
import com.progettoCorso.data.dto.Response.DocenteResponse;

@RequestMapping(path="/docente")
@CrossOrigin(origins = "http://localhost:4200")
public interface DocenteAPI {
	@GetMapping(path="/list",produces = "application/json")
	public ResponseEntity<ArrayList<DocenteResponse>> getAllDocenti(HttpServletRequest request);

	@GetMapping(path="/findbyid/{id}",produces = "application/json")
	public ResponseEntity<DocenteResponse> findById(HttpServletRequest request,@PathVariable Integer id);

	@PostMapping(path="/save",produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> insertUpdate(HttpServletRequest request, @RequestBody DocenteRequest oDocenteRequest);

	@DeleteMapping(path="/delete/{id}",produces = "application/json")
	public ResponseEntity<?> deleteById(HttpServletRequest request,@PathVariable Integer id);
	
	@GetMapping(path="/check/{id}",produces = "application/json")
	public ResponseEntity<Boolean> checkById(HttpServletRequest request,@PathVariable Integer id);
	
	@GetMapping(path = "/listpage", produces = "application/json")
	public Page<DocenteResponse> getPage(HttpServletRequest request, @RequestParam(defaultValue = "0") int pageIndex, @RequestParam(defaultValue = "3") int pageSize);
}
