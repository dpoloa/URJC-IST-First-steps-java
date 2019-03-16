package es.urjc.ist.coolcoffee;

public class Chocolate extends IngredienteDecorator{
	
	// Constructor
	public Chocolate (Bebida bebida) {
		this.setDescripcion("Chocolate");
		this.setCoste(0.30);
		this.setBebida(bebida);
	}

}
