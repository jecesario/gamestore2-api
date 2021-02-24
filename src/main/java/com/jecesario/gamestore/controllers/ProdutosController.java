package com.jecesario.gamestore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<List<Produtos>> list () {
		return ResponseEntity.ok(repository.findAll());
	}
}
