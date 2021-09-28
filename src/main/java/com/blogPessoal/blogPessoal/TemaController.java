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
@RequestMapping("/temas")
@CrossOrigin("*")
public class TemaController {
	@Autowired
		private TemaRepository r;
	
	@GetMapping
	public ResponseEntity<List<Tema>> PegarTudo(Long id)
	{
		return ResponseEntity.ok(r.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> PegarTudoPeloId (@PathVariable long id)
	{
		return r.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> PegarPelaDescricao (@PathVariable String descricao)
	{
		return ResponseEntity
				.ok(r.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Tema> insereTema(@RequestBody Tema tema)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(r.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> atualizaTema(@RequestBody Tema tema)
	{
		return ResponseEntity.status(HttpStatus.OK).body(r.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id)
	{
		r.deleteById(id);
	}
}
