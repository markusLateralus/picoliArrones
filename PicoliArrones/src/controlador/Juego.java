 package controlador;



import java.util.ArrayDeque;

import modelo.Batallon;
import modelo.Blanca;
import modelo.Casilla;
import modelo.Castillo;
import modelo.Coordenada;
import modelo.Dimension;
import modelo.Ejercito;
import modelo.Error;
import modelo.Soldado;
import modelo.Tablero;


public class Juego {
	
	private Tablero tablero;
	private int ancho, alto;
	private ArrayDeque<Ejercito> ejercitos = new ArrayDeque<Ejercito>();
	private boolean localizarEstado = true;
	private Ejercito primerEjercito;
	private Error errorActual = null;
	private Colocando ponerController = new PonerController();

	public boolean isLocalizarEstado() {
		return localizarEstado;
	}

	public Juego(int ancho, int alto) {
		// TODO Auto-generated constructor stub
		this.alto=alto;
		this.ancho=ancho;
		tablero = new Tablero(ancho, alto);
		Ejercito ejercitoCero = new Ejercito(0);
		tablero.insertar(new Castillo(ejercitoCero), new Coordenada(3, 1));
		ejercitos.offer(ejercitoCero);
		Ejercito ejercitoUno = new Ejercito(1);
		tablero.insertar(new Castillo(ejercitoUno), new Coordenada(3, ancho - 2));
		ejercitos.offer(ejercitoUno);
		primerEjercito = ejercitos.peek();
	}

	public Tablero getTablero() {
		return tablero;
	}

	public boolean poner(Coordenada coordenada) {
		return ponerController.colocar(this, coordenada);
	}

	public boolean insertar(Casilla casilla, Coordenada coordenada) {
		return tablero.insertar(casilla, coordenada);
	}

	public Error getErrorActual() {
		Error response = errorActual;
		errorActual = Error.noerror;
		return response;
	}

	public void setErrorActual(Error errorActualError) {
		this.errorActual = errorActualError;
	}

	boolean comprobarLocalizacion(Coordenada coordenada) {
		return getTablero().isEnSuMitad(getEjercitoActual(), coordenada);
	}

	void setSiguienteEjercito() {
		ejercitos.offer(ejercitos.poll());
		if (ejercitos.peek().equals(primerEjercito)) {
			localizarEstado = false;
			ponerController=new MoverController();
		}
	}

	public Ejercito getEjercitoActual() {
		return ejercitos.peek();
	}

	public void alistarSoldadoBatallonActual(Soldado soldado) {
		// Demeter
		getBatallonActual().alistarSoldado(soldado);
	}

	public Batallon getBatallonActual() {
		return getEjercitoActual().getBatallonActual();
	}


   public int getAncho() {
	   return ancho;
   }
   public int getAlto() {
	   return alto;
   }
	public Casilla getCasilla(Coordenada coordenada) {
		Casilla casilla = tablero.getCasilla(coordenada);
		if (casilla == null) {
			return new Blanca();
		}
		return casilla;
	}


}
