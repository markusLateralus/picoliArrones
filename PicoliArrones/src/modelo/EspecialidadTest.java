package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EspecialidadTest {

	@Test
	void testGetTipoPorNombre() {
		assertNull(Especialidad.getTipoPorNombre("nada"));
		assertEquals(Especialidad.BALLESTA, Especialidad.getTipoPorNombre("BALLESTA"));;
	}

}
