package com.geneletron.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.argelcapela.blog_pessoal_red_backend.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {
	
	private Usuario usuario;
	private Usuario usuarioNulo = new Usuario();
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	Validator validator = factory.getValidator();
	
	@BeforeEach
	public void start() {
		LocalDate data = LocalDate.parse("2000-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		usuario = new Usuario(0L, "jesus", "jesus", "jesus", "jesus@gmail.com", data);
	}
	
	@Test
	@DisplayName("✔ Verdadeiro se, nenhum valor nulo ou vazio, tamanho respeitado e formato e-mail respeitado!")
	void testeValidaAtributos() {
		
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);
		System.out.println(violacao.toString());
		
		assertTrue(violacao.isEmpty());
	}
	
	@Test
	@DisplayName("❌ Falso se, algum valor for nulo ou vazio.")
	void testeNaoValidaAtributos() {
		
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuarioNulo);
		System.out.println(violacao.toString());
		
		assertTrue(violacao.isEmpty());
	}
	
	
}
