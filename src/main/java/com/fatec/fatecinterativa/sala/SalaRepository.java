package com.fatec.fatecinterativa.sala;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fatec.fatecinterativa.aula.Aula;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
	
	@Query(value = "SELECT * FROM SALA s WHERE s.id_predio = :idPredio ORDER BY s.id_sala", nativeQuery = true)
	List<Sala> findByPredio(Integer idPredio);
}
