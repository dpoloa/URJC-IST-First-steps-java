package es.urjc.ist.coolcoffee;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class TiendaCoolCoffee {

	// Attributes
	ArrayList<Bebida> bebidasDiff = new ArrayList<Bebida>();
	
	// Getter methods
	public ArrayList<Bebida> getBebidaList() {
		return this.bebidasDiff;
	}
	
	// Auxiliary methods
	@Override
	public String toString() {
		String stringList = "";
		Iterator<Bebida> bebidasIterator = this.getBebidaList().iterator();
		while(bebidasIterator.hasNext()) {
			stringList = stringList + bebidasIterator.next().toString() + "\n";
		}
		return stringList;
	}
	
	public ArrayList<String> listToString() {
		ArrayList<String> stringBebidaList = new ArrayList<String>();
		Iterator<Bebida> bebidasIterator = this.getBebidaList().iterator();
		while(bebidasIterator.hasNext()) {
			stringBebidaList.add(bebidasIterator.next().toString());
		}
		return stringBebidaList;
	}
	
	// Business methods
	abstract Bebida crearBebida(String etiqueta);
	
	public Bebida pedirBebida(String tipo) {
		Bebida bebida = crearBebida(tipo);
		System.out.println("Sirviendo " + bebida);
		this.servirBebida(bebida);
		return bebida;
	}
	
	public void servirBebida(Bebida bebida) {
		if (! this.bebidasDiff.contains(bebida)) {
			this.bebidasDiff.add(bebida);
		}
	}
}
