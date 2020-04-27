package vista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Juego;
import modelo.Coordenada;
import vistaInfo.TableroUIInfo;

public class TableroUI extends JPanel {

	// Cada una de las casillas representadas en el tablero
	private JPanel[][] fichas; //usamos una matriz
	private MouseAdapter mouseAdapter;
	private String nombre;
	private Juego juego;

	/**
	 * Create the panel.
	 */
	public TableroUI(MouseAdapter mouseAdapter,TableroUIInfo tableroUIInfo, Juego juego) {
		super();
		this.juego=juego;
		this.mouseAdapter = mouseAdapter;
		fichas = new JPanel[tableroUIInfo.getAncho()][tableroUIInfo.getAlto()];
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(tableroUIInfo.getAncho(), tableroUIInfo.getAlto(), 0, 0)); //layaout tipo MAYA
		actualizarTablero(tableroUIInfo);
	}

	public void actualizarTablero(TableroUIInfo tableroUIInfo) { //se le añade el MouseListener y se agrega al PANEL
		removeAll();//borrar todo
		tableroUIInfo.getFichas(fichas,this.juego);
		
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[i].length; j++) {
				JPanel casilla = fichas[i][j];
				casilla.setName(i + ""+ j);
				casilla.addMouseListener(mouseAdapter);
				add(casilla);
			}
		}
		revalidate();//
	}
	
	
public JPanel[][] getFichas() {
		return fichas;
	}


	public  Coordenada obtenCoordenada(String name) {
		int pos = name.length() / 2;
		return new Coordenada(Integer.valueOf(name.substring(0, pos)),
				Integer.valueOf(name.substring(pos, name.length())));
	}
}
