package com.jecesario.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jecesario.gamestore.models.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	public Usuarios findByNomeContainingIgnoreCase(String nome);
}
