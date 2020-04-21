package controlador;

import java.util.List;

import modelo.Batallon;
import modelo.Soldado;
import vistaInfo.EspecificacionSoldadosInfo;

public class PobladorController {

	
	private Batallon batallon;
	
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

	public void setBatallon(Batallon batallon) {
		this.batallon = batallon;
	}
	
	
}
