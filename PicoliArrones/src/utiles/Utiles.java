package utiles;

import modelo.Coordenada;

public class Utiles {
//
//	public static String dameMiNombre(int i, int j) {
//		String si=completaNumero(i);
//		String sj=completaNumero(j);
//		return (si + sj);
//	}
//
//	private static String completaNumero(int j) {
//		// TODO Auto-generated method stub
//		String retorno="";
//		if(j<10) {
//			retorno="0";
//		}
//		retorno +=String.valueOf(j);
//		return retorno;
//	}
//	
//	public static int[] getValores(String coordenada) {
//		int [] response=new int[2];
//		response[0]=Integer.parseInt(coordenada.substring(0, coordenada.length()/2));
//		response[1]=Integer.parseInt(coordenada.substring(coordenada.length()/2, coordenada.length()));
//		return response;
//	}
	
	public static String nombrar(int i, int j) {
		return String.valueOf(i)+":"+String.valueOf(j);
	}
	
	public static Coordenada getCoordenada(String coordenada){
		
		String[] split=coordenada.split(":");
		return new Coordenada(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
	}
		
}
