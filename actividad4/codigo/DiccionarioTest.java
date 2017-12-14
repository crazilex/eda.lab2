package cuartaFase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiccionarioTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		Diccionario.getDiccionario().reset();
	}

	/*@Test
	public void testImprimir() {
		Diccionario.getDiccionario().imprimir();
		Diccionario.getDiccionario().reset();
		Diccionario.getDiccionario().anadirPalabra("Casa");
		Diccionario.getDiccionario().anadirPalabra("Coche");
		Diccionario.getDiccionario().imprimir();
		Diccionario.getDiccionario().añadirWeb("Casa.com");
		Diccionario.getDiccionario().añadirWeb("CasaCoche.com");
		Diccionario.getDiccionario().añadirWeb("Coche.com");
		Diccionario.getDiccionario().imprimir();
	}*/

	/*@Test
	public void testAñadirWeb() {
		for(int p = 0; p<100000; p++){
			Diccionario.getDiccionario().anadirPalabra("Casa");
			Diccionario.getDiccionario().anadirPalabra("Coche");
			Diccionario.getDiccionario().anadirPalabra("Destruccion");
		}
		Diccionario.getDiccionario().anadirPalabra("Destrussion");
		Diccionario.getDiccionario().anadirPalabra("Kotxe");
		System.out.println("YA");
		for(int p = 0; p<3000000; p++){
			System.out.println(p);
			Diccionario.getDiccionario().añadirWeb("Destrussion.com");
		}
		Diccionario.getDiccionario().añadirWeb("Casa.com");
		Diccionario.getDiccionario().añadirWeb("nKotxe.com");
		System.out.println("YAAAA");
		System.out.println(Diccionario.getDiccionario().getPalabras().get("Kotxe"));
		Diccionario.getDiccionario().eliminarWeb("nKotxe.com");
		System.out.println(Diccionario.getDiccionario().getPalabras().get("Kotxe"));
	}*/
	
	@Test
	public void testBuscar() {
		Diccionario.getDiccionario().anadirPalabra("Casa");
		for(int p = 0; p<100000; p++){
			Diccionario.getDiccionario().anadirPalabra("Coche");
			Diccionario.getDiccionario().anadirPalabra("Destruccion");
		}
		Diccionario.getDiccionario().añadirWeb("Casa1.com");
		Diccionario.getDiccionario().añadirWeb("Casa2.com");
		Diccionario.getDiccionario().añadirWeb("Casa3.com");
		Diccionario.getDiccionario().añadirWeb("Casa4.com");
		Diccionario.getDiccionario().añadirWeb("Coche1.com");
		Diccionario.getDiccionario().añadirWeb("Coche2.com");
		Diccionario.getDiccionario().añadirWeb("Coche3.com");
		Diccionario.getDiccionario().añadirWeb("Coche4.com");
		Diccionario.getDiccionario().añadirWeb("CocheCasa1.com");
		Diccionario.getDiccionario().añadirWeb("CocheCasa2.com");
		Diccionario.getDiccionario().añadirWeb("CocheCasa3.com");
		Diccionario.getDiccionario().añadirWeb("CocheCasa4.com");
		
		HashMap<String,Double> pageRank = new HashMap<String,Double>();
		pageRank.put("Casa1.com", 0.05);
		pageRank.put("Casa2.com", 0.55);
		pageRank.put("Casa3.com", 0.2);
		pageRank.put("Casa4.com", 0.2);
		pageRank.put("Coche1.com", 0.7);
		pageRank.put("Coche2.com", 0.55);
		pageRank.put("Coche3.com", 0.2);
		pageRank.put("Coche4.com", 0.5);
		pageRank.put("CocheCasa1.com", 0.005);
		pageRank.put("CocheCasa2.com", 0.15);
		pageRank.put("CocheCasa3.com", 1.2);
		pageRank.put("CocheCasa4.com", 0.005);
		
		ArrayList<String> l1 = Diccionario.getDiccionario().buscar("Casa", pageRank);
		System.out.println(l1);
		ArrayList<String> l2 = Diccionario.getDiccionario().buscarOpcional("Casa", "Coche", pageRank);
		System.out.println(l2);
		
	}
}
