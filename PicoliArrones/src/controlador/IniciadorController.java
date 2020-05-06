package controlador;
import java.util.List;

import modelo.Coordenada;
import modelo.Dimension;
import modelo.Soldado;
import vistaInfo.EspecificacionSoldadosInfo;

public class IniciadorController {

	private Juego juego;
	private Dimension dimension;

	public IniciadorController(Dimension dimension) {
		super();
		this.dimension=dimension;
		juego=new Juego(this.dimension);
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

	public Dimension getDimension() {
		return this.dimension;
	}

}
