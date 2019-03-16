package es.urjc.ist.coolcoffee;

public class Leche extends IngredienteDecorator{
	
	// Constructor
	public Leche (Bebida bebida) {
		this.setDescripcion("Leche");
		this.setCoste(0.20);
		this.setBebida(bebida);
	}

}
