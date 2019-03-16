package es.urjc.ist.coolcoffee;

public class Expresso extends Bebida{

	// Attributes are not added
	
	// Constructor
	public Expresso () {
		this.setDescripcion("Expresso");
		this.setCantidad(1);
		this.setCoste(1.30);
	}
	
	public Expresso (int cantidad) {
		this.setDescripcion("Expresso");
		this.setCantidad(cantidad);
		this.setCoste(1.30);
	}

}
