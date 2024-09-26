package com.projeto.voluntariado.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrganizadorTest {

	private Organizador organizador;

	@BeforeEach
	void setUp() {
		// Arrange
		organizador = new Organizador(1L, "Amigos do bem", LocalDate.of(2024, 8, 10),"@amigosdobem@gmail.com",
				"(15)99848885");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		// Act
		organizador.setId(2L);
		// Assert
		assertEquals(2L, organizador.getId());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo nomeong")
	void testNomeong() {
		// Act
		organizador.setNomeong("Amare");
		// Assert
		assertEquals("Amare", organizador.getNomeong());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testEmail() {
		// Act
		organizador.setEmail("amare@gmail.com");
		// Assert
		assertEquals("amare@gmail.com", organizador.getEmail());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo data nascimento")
	void testDatanascimento() {
		// Act
		organizador.setDatanascimento(LocalDate.of(2019, 02, 18));
		// Assert
		assertEquals(LocalDate.of(2019, 02, 18), organizador.getDatanascimento());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
		// Act
		organizador.setTelefone("(15)996677425");
		// Assert
		assertEquals("(15)996677425", organizador.getTelefone());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		// Act
		Organizador novoOrganizador = new Organizador(3L, "Agencia do bem", LocalDate.of(2024, 9, 23),
				"agenciadobem@gmail.com", "15 99854885");
		// Assertion
		assertAll("novoOrganizador", () -> assertEquals(3L, novoOrganizador.getId()),
				() -> assertEquals("Agencia do bem", novoOrganizador.getNomeong()),
				() -> assertEquals("agenciadobem@gmail.com", novoOrganizador.getEmail()),
				() -> assertEquals(LocalDate.of(2024, 9, 23), novoOrganizador.getDatanascimento()),
				() -> assertEquals("15 99854885", novoOrganizador.getTelefone()));

	}
}
