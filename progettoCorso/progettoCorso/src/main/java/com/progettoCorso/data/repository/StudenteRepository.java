package com.progettoCorso.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.progettoCorso.data.entity.Studente;


public interface StudenteRepository extends JpaRepository<Studente, Integer>{
	
	@Query(value="SELECT COUNT(*) FROM Corsodiscente WHERE IDDiscente = ?1", nativeQuery=true)
    Integer nStudenti(Integer id);
	
	@Query(value="SELECT * FROM Discente ORDER BY IDDiscente" , nativeQuery=true)
	Page<Studente> findAll(Pageable pageable);
}
