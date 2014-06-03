package br.unb.cic.poolanguage;

import junit.framework.TestCase;

public class TesteExpreesaoSoma extends TestCase {

	public void testSomaSimples() {
		Expressao valor5  = new ValorInteiro(5);
		Expressao valor10 = new ValorInteiro(10);
		
		Expressao soma = new ExpressaoSoma(valor5, valor10);
		
		ValorInteiro res = (ValorInteiro)soma.avaliar();
		assertEquals(new Integer(15), res.getValor());
	}
	
	public void testSomaComplexa() {
		Expressao valor5  = new ValorInteiro(5);
		Expressao valor10 = new ValorInteiro(10);
		
		Expressao soma1 = new ExpressaoSoma(valor5, valor10);
		Expressao soma2 = new ExpressaoSoma(soma1, soma1);
		
		ValorInteiro res = (ValorInteiro)soma2.avaliar();
		assertEquals(new Integer(30), res.getValor());
	}
	
	public void testSomaInvalida() {
		Expressao valor5  = new ValorInteiro(5);
		Expressao valorTrue = new ValorBooleano(true);
		
		try {
			Expressao soma1 = new ExpressaoSoma(valor5, valorTrue);
			soma1.avaliar();
			fail();
		}catch(RuntimeException e) {
			assertTrue(true);
		}
	}
}
