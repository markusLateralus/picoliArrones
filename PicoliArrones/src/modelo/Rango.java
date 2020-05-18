package modelo;

public class Rango {

	private int maximo, minimo;
	public Rango(int maximo, int minimo) {
		assert maximo>minimo &&minimo>0:" rango incorrecto";
		this.maximo=maximo;
		this.minimo=minimo;
	}
	public int getMaximo() {
		return maximo;
	}
	public int getMinimo() {
		return minimo;
	}
	
	
}
