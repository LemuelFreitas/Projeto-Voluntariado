package com.projeto.voluntariado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.voluntariado.entity.Organizador;
import com.projeto.voluntariado.repository.OrganizadorRepository;

@Service
public class OrganizadorService {

	private final OrganizadorRepository organizadorRepository;

	@Autowired

	public OrganizadorService(OrganizadorRepository organizadorRepository) {
		this.organizadorRepository = organizadorRepository;
	}

	public List<Organizador> buscaTodosOrganizador() {
		return organizadorRepository.findAll();
	}

	public Organizador buscaOrganizadorId(Long id) {
		Optional<Organizador> Organizador = organizadorRepository.findById(id);
		return Organizador.orElse(null);
	}

	public Organizador salvaOrganizador(Organizador organizador) {
		return organizadorRepository.save(organizador);
	}

	public Organizador alterarOrganizador(Long id, Organizador alterarOrganizador) {
		Optional<Organizador> existeOrganizador = organizadorRepository.findById(id);
		if (existeOrganizador.isPresent()) {
			alterarOrganizador.setId(id);
			return organizadorRepository.save(alterarOrganizador);
		}
		return null;
	}

	public boolean apagarOrganizador(Long id) {
		Optional<Organizador> existeOrganizador = organizadorRepository.findById(id);
		if (existeOrganizador.isPresent()) {
			organizadorRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
