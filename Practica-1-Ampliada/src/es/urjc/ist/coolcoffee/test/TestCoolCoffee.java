package es.urjc.ist.coolcoffee.test;

// import java.text.DecimalFormat;
import es.urjc.ist.coolcoffee.*;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;

public class TestCoolCoffee {

	public static void main(String[] args) {
		
		TiendaCoolCoffeeNYC tiendaNYC = new TiendaCoolCoffeeNYC();
		TiendaCoolCoffeeRome tiendaROM = new TiendaCoolCoffeeRome();
		
		System.out.println("-----PEDIDOS DE CAFE NYC-----");
		tiendaNYC.pedirBebida("DecafCrema");
		tiendaNYC.pedirBebida("Vienna");
		tiendaNYC.pedirBebida("CoolBlendVintage");
		tiendaNYC.pedirBebida("Vienna");
		tiendaNYC.pedirBebida("DecafCrema");
		System.out.println("-----PEDIDOS DE CAFE ROM-----");
		tiendaROM.pedirBebida("Ristretto");
		tiendaROM.pedirBebida("Machiatto");
		tiendaROM.pedirBebida("Garibaldi");
		tiendaROM.pedirBebida("Ristretto");
		tiendaROM.pedirBebida("Rigoletto");
		tiendaROM.pedirBebida("Machiatto");

		System.out.println("\n----- COMPROBACION DE LISTA: TIENDA NYC-----");
		System.out.println(tiendaNYC.toString());
		System.out.println("----- COMPROBACION DE LISTA: TIENDA ROM-----");
		System.out.println(tiendaROM.toString());

		ArrayList<Bebida> bebidaList1 = new ArrayList<Bebida>();
		bebidaList1.add(tiendaNYC.crearBebida("DecafCrema"));
		bebidaList1.add(tiendaNYC.crearBebida("Vienna"));
		bebidaList1.add(tiendaNYC.crearBebida("CoolBlendVintage"));
		bebidaList1.add(tiendaNYC.crearBebida("DecafCrema"));
		
		Pedido pedido1 = new Pedido(bebidaList1, "Javier");
		System.out.println(pedido1);
		
		Path filepath = Paths.get("/tmp/listabebida");
		try {
			if (Files.exists(filepath)) {
				Files.delete(filepath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Files.createFile(filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LocalDateTime actualtime = LocalDateTime.now();
		DateTimeFormatter dttime = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
		
		try {
			Files.write(filepath, ("[" + actualtime.format(dttime) + "]\n").getBytes("UTF-8"), StandardOpenOption.APPEND);
			Files.write(filepath, ("-----Tienda NYC-----\n").getBytes("UTF-8"), StandardOpenOption.APPEND);
			Files.write(filepath, tiendaNYC.listToString(), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			Files.write(filepath, ("-----Tienda ROM-----\n").getBytes("UTF-8"), StandardOpenOption.APPEND);
			Files.write(filepath, tiendaROM.listToString(), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
