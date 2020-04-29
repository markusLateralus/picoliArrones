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
	
	

//	public ArrayList<Casilla> getCasillas(ArrayList<Coordenada> coordenadas) {
//		// TODO Auto-generated method stub
//		ArrayList <Casilla>casillas=new ArrayList<Casilla>();
//		for (int i = 0; i < coordenadas.size(); i++) {
//			Casilla casilla=coordenadas.get(i);
//			casillas.add((Casilla) coordenadas.get(i));
//		}
//		return casillas;
//	}

	public void insertar(ArrayList<Batallon> batallones, ArrayList<Coordenada> coordenadas) {
		// TODO Auto-generated method stub
		for (int i = 0; i < coordenadas.size(); i++) {
				casillas.insertElement(coordenadas.get(i), batallones.get(i));
			}
			
		}
	}

