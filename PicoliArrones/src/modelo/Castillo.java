package modelo;

import vistaInfo.CastilloFichaFactory;
import vistaInfo.FichaFactory;
import vistaInfo.FichaInfo;
import modelo.Casilla;


public class Castillo implements Casilla{

	private Ejercito ejercito;

	public Castillo(Ejercito ejercito ) {
		this.ejercito=ejercito;

		// TODO Auto-generated constructor stub
	}

	@Override
	public FichaFactory getFactory(Ejercito ejercito) {
		// TODO Auto-generated method stub
		return new CastilloFichaFactory(ejercito);
		}
	






}
