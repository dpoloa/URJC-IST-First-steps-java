package es.urjc.ist.coolcoffee;

public class TiendaCoolCoffeeNYC extends TiendaCoolCoffee{
	
	// Methods
	public Bebida crearBebida (String etiqueta) {
		Bebida bebida = null;
		
		if (etiqueta.equals("DecafCrema")) {
			bebida = new Descafeinado();
			bebida.setTamano(Size.L);
			bebida = new Crema(bebida);
		} else if (etiqueta.equals("CoolBlendVintage")) {
			bebida = new CoolBlend();
			bebida.setTamano(Size.L);
			bebida = new Leche(bebida);
		} else if (etiqueta.equals("Vienna")) {
			bebida = new Expresso();
			bebida.setTamano(Size.L);
			bebida = new Chocolate(new Chocolate(bebida));
		} 
		
		return bebida;
	}
}
