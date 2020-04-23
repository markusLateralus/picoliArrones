package modelo;

import java.util.LinkedList;

public class Ejercito implements Casilla{

	private int id;
	private static int infanteria=1;
	private static int caballeria=1;
	private static int arqueria=1;
	private int idBatallonActual=0;
	LinkedList<Batallon>grupo=new LinkedList<Batallon>();
	Batallon batallon;
	
	public Ejercito(int id) {
		// TODO Auto-generated constructor stub
		this.id=id;
		crearEjercito();
	}
	public Ejercito(int id, Batallon batallon) {
		// TODO Auto-generated constructor stub
		this.id=id;
		crearEjercito2(batallon);
	}
	
		
	private void crearEjercito2(Batallon batallon) {
		grupo.add(batallon);
	}
	private void crearEjercito() {
		// TODO Auto-generated method stub
			int j=0;
			for (int i = 0; i < infanteria; i++) {
				grupo.add(new Batallon(j++,Tipo.INFANTERIA));
			}
			for (int i = 0; i < caballeria; i++) {
				grupo.add(new Batallon(j++,Tipo.CABALLERIA));
			}
			for (int i = 0; i < arqueria; i++) {
				grupo.add(new Batallon(j++,Tipo.ARQUERIA));
			}
	}

public Batallon getBatallon(Tipo tipo) {
	Batallon batallon;
	if(grupo.size()!=0) {
	for (int i = 0; i < grupo.size(); i++) {
		if(tipo.equals(grupo.get(i).getTipo())) {
			 batallon=grupo.get(i);
			 return batallon;
		}
	}
	}
	return null;
}





	public int getIdBatallonActual() {
		return idBatallonActual;
	}



	public void setIdBatallonActual(int idBatallonActual) {
		this.idBatallonActual = idBatallonActual;
	}



	public Tipo getTipoBatallon() {
		if(grupo.size()!=0) {
		return getBatallonActual().getTipo();
		}
		return null;
	}
	
	public Batallon getBatallonActual() {
		if(grupo.size()!=0) {
			return grupo.get(idBatallonActual);
		}
		return null;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public static void setInfanteria(int infanteria) {
		Ejercito.infanteria = infanteria;
	}

	public static void setCaballleria(int caballeria) {
		Ejercito.caballeria = caballeria;
	}

	public static void setArqueria(int arqueria) {
		Ejercito.arqueria = arqueria;
	}

	public void setGrupo(LinkedList<Batallon> grupo) {
		this.grupo = grupo;
	}

	public int getId() {
		return id;
	}

	public static int getInfanteria() {
		return infanteria;
	}

	public static int getCaballleria() {
		return caballeria;
	}

	public static int getArqueria() {
		return arqueria;
	}

	public LinkedList<Batallon> getGrupo() {
		return grupo;
	}
	
	
	
}
