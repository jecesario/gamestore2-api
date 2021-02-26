package com.jecesario.gamestore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jecesario.gamestore.models.Usuarios;
import com.jecesario.gamestore.repositories.UsuariosRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuariosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> list() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Usuarios> add (@RequestBody Usuarios usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> getById(@PathVariable long id) {
		return repository.findById(id).map(obj -> ResponseEntity.ok(obj)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Usuarios> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(nome));
	}

}
