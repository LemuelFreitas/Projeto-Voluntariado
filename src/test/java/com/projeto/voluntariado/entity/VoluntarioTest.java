package com.projeto.voluntariado.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VoluntarioTest {

		private Voluntario voluntario;

		@BeforeEach
		void setUp() {
			// Arrange
			voluntario = new Voluntario(1L, "Luis", LocalDate.of(2024, 8, 10),"(15)99848885","a");
		}

		@Test
		@DisplayName("Testando o getter e setter do campo ID")
		void testId() {
			// Act
			voluntario.setId(2L);
			// Assert
			assertEquals(2L, voluntario.getId());
		}

		@Test
		@DisplayName("Testando o getter e setter do campo nome")
		void testNome() {
			// Act
			voluntario.setNome("Isabella");
			// Assert
			assertEquals("Isabella", voluntario.getNome());
		}

		@Test
		@DisplayName("Testando o getter e setter do campo data nascimento")
		void testDatanascimento() {
			// Act
			voluntario.setDatanascimento(LocalDate.of(2019, 01, 19));
			// Assert
			assertEquals(LocalDate.of(2019, 01, 19), voluntario.getDatanascimento());
		}

		@Test
		@DisplayName("Testando o getter e setter do campo telefone")
		void testTelefone() {
			// Act
			voluntario.setTelefone("(15)996677425");
			// Assert
			assertEquals("(15)996677425", voluntario.getTelefone());
		}
		
		@Test
		@DisplayName("Testando o getter e setter do campo tipo Sanguineo")
		void testTiposanguineo() {
			// Act
			voluntario.setTiposanguineo("a");
			// Assert
			assertEquals("a", voluntario.getTiposanguineo());
		}

		@Test
		@DisplayName("Testando o construtor com todos os argumentos")
		void testConstructorAll() {
			// Act
			Voluntario novoVoluntario = new Voluntario(3L, "heitor",LocalDate.of(2024, 9, 22),"15 99854885","b");
			// Assertion
			assertAll("novoVoluntario", () -> assertEquals(3L, novoVoluntario.getId()),
					() -> assertEquals("heitor", novoVoluntario.getNome()),
					()-> assertEquals(LocalDate.of(2024, 9, 22), novoVoluntario.getDatanascimento()),
					() -> assertEquals("15 99854885", novoVoluntario.getTelefone()),
			        () -> assertEquals("b", novoVoluntario.getTiposanguineo()));
			        

		}
}
