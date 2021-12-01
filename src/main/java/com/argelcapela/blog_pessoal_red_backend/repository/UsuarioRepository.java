package com.argelcapela.blog_pessoal_red_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.argelcapela.blog_pessoal_red_backend.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> 
{
	public Optional<Usuario> findByLogin(String login);
	
	public List<Usuario> findByNomeCompletoContainingIgnoreCase(String nomeCompleto);
	
	public Usuario findByNomeCompleto(String nomeCompleto);
	
}
