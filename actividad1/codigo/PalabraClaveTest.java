package eda;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PalabraClaveTest {
	PalabraClave pc1;
	PalabraClave pc2;
	PalabraClave pc3;
	PalabraClave pc4;
	PalabraClave pc5;

	@Before
	public void setUp() throws Exception {
		pc1= new PalabraClave("Casa");
		pc2= new PalabraClave("Coche");
		pc3= new PalabraClave("Caja");
		pc4= new PalabraClave("Destruccion");
		pc5= new PalabraClave("ehu");
	}

	@After
	public void tearDown() throws Exception {
		pc1= null;
		pc2= null;
		pc3= null;
		pc4= null;
		pc5= null;
	}

	@Test
	public void testPalabraClave() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPalabra() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPaginasConPalabra() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirDatos() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPaginaLista() {
		pc1.addPaginaLista("Casa.com");
		pc1.imprimirDatos();
	}

	@Test
	public void testBorrarPaginaLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		assertTrue(pc1.equals("Casa"));
		System.out.println(pc1.equals("Casa"));
	}

}
