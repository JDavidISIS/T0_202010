package test.data_structures;

import model.data_structures.ArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() {
		arreglo= new ArregloDinamico(TAMANO);
	}

	public void setUp2() {
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(""+i);
		}
	}

	@Test
	public void testArregloDinamico() {
		int i = 0;
		String elemento = "" + i;
		setUp1();
		setUp2();
		
		assertEquals(TAMANO, arreglo.darTamano());
		assertEquals(TAMANO*2, arreglo.darCapacidad());
		assertEquals(elemento, arreglo.darElemento(i));
		assertEquals(elemento, arreglo.buscar(elemento));
		assertEquals(0, arreglo.eliminar("" + i));
		
	}

	@Test
	public void testDarElemento() {
		setUp2();
		int i = 0;
		String elemento = "" + i;
		assertEquals(elemento, arreglo.darElemento(i));
		
	}

}
