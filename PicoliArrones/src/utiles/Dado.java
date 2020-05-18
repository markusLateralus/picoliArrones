package utiles;

import java.util.ArrayList;

public class Dado {
	
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
    public  int tirarDadoAtacante() {
        double resultado;
        resultado=Math.random()*6 +1;
        return (int)resultado;
    }
    



}
