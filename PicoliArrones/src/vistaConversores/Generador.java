package vistaConversores;

import java.util.ArrayList;
import java.util.Arrays;

import ensayos.EspecialidadSoldados;
import modelo.Especialidad;
import modelo.Tipo;

public class Generador {

	//crea un panel del tipo de especialidad del soldado
	public static ArrayList<EspecialidadSoldados> getEspecialidadesEnsayo(Tipo tipo) {
		// TODO Auto-generated method stub
		
		ArrayList<EspecialidadSoldados> panelesEspecialidadSoldados=new ArrayList<EspecialidadSoldados>();
		for (Especialidad elemento: Arrays.asList(Especialidad.values())) { //LISTA DE LOS ENUMERADOS
			if(tipo==elemento.getTipo()) {
				panelesEspecialidadSoldados.add(new EspecialidadSoldados(elemento));
			}
	
		}
		return panelesEspecialidadSoldados;
	}

	
}
