package com.geneletron.blogPessoal.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geneletron.blogPessoal.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {
	
	List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
