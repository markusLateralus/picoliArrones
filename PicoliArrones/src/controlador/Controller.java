package controlador;

import java.util.List;

import modelo.Batallon;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Soldado;
import vistaInfo.EspecificacionSoldadosInfo;

public class Controller {
	private Juego juego;
	///private Dimension dimension;

	
	public Controller(int ancho, int alto) {
		// TODO Auto-generated constructor stub
		juego=new Juego(ancho, alto);
	}

	public void poblarBatallon(List<EspecificacionSoldadosInfo> especificacion) {
		assert especificacion != null;
		for (EspecificacionSoldadosInfo especificacionSoldadosInfo : especificacion) {
			for (int i = 0; i < especificacionSoldadosInfo.getCantidad(); i++) {
				juego.alistarSoldadoBatallonActual(new Soldado(especificacionSoldadosInfo.getEspecialidad()));
			}
		}

	}

	public boolean localizar(Coordenada coordenada) {
		return juego.poner(coordenada);
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
	public Ejercito getEjercitoActual() {
		return juego.getEjercitoActual();
	}

	public Batallon getBatallonActual() {
		return juego.getBatallonActual();
	}

	public int getAncho() {
		// TODO Auto-generated method stub
		return juego.getAncho();
	}

	public int getAlto() {
		// TODO Auto-generated method stub
		return juego.getAlto();
	}

//	public Dimension getDimension() {
//		return this.dimension;
//	}
}
