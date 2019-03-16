package es.urjc.ist.coolcoffee;

public class Descafeinado extends Bebida{

	// Attributes are not added
	
	// Constructor
	public Descafeinado () {
		this.setDescripcion("Descafeinado");
		this.setCantidad(1);
		this.setCoste(1.10);
	}
	
	public Descafeinado (int cantidad) {
		this.setDescripcion("Descafeinado");
		this.setCantidad(cantidad);
		this.setCoste(1.10);
	}
	
}
