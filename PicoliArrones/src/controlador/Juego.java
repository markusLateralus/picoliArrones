package controlador;



import java.util.ArrayList;
import java.util.Stack;

import modelo.Casilla;
import modelo.Batallon;
import modelo.Coordenada;
import modelo.Dimension;
import modelo.Ejercito;

import modelo.Tablero;

import vista.TableroUI;

public class Juego {
	
	private Tablero tablero;	
	Ejercito ejercito1;
	Ejercito ejercito2;
	private ArrayList <Ejercito>ejercitos=new ArrayList<Ejercito>();
	private boolean localizarEstado=true;
	private int idEjercitoActual=0;
	public Juego() {
		super();		
		 ejercito1=new Ejercito(1 );
			ejercito2=new Ejercito(2);
		this.ejercitos=crearEjercitos();	
		tablero=new Tablero(new Dimension(6,12));// en su constructor tiene una matriz
	
	}
	
	
private ArrayList <Ejercito> crearEjercitos( ) {
	

	ejercitos.add(ejercito1);
	ejercitos.add(ejercito2);
	return ejercitos;
}

	
public ArrayList<Ejercito> getEjercitos() {
		return ejercitos;
	}
//public Stack<Batallon>getEjercitoConBatallones(int posicion){
//	return ejercitos.get(posicion).getBatallones();
//}

public boolean localizarBatallon(Coordenada coordenada) {
	// TODO Auto-generated method stub
	boolean respuesta=localizarEstado;
	if(respuesta) {
		
	
	Ejercito ejercito=ejercitos.get(idEjercitoActual);
	Batallon batallonActual=ejercito.getBatallonActual();
    respuesta=tablero.insertar(batallonActual, coordenada);
	if(respuesta) {
		if(!ejercito.setSiguienteBatallon()) {
			setSiguienteEjercito();
		}
	}
	}
	return respuesta;
}
public boolean getLocalizarEstado() {
return localizarEstado;
}

private void setSiguienteEjercito() {
	if(++idEjercitoActual==ejercitos.size()) {
		idEjercitoActual=0;
		localizarEstado=false;
	}
}



public void colocarBatallon(Ejercito ejercito, Coordenada coordenada) {
	//int contador=ejercito.getBatallones().size()
	for (Ejercito ejer : ejercitos) {
		if(ejer.equals(ejercito)) {
			if(ejer.getBatallones().size()>0) {
				Batallon batallon=ejer.getUltimoBatallon();
				tablero.insertar(batallon, coordenada);
				ejer.borrarUltimoBatallon();
				
			}

	}
	}	



}

public Casilla getCasilla(String nombre,TableroUI tableroUI) {
	Coordenada coordenada=tableroUI.obtenCoordenada(nombre);
	return tablero.getCasilla(coordenada);
}
public Tablero getTablero() {
	return tablero;
}


public Ejercito getEjercito1() {
	return ejercito1;
}


public Ejercito getEjercito2() {
	return ejercito2;
}

public Ejercito getEjercitoConcreto(int valor) {
	return ejercitos.get(valor);
}
}
