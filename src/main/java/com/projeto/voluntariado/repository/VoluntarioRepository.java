package com.projeto.voluntariado.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.voluntariado.entity.Voluntario;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {


}

