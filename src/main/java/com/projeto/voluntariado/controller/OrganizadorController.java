package com.projeto.voluntariado.controller;

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

import com.projeto.voluntariado.entity.Organizador;
import com.projeto.voluntariado.service.OrganizadorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Organizador", description = "API REST DE GERENCIAMENTO DE ORGANIZADOR")
@RestController
@RequestMapping("/organizador/")
@CrossOrigin(origins="*")

public class OrganizadorController {
	private final OrganizadorService organizadorService;

	@Autowired
	public OrganizadorController(OrganizadorService organizadorService) {
		this.organizadorService = organizadorService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza os organizadores por ID")
	public ResponseEntity<Organizador> buscaOrganizadorControlId(@PathVariable Long id) {
		Organizador organizador = organizadorService.buscaOrganizadorId(id);
		if (organizador != null) {
			return ResponseEntity.ok(organizador);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Apresenta os organizadores")
	public ResponseEntity<List<Organizador>> buscaTodosOrganizadorControl() {
		List<Organizador> Organizador = organizadorService.buscaTodosOrganizador();
		return ResponseEntity.ok(Organizador);
	}
	
	@PostMapping("/")
	@Operation(summary = "Cadastra um organizador")
	public ResponseEntity<Organizador> salvaOrganizadorControl(@RequestBody @Valid Organizador organizador) {
		Organizador salvaOrganizador = organizadorService.salvaOrganizador(organizador);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaOrganizador);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Altera os organizadores")
	public ResponseEntity<Organizador> alterarOrganizadorControl(@PathVariable Long id,
			@RequestBody @Valid Organizador organizador) {
		Organizador alterarOrganizador = organizadorService.alterarOrganizador(id, organizador);
		if (alterarOrganizador != null) {
			return ResponseEntity.ok(organizador);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um organizador")
	public ResponseEntity<String> apagarOrganizadorControl(@PathVariable Long id) {
		boolean apagar = organizadorService.apagarOrganizador(id);
		if (apagar) {
			return ResponseEntity.ok().body("O organizador foi excluído com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
