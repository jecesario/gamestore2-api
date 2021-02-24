package com.jecesario.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jecesario.gamestore.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

}
