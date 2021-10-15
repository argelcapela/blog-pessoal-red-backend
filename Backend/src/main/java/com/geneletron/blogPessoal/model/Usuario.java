package com.geneletron.blogPessoal.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity 
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idUsuario;
	@NotNull
	@Size(min = 5, max = 100)
	private String nomeCompleto;
	@NotNull
	@Size(min = 5, max = 100)
	private String login;
	@NotNull
	@Size(min = 5, max = 100)
	private String senhaUsuario;
	@NotNull
	private String emailUsuario;
	@NotNull
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "fk_usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("fk_tema")
	private List<Postagem> postagens; 
	
	
	
	
	public Usuario(long idUsuario, @Size(min = 5, max = 100) String nomeCompleto,
			@Size(min = 5, max = 100) String login, @Size(min = 5, max = 100) String senhaUsuario, String emailUsuario,
			Date dataNascimento, List<Postagem> postagens) {
		super();
		this.idUsuario = idUsuario;
		this.nomeCompleto = nomeCompleto;
		this.login = login;
		this.senhaUsuario = senhaUsuario;
		this.emailUsuario = emailUsuario;
		this.dataNascimento = dataNascimento;
		this.postagens = postagens;
	}
	
	public Usuario()
	{
			
	}
	
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
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
	
	
}
