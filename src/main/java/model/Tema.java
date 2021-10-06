/* Model: Abstração/Classes que representam tabelas no banco de dados. */
package model;

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
	@JsonIgnoreProperties("tema") // evita a recursividade infinita
	private List<Postagem> postagem;

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

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}
