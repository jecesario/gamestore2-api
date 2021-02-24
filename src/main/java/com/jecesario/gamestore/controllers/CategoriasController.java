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

import com.jecesario.gamestore.models.Categorias;
import com.jecesario.gamestore.repositories.CategoriasRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/categorias")
public class CategoriasController {

	@Autowired
	private CategoriasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> list() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Categorias> add (@RequestBody Categorias categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
}
