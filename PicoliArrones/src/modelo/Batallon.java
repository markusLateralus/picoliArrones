package modelo;

import java.awt.Color;
import java.util.LinkedList;

public class Batallon {

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
	
	
	
	
}
