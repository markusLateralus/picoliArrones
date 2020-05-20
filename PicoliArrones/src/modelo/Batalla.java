package modelo;

import java.util.HashSet;
import java.util.Iterator;

public class Batalla {

	//este tipo de coleccion NO repite valores y no los ordena
	private HashSet<Ataque>ataques=new HashSet<Ataque>();
	private Tablero tablero;
	
	public Batalla(Tablero tablero) {
		this.tablero=tablero;
	}
	public boolean insertarAtaque(Batallon defensor, Batallon atacante) {
		assert ataques.size()>0:"lista ataques llena";
		return ataques.add(new Ataque(defensor, atacante));
		
	}
	public void guerrear() {
		for (Iterator iterator = ataques.iterator(); iterator.hasNext();) {
			Ataque ataque = (Ataque) iterator.next();
			if(ataque.combatir()) {
				if(ataque.isAtacanteVencedor()) {
					tablero.conquistar(ataque.getAtacante(), ataque.getDefensor());
				}
				else {
					tablero.borrar(ataque.getAtacante());
				}
			}
			iterator.remove();
		}
	}
	
}
