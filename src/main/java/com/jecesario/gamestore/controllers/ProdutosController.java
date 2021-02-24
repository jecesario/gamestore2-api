package com.jecesario.gamestore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jecesario.gamestore.models.Produtos;
import com.jecesario.gamestore.repositories.ProdutosRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutosRepository repository;

	@GetMapping
	public ResponseEntity<List<Produtos>> list() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping
	public ResponseEntity<Produtos> add(@RequestBody Produtos produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produtos> getById(@PathVariable long id) {
		return repository.findById(id).map(obj -> ResponseEntity.ok(obj)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/buscarDescricao/{descricao}")
	public ResponseEntity<List<Produtos>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PutMapping
	public ResponseEntity<Produtos> update(@RequestBody Produtos produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}

}
