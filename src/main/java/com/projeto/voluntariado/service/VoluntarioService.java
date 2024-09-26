package com.projeto.voluntariado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.voluntariado.entity.Voluntario;
import com.projeto.voluntariado.repository.VoluntarioRepository;

@Service
public class VoluntarioService {

	private final VoluntarioRepository voluntarioRepository;

	@Autowired

	public VoluntarioService(VoluntarioRepository voluntarioRepository) {
		this.voluntarioRepository = voluntarioRepository;
	}

	public List<Voluntario> buscaTodosVoluntario() {
		return voluntarioRepository.findAll();
	}

	public Voluntario buscaVoluntarioId(Long id) {
		Optional<Voluntario> Voluntario = voluntarioRepository.findById(id);
		return Voluntario.orElse(null);
	}

	public Voluntario salvaVoluntario(Voluntario voluntario) {
		return voluntarioRepository.save(voluntario);
	}

	public Voluntario alterarVoluntario(Long id, Voluntario alterarVoluntario) {
		Optional<Voluntario> existeVoluntario = voluntarioRepository.findById(id);
		if (existeVoluntario.isPresent()) {
			alterarVoluntario.setId(id);
			return voluntarioRepository.save(alterarVoluntario);
		}
		return null;
	}

	public boolean apagarVoluntario(Long id) {
		Optional<Voluntario> existeVoluntario = voluntarioRepository.findById(id);
		if (existeVoluntario.isPresent()) {
			voluntarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
