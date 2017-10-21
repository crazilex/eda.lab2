package Lab1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseDatosTest {
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		BaseDatos.getBaseDatos().reset();
	}

	/*@Test
	public void testImprimir() {
		BaseDatos.getBaseDatos().imprimir();
		BaseDatos.getBaseDatos().reset();
		BaseDatos.getBaseDatos().anadirPorLetra(pc2);
		BaseDatos.getBaseDatos().anadirPorLetra(pc1);
		BaseDatos.getBaseDatos().imprimir();
	}*/

	@Test
	public void testAñadirWeb() {
		for(int p = 0; p<100000; p++){
			BaseDatos.getBaseDatos().anadirPorLetra("Casa");
			BaseDatos.getBaseDatos().anadirPorLetra("Coche");
			BaseDatos.getBaseDatos().anadirPorLetra("Destruccion");
		}
		BaseDatos.getBaseDatos().anadirPorLetra("Destrussion");
		BaseDatos.getBaseDatos().anadirPorLetra("Kotxe");
		System.out.println("YA");
		for(int p = 0; p<3000000; p++){
			System.out.println(p);
			BaseDatos.getBaseDatos().añadirWeb("Destrussion.com");
		}
		BaseDatos.getBaseDatos().añadirWeb("Casa.com");
		BaseDatos.getBaseDatos().añadirWeb("nKotxe.com");
		System.out.println("YAAAA");
		System.out.println(BaseDatos.getBaseDatos().getPalabras().get("Kotxe"));
		BaseDatos.getBaseDatos().eliminarWeb("nKotxe.com");
		System.out.println(BaseDatos.getBaseDatos().getPalabras().get("Kotxe"));
	}
}
