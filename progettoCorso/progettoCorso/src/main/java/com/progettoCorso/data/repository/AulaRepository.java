package com.progettoCorso.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.progettoCorso.data.entity.Aula;

public interface AulaRepository extends JpaRepository<Aula, Integer>{

	@Query(value="SELECT COUNT(*) FROM Corso WHERE IDAula = ?1", nativeQuery=true)
    Integer nAule(Integer id);
	
	@Query(value="SELECT * FROM AULA ORDER BY IDAula" , nativeQuery=true)
	Page<Aula> findAll(Pageable pageable);
}
