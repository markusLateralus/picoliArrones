package modelo;

import java.util.HashMap;

public class Matriz<K,E> {
	//vamos a hacer una matriz bidireccional
	private int ancho, alto;
	HashMap<K, E> elements = new HashMap<K, E>();
	HashMap<E,K> reverse = new HashMap<E,K>();

	public Matriz(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
	}

	public E insertElement(K coordinate, E element) {
		E put = elements.put(coordinate, element);
		reverse.put(element, coordinate);
		return put;
	}

	public E getElement(K coord) {
		return elements.get(coord);
	}
	
	public K getClave(E element) {
		return reverse.get(element);
	}
	public boolean contieneElemento(E e) {
		// TODO Auto-generated method stub
		return getClave(e)!=null;
	}

	public boolean contieneClave(K k) {
		// TODO Auto-generated method stub
		return getElement(k)!=null;
	}

	public boolean borrar(E casilla) {
		// TODO Auto-generated method stub
		E remove=elements.remove(reverse.remove(casilla));
		return remove!=null;
		
	}
}
