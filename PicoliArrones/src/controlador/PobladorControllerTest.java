package controlador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.Batallon;
import modelo.Especialidad;
import modelo.Tipo;
import vistaInfo.EspecificacionSoldadosInfo;

class PobladorControllerTest {

	@Test
	void testPoblarBatallon() {
		PobladorController po=new PobladorController();
		Batallon batallon=new Batallon(1,Tipo.ARQUERIA);
		
		po.setBatallon(batallon);
		Especialidad especialidades[]= {Especialidad.ARCO,Especialidad.BALLESTA};
		int mitad=5;
		ArrayList<EspecificacionSoldadosInfo>lista=new ArrayList<EspecificacionSoldadosInfo>();
		for (int i = 0; i < especialidades.length; i++) {
			lista.add(new EspecificacionSoldadosInfo(especialidades[i].toString(), mitad));
		}
		
		po.poblarBatallon(lista);
		int max=10;
		assertEquals(max, po.getBatallon().getCantidadSoldados());
	
	}
	@Test
	void testPoblarBatallonDos() {
		//voy a meter en una lista soldados de diferentes tipos para probar que me da error
		PobladorController po=new PobladorController();
		Batallon batallon=new Batallon(1,Tipo.ARQUERIA);
		
		po.setBatallon(batallon);
		Especialidad especialidades[]= {Especialidad.ARCO,Especialidad.BALLESTA};
		int fraccion=4;
		ArrayList<EspecificacionSoldadosInfo>lista=new ArrayList<EspecificacionSoldadosInfo>();
		for (int i = 0; i < especialidades.length; i++) {
			lista.add(new EspecificacionSoldadosInfo(especialidades[i].toString(), fraccion));
		}
		int max=10;
		lista.add(new EspecificacionSoldadosInfo(Especialidad.ESPADA.toString(), max-fraccion*2));
		po.poblarBatallon(lista);
		assertEquals(max, po.getBatallon().getCantidadSoldados());
	}

}
