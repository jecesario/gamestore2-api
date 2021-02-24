package com.jecesario.gamestore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
