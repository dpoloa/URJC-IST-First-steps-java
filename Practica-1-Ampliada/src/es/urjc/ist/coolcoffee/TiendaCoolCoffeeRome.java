package es.urjc.ist.coolcoffee;

public class TiendaCoolCoffeeRome extends TiendaCoolCoffee{
	
	// Methods
	public Bebida crearBebida (String etiqueta) {
		Bebida bebida = null;
		
		if (etiqueta.equals("Ristretto")) {
			bebida = new Expresso(2);
			bebida.setTamano(Size.S);
		} else if (etiqueta.equals("Machiatto")) {
			bebida = new CoolBlend();
			bebida.setTamano(Size.M);
			bebida = new Leche(bebida);
		} else if (etiqueta.equals("Rigoletto")) {
			bebida = new Descafeinado();
			bebida.setTamano(Size.M);
			bebida = new Crema(new Leche(bebida));
		} else if (etiqueta.equals("Garibaldi")) {
			bebida = new CoolBlend();
			bebida.setTamano(Size.M);
			bebida = new Chocolate(new Chocolate(bebida));
		} 
		
		return bebida;
	}
}
