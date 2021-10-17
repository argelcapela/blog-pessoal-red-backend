package com.geneletron.blogPessoal.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.geneletron.blogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	@Autowired
		private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		LocalDate data = LocalDate.parse("2000-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));				
		Usuario usuario = new Usuario(0L, "pedro", "pedro", "pedro","pedro@gmail.com", data);		
		if (!usuarioRepository.findByLogin(usuario.getLogin()).isPresent())
				usuarioRepository.save(usuario);
		
		usuario = new Usuario(0L, "joãoa", "joãoa", "joãoa","joãoa@gmail.com", data);		
		if (!usuarioRepository.findByLogin(usuario.getLogin()).isPresent())
				usuarioRepository.save(usuario);
		
		usuario = new Usuario(0L, "jesus", "jesus", "jesus","jesus@gmail.com", data);		
		if (!usuarioRepository.findByLogin(usuario.getLogin()).isPresent())
				usuarioRepository.save(usuario);
		
		
		usuario = new Usuario(0L, "thiago", "thiago", "thiago","thiago@gmail.com", data);		
		if (!usuarioRepository.findByLogin(usuario.getLogin()).isPresent())
				usuarioRepository.save(usuario);		

	}
	
	@Test
	@DisplayName ("Retorna o nome!")
	void findByLoginTest() throws Exception {
		Usuario usuario = usuarioRepository.findByNomeCompleto("pedro2");
		assertTrue(usuario.getLogin().equals("pedro"));
	}
	
	@Test
	@DisplayName ("Retorna 3 nomes!")
	void findByNomeCompletoContainingIgnoreCaseRetornaTresUsuario() throws Exception{
		List<Usuario> usuarios = usuarioRepository.findByNomeCompletoContainingIgnoreCase("j");
		assertEquals(3, usuarios.size());
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
}
