package modelo;

import modelo.Coordenada;
import utiles.Utiles;

public class Coordenada{

	
	private int x, y;

	public Coordenada(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		boolean response = super.equals(obj);
		if (!response) {
			Coordenada parametro = (Coordenada) obj;
			response = this.getX() == parametro.getX() && this.getY() == parametro.getY();
		}
		return response;
	}
	
	public Coordenada creaCoordenadaAlrededor(int j2) {
		int[] posicion = Utiles.damePosicionAlrededor(j2);
		return new Coordenada(this.getX() + posicion[0], this.getY() + posicion[1]);
	}
	
	
	
	
	
	
	
//	@Override
//	public int hashCode() {
//		return getX()*10+getY();
//	}
//	@Override
//	public String toString() {
//		return getX()+":"+getY()+"::"+hashCode();
//	}

	
}
