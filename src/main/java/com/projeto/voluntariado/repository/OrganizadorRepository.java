package com.projeto.voluntariado.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.voluntariado.entity.Organizador;

public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {
	
	
}
