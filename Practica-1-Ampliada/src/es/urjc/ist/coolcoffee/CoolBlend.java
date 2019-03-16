package es.urjc.ist.coolcoffee;

public class CoolBlend extends Bebida {

	// Attributes are not added
	
	// Constructor
	public CoolBlend (){
		this.setDescripcion("CoolBlend");
		this.setCantidad(1);
		this.setCoste(1.20);
	}
	
	public CoolBlend (int cantidad){
		this.setDescripcion("CoolBlend");
		this.setCantidad(cantidad);
		this.setCoste(1.20);
	}

}
