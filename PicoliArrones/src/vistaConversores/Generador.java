package vistaConversores;

import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.Batallon;
import modelo.Ejercito;
import modelo.Especialidad;
import modelo.Tipo;
import vista.BordeArmada;
import vista.EspecialidadSoldado;
import vista.MercadoTipoDialog;
import vistaInfo.EjercitoInfo;
import vistaInfo.EspecialidadSoldadoInfo;
import vistaInfo.MercadoSoldadosInfo;


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
	public static ArrayList<Especialidad> getEspecialidad(Tipo tipo) {	
		ArrayList<Especialidad> EspecialidadSoldados=new ArrayList<Especialidad>();
		for (Especialidad elemento: Arrays.asList(Especialidad.values())) { //LISTA DE LOS ENUMERADOS
			if(tipo==elemento.getTipo()) {
				EspecialidadSoldados.add(elemento);
			}
	
		}
		return EspecialidadSoldados;
	}
	
	public static ArrayList<Tipo> getTipos(){
		ArrayList<Tipo>tipos=new ArrayList<Tipo>();
		tipos.addAll(Arrays.asList(Tipo.values()));
		return tipos ;
	
		
			
	}
	
	public static MercadoSoldadosInfo getMercadoSoldadoInfo(Batallon batallon) {
		return new MercadoSoldadosInfo(batallon);
	}
	
	
	public static EjercitoInfo getNuevoEjercitoInfo(Ejercito ejercito) {
		return new EjercitoInfo(ejercito.getId(), ejercito.getIdBatallonActual(), ejercito.getTipoBatallon(),
				Ejercito.getInfanteria(), Ejercito.getCaballleria(), Ejercito.getArqueria());
	}
	public static EjercitoInfo getEjercitoInfo(	Ejercito ejercito) {
		EjercitoInfo ejercitoInfo= new EjercitoInfo();		
		ejercitoInfo.setEjercitoID(ejercito.getId());
		ejercitoInfo.setIdBattallonActual(ejercito.getIdBatallonActual());
				ejercitoInfo.setTipoActual(ejercito.getTipoBatallon());
				ejercitoInfo.setInfanteria(Ejercito.getInfanteria());
				ejercitoInfo.setCaballeria(Ejercito.getCaballleria()); 
				ejercitoInfo.setArqueria(Ejercito.getArqueria());
	
	return ejercitoInfo;
	}
	
}
