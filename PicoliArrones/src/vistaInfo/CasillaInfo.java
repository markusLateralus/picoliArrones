package vistaInfo;

import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import vista.TableroUI;

public interface CasillaInfo {
	
	
	public Casilla getCasilla();
	public CasillaInfo crearFichaInfo(Casilla casilla); 
}
