package eda;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		Diccionario.getDiccionario().anadirPorLetra(pc2);
		Diccionario.getDiccionario().anadirPorLetra(pc1);
		Diccionario.getDiccionario().imprimir();
	}*/

	@Test
	public void testAñadirWeb() {
		for(int p = 0; p<100000; p++){
			Diccionario.getDiccionario().anadirPorLetra("Casa");
			Diccionario.getDiccionario().anadirPorLetra("Coche");
			Diccionario.getDiccionario().anadirPorLetra("Destruccion");
		}
		Diccionario.getDiccionario().anadirPorLetra("Destrussion");
		Diccionario.getDiccionario().anadirPorLetra("Kotxe");
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
	}
}
