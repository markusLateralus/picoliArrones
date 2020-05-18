package modelo;

public class Refriega {
	private Soldado defensor, atacante;
	private int incrementoExperiencia = 1, incrementoDefensa = 1, incrementoAtaque = 1;
	private int staminaInicialDefensor,staminaInicialAtacante;

	public Refriega(Soldado defensor, Soldado atacante) {
		super();
		this.defensor = defensor;
		this.atacante = atacante;
		staminaInicialAtacante=atacante.getStamina();
		staminaInicialDefensor=defensor.getStamina();
	}

	public void lucha() {
		float defensa = 0, ataque = 0;
		float staminaDefensor, staminaAtacante;
		while (!isAlguienSeveramenteHerido()) {
			defensa = defensor.defender();
			ataque = atacante.atacar();
			staminaDefensor=infringir(defensor, ataque);//infrigir da�o al defensor 
			staminaAtacante=infringir(atacante, defensa);
		}
		finalizar();
	}

	private void finalizar() {
		// TODO Auto-generated method stub
		// aumentar experiencia de ambos
		// la defensa del defensor
		// en caso de victoria del atacante hay que
		// aumentar el ataque del atacante
		defensor.incrementarExperiencia();
		atacante.incrementarExperiencia();
		defensor.incrementarDefensa();
		if (isVencedorAtacante())
			atacante.incrementaAtaque();
			atacante.incrementarDefensa();
	}

	private boolean isAlguienSeveramenteHerido() {
		// TODO Auto-generated method stub
		// Cuando tiene la mitad de la stamina que al comienzo de la refriega
		return defensor.getStamina()/2<staminaInicialDefensor || atacante.getStamina()/2<staminaInicialAtacante;
	}

	private float infringir(Soldado soldado, float cantidad) {
		float stamina= (float)soldado.getStamina()-cantidad;
		return stamina;
	}

	public Soldado getVencedor() {
		// TODO
		return null;
	}

	public boolean isVencedorAtacante() {
		// TODO
		return false;
	}

	public Soldado getDefensor() {
		return defensor;
	}

	public Soldado getAtacante() {
		return atacante;
	}

}
