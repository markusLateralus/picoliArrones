package modelo;

import java.util.LinkedList;

public class Soldado {

	private Especialidad especialidad;
private LinkedList <Especialidad> especialidades=new LinkedList<Especialidad>();
	public Soldado(Especialidad especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public LinkedList<Especialidad> getEspecialidades() {
		return especialidades;
	}
	
	
}
