package es.urjc.ist.coolcoffee;

import java.util.Objects;
import java.text.DecimalFormat;

public abstract class Bebida {
	
	// Attributes
	private String descripcion;
	private int cantidad;
	private double coste;
	private Size tamano;
	
	// Constructor is not needed

	// Getter methods
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}

	public double getCoste() {
		return this.coste * this.cantidad;
	}
	
	public Size getTamano() {
		return this.tamano;
	}
	

	// Setter methods
	public boolean setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return true;
	}
	
	public boolean setCoste(double coste) {
		this.coste = coste;
		return true;
	}
	
	public boolean setTamano(Size tamano) {
		if (tamano.isSizeAppropriate()) {
			this.tamano = tamano;
			return true;
		} else {
			System.out.print("Tamaño no válido para el café");
			return false;
		}
	}
	
	public boolean setCantidad(int cantidad) {
		if (cantidad <= 0) {
			System.out.println("Cantidad no válida. Introduzca otra cantidad");
			return false;
		} else {
			this.cantidad = cantidad;
			return true;
		}
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
	public boolean equals(Object bebida) {
		if (this == bebida) return true;
		if (bebida == null) return false;
		if (getClass() != bebida.getClass()) return false;
		Bebida otraBebida = (Bebida) bebida;

		return Objects.equals(this.getDescripcion(), otraBebida.getDescripcion()) &&
			   this.getCantidad() == otraBebida.getCantidad() &&
 			   Double.compare(this.getCoste(), otraBebida.getCoste()) == 0 &&
			   this.getTamano() == otraBebida.getTamano();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(descripcion,cantidad,coste,tamano);
	}
}
