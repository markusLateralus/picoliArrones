package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableroTest {

	@Test
	void testIsEnSuMitad() {
	Tablero tablero=new Tablero(new Dimension(12,6));
	Ejercito [] ejercitos= {new Ejercito(0),new Ejercito(0),new Ejercito(1),new Ejercito(1)};
	Coordenada[] coordenadas= {new Coordenada(0,5),new Coordenada(0,6),new Coordenada(0,5),new Coordenada(0,6)};
	boolean resultados[]= {true,false,false,true};
	for (int i = 0; i < resultados.length; i++) {
		assertEquals(resultados[i], tablero.isEnSuMitad(ejercitos[i], coordenadas[i]));
	}
	}

}
