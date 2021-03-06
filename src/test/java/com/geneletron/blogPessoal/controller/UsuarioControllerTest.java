package com.geneletron.blogPessoal.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.argelcapela.blog_pessoal_red_backend.model.Usuario;
import com.argelcapela.blog_pessoal_red_backend.repository.UsuarioRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private Usuario usuario;
	private Usuario usuarioUpdate;
	private Usuario usuarioAdmin;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	public void start() {
		LocalDate data = LocalDate.parse("2000-09-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		usuarioAdmin = new Usuario(0L, "admin", "admin", "admin", "admin@gmail.com", data);
	
		if (!usuarioRepository.findByLogin(usuarioAdmin.getLogin()).isPresent())
		{
			HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuarioAdmin);
			testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, request, Usuario.class);
		}
		
		usuario = new Usuario(0L, "jesus", "jesus", "jesus", "jesus@gmail.com", data);
		usuarioUpdate = new Usuario(2L, "jesus cristo", "jesus", "jesus", "jesus@gmail.com", data);
	}
	
	@Test
	@Order(1)
	@DisplayName("??? Cadastrar Usu??rio!")
	public void deveRealizarPostUsuario() {
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, request, Usuario.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	@Test
	@Order(2)
	@DisplayName("???? Listar todos os Usu??rios!")
	public void deveMostrarTodosOsUsuarios() {
		ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("admin", "admin").exchange("/usuarios", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Test
	@Order(3)
	@DisplayName("???? Alterar Usu??rio!")
	public void deveRealizarPutUsuario() {
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuarioUpdate);
		ResponseEntity<Usuario> resposta = testRestTemplate.withBasicAuth("admin", "admin").exchange("/usuarios/atualizar", HttpMethod.PUT, request, Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
}
