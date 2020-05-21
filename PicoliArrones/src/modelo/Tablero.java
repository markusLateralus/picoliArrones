package modelo;

public class Tablero {

	private Matriz<Coordenada, Casilla> casillas; //BIDIRECCIONAL
	private int ancho, alto;

	public Tablero(int ancho, int alto) {
		this.ancho=ancho;
		this.alto=alto;
		// TODO Auto-generated constructor stub
		casillas=new Matriz<Coordenada, Casilla>(alto,ancho);
	}


	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public Casilla getCasilla(Coordenada coordenada) {
		return casillas.getElement(coordenada);
	}

	
	public boolean insertar(Casilla casilla,Coordenada coordenada) {
		boolean response=false;
		if(!casillas.contieneElemento(casilla) && !casillas.contieneClave(coordenada)) {
		casillas.insertElement(coordenada, casilla);
		response=true;
		}
		return response;
	}

	public boolean mover(Casilla casilla, Coordenada coordenadaDestino) {
		// TODO Auto-generated method stub
		boolean response=false;
		if(casillas.contieneElemento(casilla) && !casillas.contieneClave(coordenadaDestino)) {
			casillas.mueveElement(casilla,coordenadaDestino);
			response=true;
		}
		return response;
	}

	public boolean isEnSuMitad(Ejercito ejercito, Coordenada coordenada) {
		int y = coordenada.getY();
		int mitad = ancho / 2;
		int positionRelativa = y - (mitad * ejercito.getId()); //es como tener la mitad del tablero
		return positionRelativa >= 0 && positionRelativa < mitad + ejercito.getId();
	}
	private  boolean validaCoordenada(Coordenada posicion) {
		return posicion.getX() >= 0 && posicion.getY() >= 0 && posicion.getX() < this.getAncho()
				&& posicion.getY() < this.getAlto(); 
	}
	public boolean borrar(Casilla casilla) {
		return casillas.borrar(casilla);
	}
	public void conquistar(Batallon origen, Batallon destino) {
		// TODO Auto-generated method stub
		Coordenada clave=casillas.getClave(destino);
		this.borrar(destino);
		this.borrar(origen);
		insertar(origen, clave);
		
	}



	
	}

