package vistaInfo;

import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Casilla;
import modelo.Castillo;
import modelo.Coordenada;
import modelo.Tablero;
import vista.FichaBatallon;
import vista.FichaCastillo;
import vista.TableroUI;

public class FichaCastilloInfo implements CasillaInfo{

	private int idEjercito;
	
	
	public FichaCastilloInfo(int idEjercito) {

		this.idEjercito=idEjercito;
	}
	public int getIdEjercito() {
		return this.idEjercito;
	}
	
	@Override
	public Casilla getCasilla() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CasillaInfo crearFichaInfo(Casilla casilla) {
		// TODO Auto-generated method stub
		Castillo castillo=(Castillo) casilla;
		return new FichaCastilloInfo(castillo.getEjercito().getId());
	}



}
