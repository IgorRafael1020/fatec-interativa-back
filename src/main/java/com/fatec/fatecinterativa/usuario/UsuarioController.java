package com.fatec.fatecinterativa.usuario;

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

import com.fatec.fatecinterativa.usuario.Usuario;
import com.fatec.fatecinterativa.usuario.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(usuarioRepository.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) throws Exception{
		try {
			return ResponseEntity.ok().body(usuarioRepository.save(usuario));
			
		} catch (Exception e) {
			throw new Exception("Erro cadastrar Usuario. Causa do erro: " + e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<Boolean> update(@RequestBody Usuario usuario) throws Exception{
		try {
			if(usuarioRepository.findById(usuario.getIdUsuario()).isEmpty()){
				return ResponseEntity.ok().body(false);
			}
			else {
				usuarioRepository.save(usuario);
				return ResponseEntity.ok().body(true);
			}
		} catch(Exception e) {
			throw new Exception("Erro editar Usuario. Causa do erro: " + e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) throws Exception {
		try {
			if(usuarioRepository.findById(id).isEmpty()){
				return ResponseEntity.ok().body(false);
			}
			else {
				usuarioRepository.deleteById(id);
				return ResponseEntity.ok().body(true);
			}
		} catch (Exception e) {
			throw new Exception("Erro deletar Usuario. Causa do erro: " + e.getMessage());
		}
	}
	
}
