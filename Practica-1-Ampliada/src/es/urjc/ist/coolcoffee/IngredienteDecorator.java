package es.urjc.ist.coolcoffee;

import java.util.Objects;
import java.text.DecimalFormat;

public abstract class IngredienteDecorator extends Bebida{
	
	// Attributes
	private Bebida bebida;
	
	// Constructor is not needed

	// Getter methods
	@Override
	public String getDescripcion() {
		return this.bebida.getDescripcion() + " con " + super.getDescripcion();
	}
	
	@Override
	public int getCantidad() {
		return this.bebida.getCantidad();
	}
	
	@Override
	public double getCoste() {
		return this.bebida.getCoste() + super.getCoste();
	}
	
	@Override
	public Size getTamano() {
		return this.bebida.getTamano();
	}
	
	public Bebida getBebida() {
		return this.bebida;
	}
	
	// Setter methods
	public boolean setBebida(Bebida bebida) {
		this.bebida = bebida;
		return true;
	}
	
	// Auxiliary methods
	@Override
	public String toString() {
		String cantidad = "";
		switch (this.getCantidad()) {
			case 1:
				cantidad = "simple";
				break;
			case 2:
				cantidad = "doble";
				break;
			case 3:
				cantidad = "triple";
				break;
			default:
				cantidad = "x" + this.getCantidad();
		}
		DecimalFormat df = new DecimalFormat("#.00");
		return this.getDescripcion() +
			   " " + cantidad + 
			   " de tamaño " + this.getTamano() +
			   " y coste de " + df.format(this.getCoste()) + " euros.";
	}
	
	@Override
	public boolean equals(Object ingrediente) {
		if (this == ingrediente) return true;
		if (ingrediente == null) return false;
		if (getClass() != ingrediente.getClass()) return false;
		IngredienteDecorator otroIngrediente = (IngredienteDecorator) ingrediente;
		
		return super.equals(otroIngrediente) &&
			   this.getBebida().equals(otroIngrediente.getBebida());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bebida, super.hashCode());
	}
}
