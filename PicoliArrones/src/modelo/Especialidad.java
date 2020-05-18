package modelo;

import java.util.Arrays;

public enum Especialidad {


	espada(Tipo.INFANTERIA,1.10F,1.20F),
	lanza(Tipo.INFANTERIA,1.00F,1.30F),
	arco(Tipo.ARQUERIA,1.20F,0.80F),
	ballesta(Tipo.ARQUERIA,1.40F,0.80F),
	ligera(Tipo.CABALLERIA,1.40F,1.00F),
	pesada(Tipo.CABALLERIA,1.50F,1.60F);
	private Tipo tipo;
	float ataque, defensa;

	private Especialidad(Tipo tipo,float ataque, float defensa) {
		this.tipo = tipo;
		this.ataque=ataque;
		this.defensa=defensa;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public static Especialidad getTipoPorNombre(String especialidad) {
		
		for (Especialidad especial : Arrays.asList(Especialidad.values())) {
			if(especial.toString().equals(especialidad)) {
				return especial;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public float getAtaque() {
		return ataque;
	}
	public float getDefensa() {
		return defensa;
	}
	
}
