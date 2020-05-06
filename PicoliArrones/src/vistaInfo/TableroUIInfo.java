package vistaInfo;

import java.util.ArrayList;

import javax.swing.JPanel;

import controlador.Juego;
import modelo.Coordenada;
import modelo.Tablero;
import vista.FichaBlanca;
import vistaInfo.FichaBatallonInfo;
import vistaConversores.Generador;

public class TableroUIInfo {

	private Tablero tablero;


	public TableroUIInfo(Tablero tablero) {
		super();
		this.tablero = tablero;
	
	}
	

	
	public FichaBatallonInfo[][] getFichasInfo(){
		FichaBatallonInfo[][] fichasFichaInfo=new FichaBatallonInfo[tablero.getAncho()][tablero.getAlto()];
		for (int i = 0; i < fichasFichaInfo.length; i++) {
			for (int j = 0; j < fichasFichaInfo[i].length; j++) {
				fichasFichaInfo[i][j]=Generador.getFichaBatallonInfo(tablero, new Coordenada(i,j));
			}
		}
		return fichasFichaInfo;
	}
	
//	public void colocarEjercito(JPanel fichas[][]) {
//		ArrayList<Coordenada>coordenadas=new ArrayList<Coordenada>();
//		
//		for (int i = 0; i < fichas.length; i++) {
//			for (int j = 0; j < fichas[i].length; j++) {
//				Coordenada coordenada=new Coordenada(i,j);
//				 coordenadas.add(coordenada);
//				 ArrayList <JPanel>paneles=Generador.getFichas(tablero,coordenadas);
//				 for (int k = 0; k < fichas.length; k++) {
//					for (int k2 = 0; k2 < paneles.size(); k2++) {
//						fichas[k][k2]=paneles.get(k2);
//					}
//				}
//				 //fichas[i][j] = fichaInfo;
////						fichas[i][j].addMouseListener(mouseAdapter);
//
//			}
//		}
	}
	
	
	

