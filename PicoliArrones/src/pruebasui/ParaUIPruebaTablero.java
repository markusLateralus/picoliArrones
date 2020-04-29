package pruebasui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import controlador.IniciadorController;
import controlador.Juego;

import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;
import vistaConversores.Generador;


public class ParaUIPruebaTablero extends TableroUIPrueba{


	IniciadorController iniciadorController;
	public ParaUIPruebaTablero() {
		super();
		Juego juego=new Juego();
		iniciadorController=new IniciadorController(juego);
		this.getBordeArmada();
		this.getTableroUI().setMouseAdapter(mouseAdapter);
		this.getTableroUI().actualizarTablero(Generador.getTableroUIIinfo(juego));
	}
	
	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JPanel panel = (JPanel) e.getSource();
			panel.setBackground(Color.YELLOW);
			Coordenada coordenada=Utiles.getCoordenada(panel.getName());
			if(!iniciadorController.localizar(coordenada)) {
				System.out.println("error");
			}
			getTableroUI().actualizarTablero(Generador.getTableroUIIinfo(iniciadorController.getJuego()));
			// Por esta razon el mouseAdapter tiene que ser una propiedad del tableroui
//			tableroUI.actualizarTablero(mouseAdapter);
//			tableroUI.actualizarTablero();
		}
	};
}
