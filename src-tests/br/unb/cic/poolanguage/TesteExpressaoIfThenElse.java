package br.unb.cic.poolanguage;

import junit.framework.TestCase;

public class TesteExpressaoIfThenElse extends TestCase {

	public void testExpressaoThen() {
		Expressao condicao = new ValorBooleano(true);
		Expressao then     = new ValorInteiro(5);
		Expressao else1    = new ValorInteiro(10);
		Expressao ite      = new IfThenElse(condicao, then, else1);
		
		ValorInteiro resultado    = ((ValorInteiro)ite.avaliar());
		assertEquals(new Integer(5), resultado.getValor());
	}
	
	public void testExpressaoElse() {
		Expressao condicao = new ValorBooleano(false);
		Expressao then     = new ValorInteiro(5);
		Expressao else1    = new ValorInteiro(10);
		Expressao ite      = new IfThenElse(condicao, then, else1);
		
		ValorInteiro resultado    = ((ValorInteiro)ite.avaliar());
		assertEquals(new Integer(10), resultado.getValor());
	}
}
