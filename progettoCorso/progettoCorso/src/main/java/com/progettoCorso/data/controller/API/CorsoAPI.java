package com.progettoCorso.data.controller.API;

import java.util.ArrayList;
import java.util.List;

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

import com.progettoCorso.data.dto.Request.CorsoRequest;
import com.progettoCorso.data.dto.Response.CorsoResponse;
import com.progettoCorso.data.dto.Response.StudenteResponse;

@RequestMapping(path="/corso")
@CrossOrigin(origins = "http://localhost:4200")
public interface CorsoAPI {
	@GetMapping(path="/list", produces = "application/json")
	public ResponseEntity<ArrayList<CorsoResponse>> getAllCorsi(HttpServletRequest request);

	@GetMapping(path="/findbyid/{id}", produces = "application/json")
	public ResponseEntity<CorsoResponse> findById(HttpServletRequest request, @PathVariable Integer id);

	@PostMapping(path="/save",produces = "application/json",consumes = "application/json")
	public ResponseEntity<?> insert(HttpServletRequest request, @RequestBody CorsoRequest oCorsoRequest);

	@DeleteMapping(path="/delete/{id}",produces = "application/json")
	public ResponseEntity<?> deleteById(HttpServletRequest request, @PathVariable Integer id);
	
	@GetMapping(path="/listapartecipanti/{id}", produces = "application/json")
	public ResponseEntity<List<StudenteResponse>> getAllPartecipantiResponse(HttpServletRequest request, @PathVariable Integer id);

	@GetMapping(path = "/listpage", produces = "application/json")
	public Page<CorsoResponse> getPage(HttpServletRequest request, @RequestParam(defaultValue = "0") int pageIndex, @RequestParam(defaultValue = "3") int pageSize);
	
	@GetMapping(path="/pagePartecipanti/{id}", produces = "application/json")
	public Page<StudenteResponse> getAllPartecipanti(HttpServletRequest request, @PathVariable Integer id,@RequestParam(defaultValue = "0") int pageIndex, @RequestParam(defaultValue = "3") int pageSize);
}
