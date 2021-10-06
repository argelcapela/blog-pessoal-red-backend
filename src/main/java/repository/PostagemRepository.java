/*
 * Faz a tradução do SQL para Código Java
*/
package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
}
