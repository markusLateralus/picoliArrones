package modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;


import vistaInfo.FichaInfo;
import vistaInfo.BatallonFichaFactory;
import vistaInfo.FichaFactory;

public class Batallon implements Casilla {

	private int id;
	private final int maximoSoldados=10;
	private Tipo tipo;
	private LinkedList<Soldado>soldados=new LinkedList<Soldado>();
	private Color colorBatallon;
	private boolean marcada=false;
	public Batallon(int id, Tipo tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	
	
	}
	
	
	public Batallon(int id, Tipo tipo,LinkedList<Soldado>soldados,Color colorBatallon) {
		this(id,tipo);
		this.colorBatallon=colorBatallon;
		
	}
	
	public LinkedList <Soldado>getSoldados(){
		return soldados;
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



	public boolean isMarcada() {
		return marcada;
	}
	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}
	public boolean marcar() {
	//	boolean retorno=false;
		
		boolean marcada= this.isMarcada();
		this.setMarcada(!marcada);
			return  this.isMarcada();
		
	}


	@Override
	public FichaFactory getFactory(Ejercito ejercito) {
		// TODO Auto-generated method stub
		return new BatallonFichaFactory(getId(), getCantidadSoldados(), ejercito);
		}

		public Soldado getSoldado() {
			return soldados.pop();
		}
		// si curamos soldados, los que tengan stamina critica pero mayor que cero
//		public Soldado getSoldado() {
//			Soldado pop = soldados.pop();
//			//usar la cola de soldados como una lista y preguntar (recorrer) si hay algun
//			//elemento no critico
//			while(pop.isCriticaStamina()) {
//				soldados.offer(pop);
//				pop=soldados.pop();
//			}
//			return pop;
//		}

		public void tratarSoldado(Soldado soldado) {
			// TODO Auto-generated method stub
			// nivel de stamina? critico o no
			if (!soldado.isCriticaStamina()) {
				soldados.offer(soldado);
			}
		}

		public boolean haySoldados() {
			return !soldados.isEmpty();
		}


	
	
	
	
}
