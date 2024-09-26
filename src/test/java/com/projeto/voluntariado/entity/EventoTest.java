package com.projeto.voluntariado.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventoTest {

	private Evento evento;
	private Voluntario voluntario;
	private Projeto projeto;

	@BeforeEach
	public void setUp() {
		// Arrange
		evento = new Evento(1L, voluntario, projeto);
	}

	@Test
	public void testId() {
		// Act: Atribui o valor ao atributo 'id'
		evento.setId(2L);

		// Assert : Verifica se o valor foi corretamente atribuido
		assertEquals(2L, evento.getId(), "O ID deve ser igual ao valor atribuido");
	}

	@Test
	public void testVoluntario() {
		// Act
		evento.setVoluntario(voluntario);

		// Assert
		assertEquals(voluntario, evento.getVoluntario());
	}

	@Test
	public void testProjeto() {
		// Act
		evento.setProjeto(projeto);

		// Assert
		assertEquals(projeto, evento.getProjeto());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		// Act
		Evento novoEvento = new Evento(3L, voluntario, projeto);
		// Assertion
		assertAll("novoEvento", () -> assertEquals(3L, novoEvento.getId()),
				() -> assertEquals(voluntario, novoEvento.getVoluntario()),
				() -> assertEquals(projeto, novoEvento.getProjeto()));
	}
}
