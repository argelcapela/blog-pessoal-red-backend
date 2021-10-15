/*
 * Faz a tradução do SQL para Código Java
*/
package com.geneletron.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geneletron.blogPessoal.model.Postagem;



@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
}
