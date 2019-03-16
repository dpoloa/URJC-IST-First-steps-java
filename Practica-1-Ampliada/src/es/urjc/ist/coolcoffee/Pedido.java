package es.urjc.ist.coolcoffee;

import java.util.List;
import java.util.Objects;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
	
	// Attributes
	private List<Bebida> bebidaList;
	private double costeTotal;
	private String cliente;
	private LocalDateTime tiempo;
	
	// Constructor
	public Pedido (List<Bebida> bebidaList, String cliente) {
		this.setBebidaList(bebidaList);
		this.setCosteTotal();
		this.setCliente(cliente);
		this.setTiempo();
	}

	// Getter methods
	public List<Bebida> getBebidaList() {
		return bebidaList;
	}
	
	public double getCosteTotal() {
		return costeTotal;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public LocalDateTime getTiempo() {
		return tiempo;
	}

	// Setter methods
	public boolean setBebidaList(List<Bebida> bebidaList) {
		this.bebidaList = bebidaList;
		return true;
	}

	public boolean setCosteTotal() {
		double costeTotal = 0.0;
		for (Bebida bebida: this.getBebidaList()) {
			costeTotal = costeTotal + bebida.getCoste();
		}
		this.costeTotal = costeTotal;
		return true;
	}

	public boolean setCliente(String cliente) {
		this.cliente = cliente;
		return true;
	}

	public boolean setTiempo() {
		this.tiempo = LocalDateTime.now();
		return true;
	}
	
	// Auxiliary methods
	@Override
	public String toString() {
		String listaBebida = "";
		DecimalFormat df = new DecimalFormat("#.00");
		DateTimeFormatter dttime = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
		
		for (Bebida bebida: this.getBebidaList()) {
			listaBebida = listaBebida + bebida.toString() + "\n";
		}
		
		return "Fecha de pedido: " + this.getTiempo().format(dttime) +
			   "\nCliente: " + this.getCliente() + 
			   "\n\n-----Lista de bebidas-----\n" + listaBebida + 
			   "\nCoste total: " + df.format(getCosteTotal()) + " euros.";
	}
	
	@Override
	public boolean equals(Object pedido) {
		if (this == pedido) return true;
		if (pedido == null) return false;
		if (getClass() != pedido.getClass()) return false;
		Pedido otroPedido = (Pedido) pedido;
		
		return this.getBebidaList().equals(otroPedido.getBebidaList()) &&
			   Double.compare(this.getCosteTotal(), otroPedido.getCosteTotal()) == 0 &&
			   Objects.equals(this.getCliente(), otroPedido.getCliente()) &&
			   Objects.equals(this.getTiempo(), otroPedido.getTiempo());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bebidaList, costeTotal, cliente, tiempo);
	}
}
