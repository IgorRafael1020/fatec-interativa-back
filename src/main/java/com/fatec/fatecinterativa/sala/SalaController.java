package com.fatec.fatecinterativa.sala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fatec.fatecinterativa.sala.Sala;
import com.fatec.fatecinterativa.sala.SalaRepository;

public class SalaController {
	
	@Autowired
	private SalaRepository salaRepository;
	
	@GetMapping
	public List<Sala> findAll() {
		return salaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sala> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(salaRepository.findById(id).get());
	}
	
	@GetMapping()
	public List<Sala> findBySala() {
		return salaRepository.findAll();
	}
	
	@GetMapping()
	public List<Sala> findByProfessor() {
		return salaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Sala> insert(@RequestBody Sala sala) throws Exception{
		try {
			return ResponseEntity.ok().body(salaRepository.save(sala));
			
		} catch (Exception e) {
			throw new Exception("Erro cadastrar Sala. Causa do erro: " + e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<Boolean> update(@RequestBody Sala sala) throws Exception{
		try {
			if(salaRepository.findById(sala.getIdSala()).isEmpty()){
				return ResponseEntity.ok().body(false);
			}
			else {
				salaRepository.save(sala);
				return ResponseEntity.ok().body(true);
			}
		} catch(Exception e) {
			throw new Exception("Erro editar Sala. Causa do erro: " + e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) throws Exception {
		try {
			if(salaRepository.findById(id).isEmpty()){
				return ResponseEntity.ok().body(false);
			}
			else {
				salaRepository.deleteById(id);
				return ResponseEntity.ok().body(true);
			}
		} catch (Exception e) {
			throw new Exception("Erro deletar Sala. Causa do erro: " + e.getMessage());
		}
	}
	
}
