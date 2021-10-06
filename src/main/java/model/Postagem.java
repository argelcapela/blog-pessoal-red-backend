/* Model: Abstração/Classes que representam tabelas no banco de dados. */
package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

@Entity // descreve que a tabela será uma entidade
@Table(name = "tb_postagem") // cria a tabela tb_postagem
public class Postagem {
	// attributes
		@Id		// chave primária
		@GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremente
		private Long idPostagem;
		@NotNull	// não aceita vazio
		@Size(min = 5, max = 100)
		private String titulo;
		@NotNull	// não aceita vazio
		private String texto;
		@NotNull	// não aceita vazio
		private Date data = new java.sql.Date(System.currentTimeMillis()); // pega o horário do sistema no momento do cadastro
		@ManyToOne // cria uma chave estrangeira/ define que essa classe é o muitos da relação. ("uma postagem só pode ter um tema, porém um tema pode ter muitas postagens!")
		@JsonIgnoreProperties("postagem") // evita a recursividade infinita entre postagem e tema!!
		private Tema fk_tema;
	
	// encapsulation
		public Long getIdPostagem() {
			return idPostagem;
		}
		public void setIdPostagem(Long idPostagem) {
			this.idPostagem = idPostagem;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getTexto() {
			return texto;
		}
		public void setTexto(String texto) {
			this.texto = texto;
		}
		public Date getData() {
			return data;
		}
		public void setData(Date data) {
			this.data = data;
		}
		public Tema getTema() {
			return fk_tema;
		}
		public void setTema(Tema tema) {
			this.fk_tema = tema;
		}
	
	
}