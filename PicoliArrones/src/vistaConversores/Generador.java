package vistaConversores;

import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import modelo.Especialidad;
import modelo.Tipo;
import vista.EspecialidadSoldado;
import vistaInfo.EspecialidadSoldadoInfo;


public class Generador {

	//crea un panel del tipo de especialidad del soldado
	public static ArrayList<EspecialidadSoldado> getEspecialidadesEnsayo(Tipo tipo,FocusAdapter focus) {	
		ArrayList<EspecialidadSoldado> panelesEspecialidadSoldados=new ArrayList<EspecialidadSoldado>();
		for (Especialidad elemento: Arrays.asList(Especialidad.values())) { //LISTA DE LOS ENUMERADOS
			if(tipo==elemento.getTipo()) {
				panelesEspecialidadSoldados.add(new EspecialidadSoldado(new EspecialidadSoldadoInfo(elemento), focus));
			}
	
		}
		return panelesEspecialidadSoldados;
	}

	
//	public static ArrayList<TipoSoldados> getTipos(Tipo tipo){
//		
//	}
	
}
