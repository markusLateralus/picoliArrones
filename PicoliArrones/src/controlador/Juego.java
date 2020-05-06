package controlador;



import java.util.ArrayDeque;


import modelo.Batallon;
import modelo.Castillo;
import modelo.Coordenada;
import modelo.Dimension;
import modelo.Ejercito;
import modelo.Soldado;
import modelo.Tablero;
import modelo.Error;


public class Juego {
	
	private Tablero tablero;
	private ArrayDeque<Ejercito> ejercitos = new ArrayDeque<Ejercito>();
	private boolean localizarEstado = true;
	private Ejercito primerEjercito;
	private Error errorActualError = null;
private Dimension dimension;


	public Juego(Dimension dimension) {
		super();
		this.dimension=dimension;
		this.tablero = new Tablero(dimension);
		Ejercito ejercitoCero = new Ejercito(0);
		ejercitos.offer(ejercitoCero);  //inserta al final de la cola
		Ejercito ejercitoUno = new Ejercito(1);
		ejercitos.offer(ejercitoUno);
		primerEjercito = ejercitos.peek(); //recuperamos el primero de la cola
		tablero.insertar(new Castillo(ejercitoCero), new Coordenada(1,1));
		tablero.insertar(new Castillo(ejercitoUno), new Coordenada(3,4));
	}

	public Tablero getTablero() {
		return tablero;
	}
	public boolean isLocalizarEstado() {
		return localizarEstado;
	}
	
	public boolean localizarBatallon(Coordenada coordenada) {
		boolean insertar = comprobarLocalizacion(coordenada);
		if (!insertar) {
			errorActualError = Error.posicion;
		} else if (localizarEstado) {
			Ejercito ejercito = ejercitos.peek();
			Batallon batallonActual = ejercito.getBatallonActual();
			insertar = tablero.insertar(batallonActual, coordenada);
			if (insertar) {
				if (!ejercito.setSiguienteBatallon()) {
					setSiguienteEjercito();
				}
			} else {
				errorActualError = Error.ocupada;
			}
		}
		return insertar && localizarEstado;
	}

	public Error getErrorActual() {
		Error response = errorActualError;
		errorActualError = Error.noerror;
		return response;
	}

	private boolean comprobarLocalizacion(Coordenada coordenada) {
		return getTablero().isEnSuMitad(getEjercitoActual(), coordenada);
	}

	private void setSiguienteEjercito() {
		ejercitos.offer(ejercitos.poll()); //poner a la cola el ejercito que está primero. CAMBIAR TURNO
		if (ejercitos.peek().equals(primerEjercito)) {
			localizarEstado = false;
		}
	}

	public Ejercito getEjercitoActual() {
		return ejercitos.peek();
	}

	public void alistarSoldadoBatallonActual(Soldado soldado) {
		// Demeter
		getEjercitoActual().getBatallonActual().alistarSoldado(soldado);
	}


public Batallon getBatallonActual() {
	return getEjercitoActual().getBatallonActual();
}
}
