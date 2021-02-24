package com.jecesario.gamestore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jecesario.gamestore.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	public List<Produtos> findAllByDescricaoContainingIgnoreCase(String descricao);
}
