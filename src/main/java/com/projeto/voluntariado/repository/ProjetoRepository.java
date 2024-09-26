package com.projeto.voluntariado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.voluntariado.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
