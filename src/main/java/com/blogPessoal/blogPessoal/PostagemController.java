package com.blogPessoal.blogPessoal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
		private PostagemRepository r;
	
	// PEGA TUDO -  select * from tb_postagem
		@GetMapping
		public ResponseEntity<List<Postagem>> GetAll(Long idPostagem)
		{
			return ResponseEntity.ok(r.findAll());
		}
	
	// PEGAR PELO ID - select * from tb_postagem where idPostagem=<id>
		@GetMapping("/{id}")
		public ResponseEntity<Postagem> GetById(@PathVariable long id)
		{
			return r.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
	
	// PEGAR PELO TÍTULO -  select * from tb_postagem where titutoPostagem like "%<titulo>%"
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<Postagem>> GetByTitle(@PathVariable String titulo)
		{
			return ResponseEntity.ok(r.findAllByTituloContainingIgnoreCase(titulo));
		}
	
	// INSERIR - insert into tb_postagem (titulo, texto) values (<titulo>, <texto>)
		@PostMapping
		public ResponseEntity<Postagem> post (@RequestBody Postagem postagem)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(r.save(postagem));
		}
	
	// ATUALIZAR - update tb_postagem set titulo=<titulo>, texto=<texto>  where idPostagem = <id>
		@PutMapping
		public ResponseEntity<Postagem> atualizaPost(@RequestBody Postagem postagem)
		{
			return ResponseEntity.status(HttpStatus.OK).body(r.save(postagem));
		}
	
	// DELETAR - delete from tb_postagem where idPostagem = <id>
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id)
		{
			r.deleteById(id);
		}
	
}
