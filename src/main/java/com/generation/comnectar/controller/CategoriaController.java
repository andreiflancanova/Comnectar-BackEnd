package com.generation.comnectar.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.generation.comnectar.model.Categoria;
import com.generation.comnectar.repository.CategoriaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categorias")

public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<Categoria>> buscaCategoria() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscaCategoriaId(@PathVariable Long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	@GetMapping("/classe/{classeCategoria}")
	public ResponseEntity<List<Categoria>> buscaCategoriaClasse(@PathVariable String classeCategoria) {
		return ResponseEntity.ok(repository.findAllByClasseCategoriaContainingIgnoreCase(classeCategoria));
	}

	@GetMapping("/mprod/{modProdCategoria}")
	public ResponseEntity<List<Categoria>> buscaCategoriaMprod(@PathVariable String modProdCategoria) {
		return ResponseEntity.ok(repository.findByModProdCategoriaContainingIgnoreCase(modProdCategoria));
	}

	@GetMapping("/frescor/{frescorCategoria}")
	public ResponseEntity<List<Categoria>> buscaCategoriaFrescor(@PathVariable boolean frescorCategoria) {
		return ResponseEntity.ok(repository.findByFrescorCategoria(frescorCategoria));
	}

	@PostMapping
	public ResponseEntity<Categoria> adicionaCategoria(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	@PutMapping
	public ResponseEntity<Categoria> atualizaCategoria(@Valid @RequestBody Categoria categoria) {
		return repository.findById(categoria.getId()).map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria)))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
