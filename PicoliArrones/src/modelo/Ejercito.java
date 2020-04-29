package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Ejercito implements Comparable <Ejercito>{


	private Stack <Batallon>batallones=new Stack<Batallon>();
	private int id;
	private Batallon batallonTipoArqueria;
	private Batallon batallonTipoInfanteria;
	private Batallon batallonTipoCaballeria;
	private static int infanteria = 1;
	private static int caballeria = 1;
	private static int arqueria = 1;
	private int idBatallonActual = 0;
	public Ejercito(int id) {
		this.id=id;
		//this.batallon=batallon;
	  crearEjercito();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}
private Stack<Batallon> crearEjercito() {
	
	batallonTipoArqueria=new Batallon(1,Tipo.ARQUERIA);
	batallonTipoArqueria.alistarSoldado(new Soldado(Especialidad.ARCO));
	batallonTipoArqueria.alistarSoldado(new Soldado(Especialidad.BALLESTA));
	
	batallonTipoCaballeria=new Batallon(2,Tipo.CABALLERIA);
	batallonTipoCaballeria.alistarSoldado(new Soldado(Especialidad.LIGERA));
	batallonTipoCaballeria.alistarSoldado(new Soldado(Especialidad.PESADA));
	
	batallonTipoInfanteria=new Batallon(3,Tipo.INFANTERIA);
	batallonTipoInfanteria.alistarSoldado(new Soldado(Especialidad.DANZA));
	batallonTipoInfanteria.alistarSoldado(new Soldado(Especialidad.ESPADA));
	
	batallones.push(batallonTipoArqueria);
	batallones.push(batallonTipoCaballeria);
	batallones.push(batallonTipoInfanteria);
	return batallones;
	
}
public boolean setSiguienteBatallon() {
	boolean respuesta=false;
	
	if(++idBatallonActual<batallones.size()) {
		respuesta=true;
	}
	else {
		idBatallonActual=0;
	}
	return respuesta;
	
}

public Stack<Batallon>getBatallones(){
	return batallones;
}

public Batallon getUltimoBatallon() {
	return batallones.peek();
}
public void borrarUltimoBatallon() {
	batallones.pop();
}


public Batallon getBatallonTipoArqueria() {
	return batallonTipoArqueria;
}

public Batallon getBatallonTipoInfanteria() {
	return batallonTipoInfanteria;
}

public Batallon getBatallonTipoCaballeria() {
	return batallonTipoCaballeria;
}
public static int getInfanteria() {
	return infanteria;
}

public static int getCaballeria() {
	return caballeria;
}

public static int getArqueria() {
	return arqueria;
}

public int getIdBatallonActual() {
	return idBatallonActual;
}

public Tipo getTipoBatallon() {
	return getBatallonActual().getTipo();
}

public Batallon getBatallonActual() {
	return batallones.get(idBatallonActual);
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Ejercito other = (Ejercito) obj;
	if (id != other.id)
		return false;
	return true;
}
@Override
public int compareTo(Ejercito o) {
	// TODO Auto-generated method stub
	int resultado=new Integer(o.id).compareTo(new Integer(id));
	return resultado;
}



}
