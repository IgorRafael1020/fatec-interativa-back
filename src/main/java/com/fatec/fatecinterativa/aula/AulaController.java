package com.fatec.fatecinterativa.aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aula")
public class AulaController {

	@Autowired
	private AulaRepository aulaRepository;
	
	@GetMapping
	public List<Aula> findAll() {
		return aulaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aula> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(aulaRepository.findById(id).get());
	}
	
	@GetMapping("/sala/{idSala}")
	public List<Aula> findBySala(@PathVariable Integer idSala) {
		return aulaRepository.findBySala(idSala);
	}
	
	@GetMapping("/professor")
	public List<Aula> findByProfessor() {
		return aulaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Aula> insert(@RequestBody Aula aula) throws Exception{
		try {
			return ResponseEntity.ok().body(aulaRepository.save(aula));
			
		} catch (Exception e) {
			throw new Exception("Erro cadastrar Aula. Causa do erro: " + e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<Boolean> update(@RequestBody Aula aula) throws Exception{
		try {
			if(aulaRepository.findById(aula.getIdAula()).isEmpty()){
				return ResponseEntity.ok().body(false);
			}
			else {
				aulaRepository.save(aula);
				return ResponseEntity.ok().body(true);
			}
		} catch(Exception e) {
			throw new Exception("Erro editar Aula. Causa do erro: " + e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) throws Exception {
		try {
			if(aulaRepository.findById(id).isEmpty()){
				return ResponseEntity.ok().body(false);
			}
			else {
				aulaRepository.deleteById(id);
				return ResponseEntity.ok().body(true);
			}
		} catch (Exception e) {
			throw new Exception("Erro deletar Aula. Causa do erro: " + e.getMessage());
		}
	}
	
}
