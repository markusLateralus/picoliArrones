package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Especialidad;

class EspecialidadTest {

	@Test
	void testGetTipoPorNombre() {
		assertNull(Especialidad.getTipoPorNombre("nada"));
		assertEquals(Especialidad.BALLESTA, Especialidad.getTipoPorNombre("BALLESTA"));;
	}

}
