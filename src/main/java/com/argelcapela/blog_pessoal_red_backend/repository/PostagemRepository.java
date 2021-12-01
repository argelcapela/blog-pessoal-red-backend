/*
 * Faz a tradução do SQL para Código Java
*/
package com.argelcapela.blog_pessoal_red_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.argelcapela.blog_pessoal_red_backend.model.Postagem;



@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
}
