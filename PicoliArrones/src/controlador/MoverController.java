package controlador;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Error;

public class MoverController implements Colocando {


	@Override
	public boolean colocar(Juego juego, Coordenada coordenada) {
		assert coordenada!=null :"no hay coordenada";
			boolean ponerFicha=juego.isLocalizarEstado();
			boolean moverFicha=false;
			if(!ponerFicha) {
	
			moverFicha=	juego.mover(juego.getBatallonActual(),coordenada);
			if(moverFicha) {
				juego.setSiguienteEjercito();
			}
		} else {
			juego.setErrorActual(Error.ocupada);
		}
			return moverFicha;
			}


		}
	


