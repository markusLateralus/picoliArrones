package modelo;

public enum Equipo {

	infanteria(new Rango(1,1), new Rango(1,1)),
	arqueria(new Rango(1,1), new Rango(2,2)),
	caballeria(new Rango(1,2), new Rango(1,2));
	
	private Rango rangoMovimiento;
	private Rango rangoAtaque;
	

	private Equipo(Rango rangoMovimiento, Rango rangoAtaque) {
		// TODO Auto-generated constructor stub
		this.rangoAtaque=rangoAtaque;
		this.rangoMovimiento=rangoMovimiento;
		
	}
}
