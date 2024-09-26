package com.projeto.voluntariado.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProjetoTest {
	
	private Projeto projeto;
	private Organizador organizador;

	@BeforeEach
	public void setUp() {
		// Arrange
		projeto = new Projeto(1L,5,"centro",LocalDate.of(2024, 9, 1),"18:00",organizador);

	}

	@Test
	public void testId() {
		// Act: Atribui o valor ao atributo 'id'
		projeto.setId(2L);

		// Assert : Verifica se o valor foi corretamente atribuido
		assertEquals(2L, projeto.getId(), "O ID deve ser igual ao valor atribuido");
    }
	@Test
	public void testOrganizador() {
		// Act
		projeto.setOrganizador(organizador);

		// Assert
		assertEquals(organizador, projeto.getOrganizador());
	}
	@Test
     public void testCampanhaprojeto() {
		// Act
		projeto.setCampanhaprojeto(5);
		// Assert
		assertEquals(5,projeto.getCampanhaprojeto());
	}
	@Test
	public void testLocalevento() {
		// Act
		projeto.setLocalevento("escola");
		// Assert
		assertEquals("escola", projeto.getLocalevento());
	}
	@Test
	void testDataenvento() {
		// Act
		projeto.setDataevento(LocalDate.of(2024, 9, 1));
		// Assert
		assertEquals(LocalDate.of(2024, 9, 1), projeto.getDataevento());
	}
	
	@Test
    public void testHora() {
		// Act
		projeto.setHora("18:20");
		// Assert
		assertEquals("18:20",projeto.getHora());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		// Act
		Projeto novoProjeto = new Projeto(3L,5,"escola",LocalDate.of(2024, 9, 22),"19:00",organizador);
		// Assertion
		assertAll("novoProjeto", () -> assertEquals(3L, novoProjeto.getId()),
				() -> assertEquals(organizador, novoProjeto.getOrganizador()),
				() -> assertEquals("escola", novoProjeto.getLocalevento()),
				() -> assertEquals(LocalDate.of(2024, 9, 22), novoProjeto.getDataevento()),
				() -> assertEquals(5, novoProjeto.getCampanhaprojeto()),
				() -> assertEquals("19:00", novoProjeto.getHora()));
				
	
	
	}
}
