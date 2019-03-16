package es.urjc.ist.coolcoffee;

public class Crema extends IngredienteDecorator{
	
	// Constructor
	public Crema (Bebida bebida) {
		this.setDescripcion("Crema");
		this.setCoste(0.30);
		this.setBebida(bebida);
	}

}
