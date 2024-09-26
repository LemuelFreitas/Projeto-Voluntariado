package com.projeto.voluntariado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.voluntariado.entity.Projeto;
import com.projeto.voluntariado.repository.ProjetoRepository;

@Service
public class ProjetoService {

	private final ProjetoRepository projetoRepository;

	@Autowired

	public ProjetoService(ProjetoRepository projetoRepository) {
		this.projetoRepository = projetoRepository;
	}

	public List<Projeto> buscaTodosProjeto() {
		return projetoRepository.findAll();
	}

	public Projeto buscaProjetoId(Long id) {
		Optional<Projeto> Projeto = projetoRepository.findById(id);
		return Projeto.orElse(null);
	}

	public Projeto salvaProjeto(Projeto projeto) {
		return projetoRepository.save(projeto);
	}

	public Projeto alterarProjeto(Long id, Projeto alterarProjeto) {
		Optional<Projeto> existeProjeto = projetoRepository.findById(id);
		if (existeProjeto.isPresent()) {
			alterarProjeto.setId(id);
			return projetoRepository.save(alterarProjeto);
		}
		return null;
	}

	public boolean apagarProjeto(Long id) {
		Optional<Projeto> existeProjeto = projetoRepository.findById(id);
		if (existeProjeto.isPresent()) {
			projetoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
