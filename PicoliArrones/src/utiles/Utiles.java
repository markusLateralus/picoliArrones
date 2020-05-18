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
	public static int[] damePosicionAlrededor(int lugar) {
		int[][] posicion = { { -1, -1 }, { -1, 0 }, { -1, +1 }, { 0, -1 }, { 0, +1 }, { +1, -1 }, { +1, 0 },
				{ +1, +1 } };
		return posicion[lugar];
	}
	public static float getAleatorioSesgado(int min,int max,float porcentajeSesgo) {
		assert max>min&& min>=0;
		int valor=(int)((Math.random()*((max+1)-min))+min);
		float valor2= valor * porcentajeSesgo;
	     if(valor2>=7) {
	    	 valor2=6;
	         	return (int)valor2;
	        }
		return valor2;
	}
	
	
    public  int tirarDadoDefensor(float sesgo) {
        double resultado;
        resultado=Math.random()*6 +1;
        resultado=resultado* sesgo;// Se le suma 1 si el valor del 0 es 10. 
        if(resultado>=7) {
        	resultado=6;
         	return (int)resultado;
        }
        return (int)resultado;
    }
    public static int getAleatorio() {
        double resultado;
        resultado=Math.random()*6 +1;
        return (int)resultado;
    }
	
	
	
	
	
}
