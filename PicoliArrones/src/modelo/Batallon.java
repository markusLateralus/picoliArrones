package modelo;

import java.awt.Color;
import java.util.LinkedList;

public class Batallon implements Casilla{

	private int id;
	private final int maximoSoldados=10;
	private Tipo tipo;
	private LinkedList<Soldado>soldados=new LinkedList<Soldado>();
	private Color colorBatallon;
	
	public Batallon(int id, Tipo tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	
	
	public Batallon(int id, Tipo tipo,LinkedList<Soldado>soldados,Color colorBatallon) {
		this(id,tipo);
		this.colorBatallon=colorBatallon;
		
	}
	
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getMaximoSoldados() {
		return maximoSoldados;
	}


	public Integer getCantidadSoldados() {
		// TODO Auto-generated method stub
		return soldados.size();
	}


	public boolean alistarSoldado(Soldado soldado) {

		//programacion por contrato
		//
		assert soldado.getEspecialidad().getTipo().equals(tipo):"especialidad no compatible";
		return	soldados.add(soldado);
		//programacion defensiva
//		boolean comprueba=false;
//		if(soldado.getEspecialidad().getTipo().equals(tipo)) {
//			
//			return	soldados.add(soldado);
//		}
//		
//		
//	return comprueba;
	}
	
	
	
	
}
