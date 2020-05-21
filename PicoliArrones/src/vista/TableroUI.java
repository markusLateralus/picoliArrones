package vista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Coordenada;
import utiles.Utiles;
import vistaInfo.FichaFactory;
import vistaInfo.TableroUIInfo;


public class TableroUI extends JPanel {

	// Cada una de las casillas representadas en el tablero
	private JPanel[][] fichas; // usamos una matriz
	private MouseAdapter mouseAdapter;
	private MouseAdapter mouseAdapter2;
	MouseMotionAdapter mouseMotion;

	/**
	 * Create the panel.
	 */
	public TableroUI(int ancho, int alto) {
		super();

		// this.mouseAdapter = mouseAdapter;
		fichas = new JPanel[alto][ancho];
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(alto, ancho, 0, 0));
		// actualizarTablero(tableroUIInfo);
	}

	
	
	public void actualizarTablero(TableroUIInfo tableroUIInfo) { // se le añade el MouseListener y se agrega al PANEL
		removeAll();
		FichaFactory[][] fichasInfo = tableroUIInfo.getFichasInfo();
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[i].length; j++) {				
			fichas[i][j] =  getFicha(fichasInfo[i][j]);
				fichas[i][j].setName(Utiles.nombrar(i, j));
				fichas[i][j].addMouseListener(mouseAdapter);
				fichas[i][j].addMouseMotionListener(mouseAdapter2);
				add(fichas[i][j]);
			}
		
		}
		revalidate();
	}
	


	
	
	public JPanel getFicha(FichaFactory fichaFactory) {
		return fichaFactory.getPanel();
	//	return new FichaBatallon(casillaInfo);
	}	
	
	
	
	
	public void setMouseAdapter(MouseAdapter mouseAdapter) {
		this.mouseAdapter = mouseAdapter;
//	actualizarTablero(tableroUIInfo);
	}

	public Coordenada obtenCoordenada(String name) {
		int pos = name.length() / 2;
		return new Coordenada(Integer.valueOf(name.substring(0, pos)),
				Integer.valueOf(name.substring(pos, name.length())));
	}



	public void setMouseMotion(MouseMotionAdapter mouseMotion) {
		this.mouseMotion=mouseMotion;
		
	}



	public void setMouseAdapter2(MouseAdapter mouseAdapter2) {
		// TODO Auto-generated method stub
		this.mouseAdapter2=mouseAdapter2;
	}
}
