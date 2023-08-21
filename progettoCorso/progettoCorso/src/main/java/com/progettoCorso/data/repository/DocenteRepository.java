package com.progettoCorso.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.progettoCorso.data.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

	@Query(value="SELECT COUNT(*) FROM Corso WHERE IDDocente = ?1", nativeQuery=true)
    Integer nDocenti(Integer id);
	
	@Query(value="SELECT * FROM Docente ORDER BY IDDocente" , nativeQuery=true)
	Page<Docente> findAll(Pageable pageable);
	
}
