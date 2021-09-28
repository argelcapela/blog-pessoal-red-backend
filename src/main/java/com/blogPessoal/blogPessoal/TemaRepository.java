package com.blogPessoal.blogPessoal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {
	
	List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
