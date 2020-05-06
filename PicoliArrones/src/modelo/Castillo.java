package modelo;

public class Castillo implements Casilla{

	private Ejercito ejercito;
	public Castillo(Ejercito ejercito) {
		this.ejercito=ejercito;
		// TODO Auto-generated constructor stub
	}
	
	public Ejercito getEjercito() {
		return this.ejercito;
	}
}
