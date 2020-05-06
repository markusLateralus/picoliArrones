package controlador;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import modelo.Batallon;
import modelo.Coordenada;
import modelo.Soldado;
import vistaInfo.EspecificacionSoldadosInfo;

public class IniciadorController {

	private Juego juego;

	public IniciadorController(Juego juego) {
		super();
		this.juego = juego;
	}

	public boolean localizar(Coordenada coordenada) {
		return juego.localizarBatallon(coordenada);
	}
	public void poblarBatallon(List<EspecificacionSoldadosInfo> especificacion) {
		assert especificacion != null;
		for (EspecificacionSoldadosInfo especificacionSoldadosInfo : especificacion) {
			for (int i = 0; i < especificacionSoldadosInfo.getCantidad(); i++) {
				juego.alistarSoldadoBatallonActual(new Soldado(especificacionSoldadosInfo.getEspecialidad()));
			}
		}

	}
	
	public String getError() {
		return juego.getErrorActual().getMensaje();
	}
	public Juego getJuego() {
		return juego;
	}

	public boolean isLocalizarEstado() {
		return juego.isLocalizarEstado();
	}


}
