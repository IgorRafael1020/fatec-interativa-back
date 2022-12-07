package com.fatec.fatecinterativa.predio;

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

import com.fatec.fatecinterativa.predio.Predio;
import com.fatec.fatecinterativa.predio.PredioRepository;

@RestController
@RequestMapping("/predio")
public class PredioController {

	@Autowired
	private PredioRepository predioRepository;
	
	@GetMapping
	public List<Predio> findAll() {
		return predioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Predio> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(predioRepository.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<Predio> insert(@RequestBody Predio predio) throws Exception{
		try {
			return ResponseEntity.ok().body(predioRepository.save(predio));
			
		} catch (Exception e) {
			throw new Exception("Erro cadastrar Predio. Causa do erro: " + e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<Boolean> update(@RequestBody Predio predio) throws Exception{
		try {
			if(predioRepository.findById(predio.getIdPredio()).isEmpty()){
				return ResponseEntity.ok().body(false);
			}
			else {
				predioRepository.save(predio);
				return ResponseEntity.ok().body(true);
			}
		} catch(Exception e) {
			throw new Exception("Erro editar Predio. Causa do erro: " + e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) throws Exception {
		try {
			if(predioRepository.findById(id).isEmpty()){
				return ResponseEntity.ok().body(false);
			}
			else {
				predioRepository.deleteById(id);
				return ResponseEntity.ok().body(true);
			}
		} catch (Exception e) {
			throw new Exception("Erro deletar Predio. Causa do erro: " + e.getMessage());
		}
	}
	
}
