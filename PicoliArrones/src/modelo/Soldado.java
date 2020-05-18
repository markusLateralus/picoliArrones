package modelo;

import utiles.Dado;
import utiles.Utiles;

public class Soldado {

	private Especialidad especialidad;
	private final int staminaMaxima=100; 
	private int stamina=staminaMaxima;
	private final int staminaCritica=20;
	private int experiencia=1;
	private int defensa=1;
	private int ataque=1;
	private Dado dado;

	public Soldado(Especialidad especialidad) {
		super();
		this.especialidad = especialidad;
		dado=new Dado();
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public boolean isCriticaStamina() {
		// TODO Auto-generated method stub
		return staminaCritica>=stamina;
	}

	public int getStamina() {
		// TODO Auto-generated method stub
		return stamina;
	}

	public float defender() {
		float valorDefensa=experiencia + Utiles.getAleatorioSesgado(1, 6, 1.2F)+ especialidad.getDefensa();
		return valorDefensa;
	}

	public float atacar() {
		// TODO Auto-generated method stub
		float valorAtaque=experiencia + Utiles.getAleatorio()+ especialidad.getAtaque();
		return valorAtaque;
	}

	public void incrementarExperiencia() {
		// TODO Auto-generated method stub
		experiencia++;
	}

	public void incrementarDefensa() {
		// TODO Auto-generated method stub
		defensa++;
	}

	public void incrementaAtaque() {
		// TODO Auto-generated method stub
		ataque++;
	}
	
	
}
