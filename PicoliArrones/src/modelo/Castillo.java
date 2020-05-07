package modelo;

import controlador.Juego;
import vistaInfo.CasillaInfo;
import vistaInfo.FichaCastilloInfo;

public class Castillo implements Casilla{

	private Ejercito ejercito;

	public Castillo(Ejercito ejercito ) {
		this.ejercito=ejercito;

		// TODO Auto-generated constructor stub
	}

	public Ejercito getEjercito() {
		return this.ejercito;
	}

	@Override
	public Casilla crear(Tablero tablero, Coordenada coordenada) {
		// TODO Auto-generated method stub
		Casilla casilla = tablero.getCasilla(coordenada);
		Castillo castillo=null;
		//FichaCastilloInfo fichaCastilloInfo=null;
		if(casilla!=null) {
			for (int i = 0; i < tablero.getCoordenadasCastillos().length; i++) {
				Coordenada cordAux=tablero.getCoordenadasCastillos()[i];
				if(cordAux.equals(coordenada)) {
					castillo=(Castillo)casilla;
				return castillo;
					//return new FichaCastilloInfo(castillo.getEjercito().getId());
				}
			}
			
		}
	 	
		return null;
	}
}
