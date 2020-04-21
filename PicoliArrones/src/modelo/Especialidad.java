package modelo;

import java.util.Arrays;

public enum Especialidad {

	ESPADA(Tipo.INFANTERIA),
	DANZA(Tipo.INFANTERIA),
	ARCO(Tipo.ARQUERIA),
	BALLESTA(Tipo.ARQUERIA),
	LIGERA(Tipo.CABALLERIA),
	PESADA(Tipo.CABALLERIA);
	
	private Tipo tipo;
	
	private Especialidad(Tipo tipo) {
		this.tipo=tipo;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public static Especialidad getTipoPorNombre(String especialidad) {
		for (Especialidad elemento : Arrays.asList(Especialidad.values())) {
			if(elemento.toString().equals(especialidad)) {
				return elemento;
			}
		};
		return null;
	}
	
}
