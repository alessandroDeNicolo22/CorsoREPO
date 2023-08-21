package com.progettoCorso.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.progettoCorso.data.entity.Corso;

public interface CorsoRepository extends JpaRepository<Corso, Integer> {

	@Query(value="SELECT * FROM Corso ORDER BY IDCorso" , nativeQuery=true)
	Page<Corso> findAll(Pageable pageable);
}
