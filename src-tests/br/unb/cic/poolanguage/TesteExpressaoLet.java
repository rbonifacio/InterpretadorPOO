package br.unb.cic.poolanguage;

import junit.framework.TestCase;

public class TesteExpressaoLet extends TestCase {
	public void testErro() {
		//em Haskell, uma expressao como 
		//let x = 10 in y daria um erro de tipos, 
		//uma vez que y nao foi declarada.
		String nome = "x";
		Expressao expNomeada = new ValorInteiro(5);
		Expressao corpo = new ExpRef("y");
		
		ExpressaoLet let = new ExpressaoLet(nome, expNomeada, corpo);
		
		assertFalse(let.verificarTipo());
		assertEquals(Tipo.Inconsistente, let.tipo());
		
		try {
			Valor valor = let.avaliar();
			System.out.println(valor);
		}
		catch(RuntimeException e) { //esperamos que uma tentativa de avaliacao lance excecao
			assertTrue(true);
		}
	}
	
	public void testExpressao() {
		//em Haskell, teriamos algo como
		//let x = 10 in x + 5
		//o resultado da avaliacao dessa expressao 
		//deve levar a um valor 15.
		String nome = "x";
		Expressao expNomeada = new ValorInteiro(10);
		Expressao corpo = new ExpressaoSoma(new ExpRef(nome), new ValorInteiro(5));
		
		ExpressaoLet let = new ExpressaoLet(nome, expNomeada, corpo);
		
		//essa expressao eh bem tipada, e tem um tipo Inteiro
		assertTrue(let.verificarTipo());
		assertEquals(Tipo.Inteiro, let.tipo());
		
		//o resultado da avaliacao deve ser 15
		ValorInteiro resultado = (ValorInteiro)let.avaliar();
		assertEquals(new Integer(15), resultado.getValor());
	}
	
	public void testExpressoesAninhadas() {
		//em Haskell, teriamos algo como
		//let x = 10 in let y = 5 in x + y
		//o resultado da avaliacao dessa expressao 
		//deve levar a um valor 15.
		
		String nomeInterno = "y";
		String nomeExterno = "x";
		Expressao expressaoNomeadaInterna = new ValorInteiro(5); 
		Expressao expressaoNomeadaExterna = new ValorInteiro(10);
		Expressao corpoInterno = new ExpressaoSoma(new ExpRef(nomeExterno), new ExpRef(nomeInterno));
		Expressao corpoExterno = new ExpressaoLet(nomeInterno, expressaoNomeadaInterna, corpoInterno);
		
		ExpressaoLet let = new ExpressaoLet(nomeExterno, expressaoNomeadaExterna, corpoExterno);
		
		assertTrue(let.verificarTipo());
		assertEquals(Tipo.Inteiro, let.tipo());
		
		//o resultado da avaliacao deve ser 15
		ValorInteiro resultado = (ValorInteiro)let.avaliar();
		assertEquals(new Integer(15), resultado.getValor());
	}
	
	
}
