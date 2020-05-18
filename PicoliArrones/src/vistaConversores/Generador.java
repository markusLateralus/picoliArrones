package vistaConversores;


import java.awt.event.FocusAdapter;

import java.util.ArrayList;
import java.util.Arrays;



import controlador.Juego;
import modelo.Batallon;

import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Especialidad;

import modelo.Tipo;
import modelo.Casilla;
import vista.EspecialidadSoldado;

import vistaInfo.FichaInfo;
import vistaInfo.EjercitoInfo;
import vistaInfo.EspecialidadSoldadoInfo;

import vistaInfo.MercadoSoldadosInfo;
import vistaInfo.TableroUIInfo;


public class Generador {

	//crea un panel del tipo de especialidad del soldado
	public static ArrayList<EspecialidadSoldado> getEspecialidades(Tipo tipo,FocusAdapter focus) {	
		ArrayList<EspecialidadSoldado> panelesEspecialidadSoldados=new ArrayList<EspecialidadSoldado>();
		for (Especialidad elemento: Arrays.asList(Especialidad.values())) { //LISTA DE LOS ENUMERADOS
			if(tipo==elemento.getTipo()) {
				panelesEspecialidadSoldados.add(new EspecialidadSoldado(new EspecialidadSoldadoInfo(elemento), focus));
			}
	
		}
		return panelesEspecialidadSoldados;
	}

	
	public static ArrayList<Tipo> getTipos(){
		ArrayList<Tipo>tipos=new ArrayList<Tipo>();
		tipos.addAll(Arrays.asList(Tipo.values()));
			return tipos;
			
	}
	
	public static MercadoSoldadosInfo getMercadoSoldadoInfo(Batallon batallon) {
		return new MercadoSoldadosInfo(batallon);
	}
	
	public static EjercitoInfo getNuevoEjercitoInfo(Ejercito ejercito) {
		return new EjercitoInfo(ejercito.getId(), ejercito.getIdBatallonActual(), ejercito.getTipoBatallon(),
				Ejercito.getInfanteria(), Ejercito.getCaballeria(), Ejercito.getArqueria());
	}

	public static EjercitoInfo getEjercitoInfo(Ejercito ejercito) {
		return new EjercitoInfo(ejercito.getId(), ejercito.getIdBatallonActual(), ejercito.getTipoBatallon(),
				ejercito.getInfanteria(), ejercito.getCaballeria(), ejercito.getArqueria());
	}
	
	
	


//	private static ArrayList<FichaInfo>getFichasInfo(Tablero tablero, ArrayList<Coordenada>coordenadas){
//		ArrayList<Casilla>casillas=tablero.getCasillas(coordenadas);
//		ArrayList<FichaInfo>fichasInfo=new ArrayList<FichaInfo>();
//		
//		for (int i = 0; i < casillas.size(); i++) {
//			if(casillas.get(i)!=null) {
//				Batallon batallon=(Batallon)casillas.get(i);
//				fichasInfo.add(new FichaInfo("/Imagenes/ligera.png", -1, batallon.getId(), -1,
//					-1, -1, -1, batallon.getMaximoSoldados(), false, Color.BLACK));
//			}
//		}
//		return fichasInfo;
//	}
	
	
	
//	public static ArrayList <JPanel> getFichas(Tablero tablero, ArrayList<Coordenada>coordenadas) {
//		ArrayList <FichaInfo>fichasInfo=getFichasInfo(tablero, coordenadas);
//		ArrayList <FichaBlanca>fichasBlancas=new ArrayList <FichaBlanca>();
//		ArrayList<JPanel>fichas=new ArrayList <JPanel>();
//		for (int i = 0; i < fichasInfo.size(); i++) {
//			if(fichasInfo.get(i)==null) {
//				FichaBlanca nueva=new FichaBlanca();
//				fichasBlancas.add(nueva);
//			}
//			else {
//				Ficha ficha=new Ficha(fichasInfo.get(i));
//				fichas.add(ficha);
//			}
//		}
//		return fichas;
//	}
	
	
	
	
}
