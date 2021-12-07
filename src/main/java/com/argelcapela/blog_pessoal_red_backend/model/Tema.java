/* Model: Abstração/Classes que representam tabelas no banco de dados. */
package com.argelcapela.blog_pessoal_red_backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity // define que a classe é uma entidade
@Table(name = "tb_tema")  // cria tabela tb_tema
public class Tema {

	@Id // chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//  auto incremente
	private long codTema;
	
	@NotNull // não permite vazio
	private String descricao;
	
	@OneToMany(mappedBy = "fk_tema", cascade = CascadeType.ALL) // lado um da relação // define uma relação de 1 para muitos.// 1 tema para muitas postagens  
	@JsonIgnoreProperties("fk_tema") // evita a recursividade infinita
	private List<Postagem> postagens;

	
	
	public Tema() {
		
	}

	public long getCodTema() {
		return codTema;
	}

	public void setCodTema(long codTema) {
		this.codTema = codTema;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	
	
}
