package vista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Juego;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Dimension;
import modelo.Tablero;
import utiles.Utiles;
import vistaInfo.CasillaInfo;
import vistaInfo.FichaBatallonInfo;
import vistaInfo.FichaCastilloInfo;
import vistaInfo.TableroUIInfo;

public class TableroUI extends JPanel {

	// Cada una de las casillas representadas en el tablero
	private Ficha[][] fichas; // usamos una matriz
	private MouseAdapter mouseAdapter;
	private Dimension dimension;
	private int ancho, alto;

	/**
	 * Create the panel.
	 */
	public TableroUI(Dimension dimension) {
		super();
		this.dimension = dimension;
		this.alto = dimension.getAlto();
		this.ancho = dimension.getAncho();
		// this.mouseAdapter = mouseAdapter;
		fichas = new Ficha[dimension.getAncho()][dimension.getAlto()];
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(ancho, alto, 0, 0));
		// actualizarTablero(tableroUIInfo);
	}

	
	
	public void actualizarTablero(TableroUIInfo tableroUIInfo) { // se le añade el MouseListener y se agrega al PANEL
		removeAll();
		CasillaInfo[][] fichasInfo = tableroUIInfo.getFichasInfo();
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[i].length; j++) {
			
				
			fichas[i][j] =  getFicha(fichasInfo[i][j]);
				fichas[i][j].setName(Utiles.nombrar(i, j));
				fichas[i][j].addMouseListener(mouseAdapter);
				add(fichas[i][j]);
			}
		
		}
		revalidate();
	}
	
//	public void actualizarTablero(TableroUIInfo tableroUIInfo) { // se le añade el MouseListener y se agrega al PANEL
//		removeAll();
//		FichaBatallonInfo[][] fichasInfo = tableroUIInfo.getFichasInfo();
//		for (int i = 0; i < fichas.length; i++) {
//			for (int j = 0; j < fichas[i].length; j++) {
//				fichas[i][j] = getFicha(fichasInfo[i][j]);
//				fichas[i][j].setName(Utiles.nombrar(i, j));
//				fichas[i][j].addMouseListener(mouseAdapter);
//				add(fichas[i][j]);
//			}
//		}
//		revalidate();
//	}

	
	
	public Ficha getFicha(CasillaInfo casillaInfo) {
		if (casillaInfo == null) {
			return new FichaBlanca();
		}
		return new Ficha(casillaInfo);
	//	return new FichaBatallon(casillaInfo);
	}	
	
	
	
//	
//	public JPanel getFicha(FichaBatallonInfo fichaInfo) {
//		if (fichaInfo == null) {
//			return new FichaBlanca();
//		}
//		return new FichaBatallon(fichaInfo);
//	}
//
//	public JPanel getFicha(FichaCastilloInfo fichaCastillo) {
//		if (fichaCastillo == null) {
//			return new FichaBlanca();
//		}
//		return new FichaCastillo(fichaCastillo);
//	}

	
	
	
	
	public void setMouseAdapter(MouseAdapter mouseAdapter) {
		this.mouseAdapter = mouseAdapter;
//	actualizarTablero(tableroUIInfo);
	}

	public Coordenada obtenCoordenada(String name) {
		int pos = name.length() / 2;
		return new Coordenada(Integer.valueOf(name.substring(0, pos)),
				Integer.valueOf(name.substring(pos, name.length())));
	}
}
