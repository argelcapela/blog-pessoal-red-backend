package com.geneletron.blogPessoal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idUsuario;
	@NotBlank
	@Size(min = 5, max = 100)
	private String nomeCompleto;
	@NotBlank
	@Size(min = 5, max = 100)
	private String login;
	@NotBlank
	@Size(min = 5, max = 100)
	private String senhaUsuario;
	@NotBlank
	@Email
	private String emailUsuario;
	//@NotNull
	private LocalDate dataNascimento;
	
	private String foto;
	
	private String tipo;
	
	// RELACIONAMENTO PARA USUÁRIO TER MINHAS POSTAGENS
	@OneToMany(mappedBy = "fk_usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("fk_usuario")
	private List<Postagem> postagens; 
	
	public Usuario(long idUsuario,  String nomeCompleto, String login,  String senhaUsuario, String emailUsuario, LocalDate dataNascimento) {
		this.idUsuario = idUsuario;
		this.nomeCompleto = nomeCompleto;
		this.login = login;
		this.senhaUsuario = senhaUsuario;
		this.emailUsuario = emailUsuario;
		this.dataNascimento = dataNascimento;
	}
	
	public Usuario(){}
	
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
		
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}
	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
