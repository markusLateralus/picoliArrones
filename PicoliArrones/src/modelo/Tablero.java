package modelo;

import java.util.ArrayList;

import modelo.Coordenada;

public class Tablero {
	private Dimension dimension;
	
	private Matriz<Coordenada, Casilla> casillas; //BIDIRECCIONAL
	
	public Tablero(Dimension dimension) {
		super();
		this.dimension=dimension;
		casillas=new Matriz<Coordenada, Casilla>(getAncho(), getAlto());
		
	}
	
	public int getAncho() {
		return dimension.getAncho();
	}

	public int getAlto() {
		return dimension.getAlto();
	}

	public Casilla getCasilla(Coordenada coordenada) {
		return casillas.getElement(coordenada);
	}

//	private boolean validaCoordenada(Coordenada coordenada) {
//		return coordenada.getX() >= 0 && coordenada.getY() >= 0 && coordenada.getX() < getAncho()
//				&& coordenada.getY() < getAlto();
//	}
	
	public boolean insertar(Casilla casilla,Coordenada coordenada) {
		boolean response=false;
		if(!casillas.contieneElemento(casilla) && !casillas.contieneClave(coordenada)) {
		casillas.insertElement(coordenada, casilla);
		response=true;
		}
		return response;
	}
	
	public boolean isEnSuMitad(Ejercito ejercito, Coordenada coordenada) {
		int y = coordenada.getY();
		int mitad = getAncho() / 2;
		int positionRelativa = y - (mitad * ejercito.getId()); //es como tener la mitad del tablero
		return positionRelativa >= 0 && positionRelativa < mitad + ejercito.getId();
	}



	public void insertar(ArrayList<Batallon> batallones, ArrayList<Coordenada> coordenadas) {
		// TODO Auto-generated method stub
		for (int i = 0; i < coordenadas.size(); i++) {
				casillas.insertElement(coordenadas.get(i), batallones.get(i));
			}
			
		}
	}

