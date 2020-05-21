package vistaInfo;



import controlador.Juego;
import modelo.Casilla;
import modelo.Coordenada;




public class TableroUIInfo {


	private Juego juego;

	public TableroUIInfo(Juego juego) {
		super();
		this.juego=juego;
	
	}

	
	
	public FichaFactory[][] getFichasInfo(){
		FichaFactory[][] fichasInfo=new FichaFactory[juego.getAlto()][juego.getAncho()];
		for (int i = 0; i < fichasInfo.length; i++) {
			for (int j = 0; j < fichasInfo[i].length; j++) {
				fichasInfo[i][j]=getFichaInfo(juego, new Coordenada(i, j));
			}
		}
		return fichasInfo;
	}
public FichaFactory getFichaInfo(Juego juego, Coordenada coordenada) {
		
		Casilla casilla = juego.getCasilla(coordenada);
		return casilla.getFactory(juego.getEjercitoActual());
	}

	
	

//	
//	public FichaBatallonInfo[][] getFichasInfo(){
//		FichaBatallonInfo[][] fichasFichaInfo=new FichaBatallonInfo[tablero.getAncho()][tablero.getAlto()];
//		for (int i = 0; i < fichasFichaInfo.length; i++) {
//			for (int j = 0; j < fichasFichaInfo[i].length; j++) {
//				fichasFichaInfo[i][j]=Generador.getFichaBatallonInfo(tablero, new Coordenada(i,j));
//			}
//		}
//		return fichasFichaInfo;
//	}
	
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
	
	
	

