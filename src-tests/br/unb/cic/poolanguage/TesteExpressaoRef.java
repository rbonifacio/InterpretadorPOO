package br.unb.cic.poolanguage;

import junit.framework.TestCase;

public class TesteExpressaoRef extends TestCase {
	
	public void setUp() {
		AmbienteAvaliacao.instance().reinicializar();
	}
	
	public void testExpressaoRef() {
		AmbienteAvaliacao.instance().empilha();
		AmbienteAvaliacao.instance().defineVariavel("x", new ValorInteiro(5));
		
		ExpRef ref = new ExpRef("x");
	
		assertTrue(ref.verificarTipo());
		assertEquals(Tipo.Inteiro, ref.tipo());
	
		Valor v = ref.avaliar();
		
		//chegando aqui, eh seguro fazer o cast para 
		//ValorInteiro.
		ValorInteiro vi = (ValorInteiro)v.avaliar();
		assertEquals(new Integer(5), vi.getValor());
	}
	
	public void testExpressaoRefInexistente() {
		ExpRef ref = new ExpRef("x");
		
		assertFalse(ref.verificarTipo());
		assertEquals(Tipo.Inconsistente, ref.tipo());
		
		try {
			ref.avaliar();
			fail("esperando uma excecao, pois a referencia nao foi declarada");
		}
		catch(RuntimeException e) {
			//esperamos uma excecao, uma vez que o 
			//tipo eh inconsistente.
			assertTrue(true);
		}
	}
}
