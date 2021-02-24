package com.jecesario.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jecesario.gamestore.models.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

}
