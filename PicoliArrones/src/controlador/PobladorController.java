package controlador;

import java.util.LinkedList;
import java.util.List;

import modelo.Batallon;
import modelo.Ejercito;
import modelo.Soldado;
import vistaInfo.EspecificacionSoldadosInfo;

public class PobladorController {

	
	private Batallon batallon;
	private Ejercito ejercito;
	private Soldado soldado;
	
	
	
	public PobladorController(Batallon batallon, Ejercito ejercito) {
		// TODO Auto-generated constructor stub
		this.batallon=batallon;
		this.ejercito= ejercito;


	}
	
	public void poblarBatallon(List <EspecificacionSoldadosInfo> especificacion) {
		assert especificacion!=null;
		for (EspecificacionSoldadosInfo especificacionSoldadosInfo : especificacion) {
			for (int i = 0; i < especificacionSoldadosInfo.getCantidad(); i++) {
				this.batallon.alistarSoldado(new Soldado(especificacionSoldadosInfo.getEspecialidad()));
			
			}
		}
	}

	public Batallon getBatallon() {
		return batallon;
	}

public void agregarAlEjercito(Batallon batallon){
	
	ejercito.getGrupo().add(batallon);
	
}
public LinkedList <Batallon> getBatallones(){
	return ejercito.getGrupo();
}
public void setEjercito(Ejercito ejercito) {
	this.ejercito=ejercito;
}
public Ejercito getEjercito() {
	return ejercito;
}


	
}
