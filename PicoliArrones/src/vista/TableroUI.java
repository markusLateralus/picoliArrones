package vista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Juego;
import modelo.Coordenada;
import modelo.Dimension;
import utiles.Utiles;
import vistaInfo.FichaBatallonInfo;
import vistaInfo.FichaCastilloInfo;
import vistaInfo.TableroUIInfo;

public class TableroUI extends JPanel {

	// Cada una de las casillas representadas en el tablero
	private JPanel[][] fichas; //usamos una matriz
	private MouseAdapter mouseAdapter;
	private Dimension dimension;
	private int ancho, alto;

	/**
	 * Create the panel.
	 */
	public TableroUI(Dimension dimension) {
		super();
		this.dimension=dimension;
		this.alto=dimension.getAlto();
		this.ancho=dimension.getAncho();
		//this.mouseAdapter = mouseAdapter;
		fichas = new JPanel[dimension.getAncho()][dimension.getAlto()];
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(ancho, alto, 0, 0));
		//actualizarTablero(tableroUIInfo);
	}

	public void actualizarTablero(TableroUIInfo tableroUIInfo) { //se le añade el MouseListener y se agrega al PANEL
		removeAll();
		FichaBatallonInfo [][] fichasInfo=tableroUIInfo.getFichasInfo();
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[i].length; j++) {
				fichas[i][j] = getFicha(fichasInfo[i][j]);
				fichas[i][j].setName(Utiles.nombrar(i, j));
				fichas[i][j].addMouseListener(mouseAdapter);
				add(fichas[i][j]);
			}
		}
		revalidate();
	}
	
	
	public  JPanel getFicha(FichaBatallonInfo fichaInfo) {
		if(fichaInfo==null) {
			return new FichaBlanca();
		}
		return new Ficha(fichaInfo);
	}
	
//	public  JPanel getFicha(FichaCastilloInfo fichaInfo) {
//		if(fichaInfo==null) {
//			return new FichaBlanca();
//		}
//		return new FichaCastillo(fichaInfo);
//	}
public void setMouseAdapter(MouseAdapter mouseAdapter) {
	this.mouseAdapter=mouseAdapter;
//	actualizarTablero(tableroUIInfo);
}

	public  Coordenada obtenCoordenada(String name) {
		int pos = name.length() / 2;
		return new Coordenada(Integer.valueOf(name.substring(0, pos)),
				Integer.valueOf(name.substring(pos, name.length())));
	}
}
