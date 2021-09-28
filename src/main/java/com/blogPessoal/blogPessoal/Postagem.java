package com.blogPessoal.blogPessoal;

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

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	// attributes
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idPostagem;
		@NotNull
		@Size(min = 5, max = 100)
		private String titulo;
		@NotNull
		private String texto;
		@NotNull
		private Date data = new java.sql.Date(System.currentTimeMillis());
		@ManyToOne
		@JsonIgnoreProperties("postagem")
		private Tema tema;
	
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
			return tema;
		}
		public void setTema(Tema tema) {
			this.tema = tema;
		}
	
	
}
