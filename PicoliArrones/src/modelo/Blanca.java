package modelo;

import modelo.Casilla;
import vistaInfo.BlancaFichaFactory;
import vistaInfo.FichaFactory;
import vistaInfo.FichaInfo;

public class Blanca implements Casilla{

	@Override
	public FichaFactory getFactory(Ejercito ejercito) {
		// TODO Auto-generated method stub
		return new BlancaFichaFactory();
	}
	



}
