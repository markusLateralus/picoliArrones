package vistaInfo;

import modelo.Batallon;
import modelo.Tipo;

public class BatallonInfo {

	private int id;
	private Tipo tipo;
	private int maximoSoldados;
	
	public BatallonInfo(Batallon batallon) {
		this.id=batallon.getId();
		this.tipo=batallon.getTipo();
		this.maximoSoldados=batallon.getMaximoSoldados();
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

	public void setMaximoSoldados(int maximoSoldados) {
		this.maximoSoldados = maximoSoldados;
	}
	
	
	
}
