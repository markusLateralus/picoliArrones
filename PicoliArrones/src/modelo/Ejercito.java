package modelo;


import java.awt.Color;
import java.util.LinkedList;



public class Ejercito{

	private int id;
	private static int infanteria = 1;
	private static int caballeria = 1;
	private static int arqueria = 1;
	private int idBatallonActual = 0;
	private Batallon primerBatallon;

	LinkedList<Batallon> batallones = new LinkedList<Batallon>();
	
	
	public Ejercito(int id) {
		super();
		this.id = id;
		crearEjercito();
	}

	public boolean setSiguienteBatallon() {
		batallones.offer(batallones.poll());  //poner a la cola el ejercito que está primero. CAMBIAR TURNO
		return !batallones.peek().equals(primerBatallon);
	}

	private void crearEjercito() {
		int j=0;
		for (int i = 0; i < infanteria; i++) {
			batallones.offer(new Batallon(j++,Tipo.INFANTERIA));
		}
		for (int i = 0; i < caballeria; i++) {
			batallones.offer(new Batallon(j++,Tipo.CABALLERIA));

		}
		for (int i = 0; i < arqueria; i++) {
			batallones.offer(new Batallon(j++,Tipo.ARQUERIA));
		}
		this.primerBatallon=batallones.peek();
	}

	public int getId() {
		return id;
	}

	public static int getInfanteria() {
		return infanteria;
	}

	public static int getCaballeria() {
		return caballeria;
	}

	public static int getArqueria() {
		return arqueria;
	}

	public Tipo getTipoBatallon() {
		return getBatallonActual().getTipo();
	}


	public Batallon getBatallonActual() {
		return batallones.get(idBatallonActual);
	}

	public int getIdBatallonActual() {
		return getBatallonActual().getId();
	}

	public String getIcon() {
		// TODO Auto-generated method stub
		return " ";
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.black;
	}
	
}
