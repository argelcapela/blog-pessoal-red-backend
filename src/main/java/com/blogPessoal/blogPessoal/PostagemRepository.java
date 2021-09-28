package com.blogPessoal.blogPessoal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
}
