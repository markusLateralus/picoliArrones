package modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

import controlador.Juego;
import vistaInfo.CasillaInfo;
import vistaInfo.FichaBatallonInfo;

public class Batallon implements Casilla {

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


	@Override
	public Casilla crear(Tablero tablero, Coordenada coordenada) {
		// TODO Auto-generated method stub
		Casilla casilla = tablero.getCasilla(coordenada);
		Batallon batallon=null;
	//	FichaBatallonInfo fichaInfo=null;
		if(casilla!=null) {
			for (int i = 0; i < tablero.getCoordenadasCastillos().length; i++) {
				Coordenada aux=tablero.getCoordenadasCastillos()[i];
				if(!aux.equals(coordenada)) {
					batallon=(Batallon)casilla;
		//			return new FichaBatallonInfo("/Imagenes/ligera.png", -1, batallon.getId(), -1,
			//			-1, -1, -1, batallon.getMaximoSoldados(), false, Color.BLACK);
				return batallon;
				}
			}
		
		
		}
		return null;
	}



	
	
	
	
}
