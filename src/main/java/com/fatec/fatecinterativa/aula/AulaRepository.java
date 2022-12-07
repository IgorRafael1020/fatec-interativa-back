package com.fatec.fatecinterativa.aula;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AulaRepository extends JpaRepository<Aula, Integer> {

	@Query(value = "SELECT * FROM AULA a INNER JOIN SALA s on a.id_sala = s.id_sala WHERE a.id_sala = :idSala ORDER BY a.horario", nativeQuery = true)
	List<Aula> findBySala(Integer idSala);
}
