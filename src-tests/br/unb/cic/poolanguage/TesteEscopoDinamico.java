package br.unb.cic.poolanguage;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TesteEscopoDinamico extends TestCase {

private DeclaracaoFuncao f1;
	
	@Override
	public void setUp() {
		f1 = criaF2();
	
		Interpretador.instance().addDeclaracao(f1);
	}
	
	@Override
	public void tearDown() {
		Interpretador.instance().reinicializa();
	}
	
	/*
	 * A funcao f1 eh definida como 
	 * 
	 *  f1 y  = x + y
	 */
	private DeclaracaoFuncao criaF2() {
		String nome = "f1";
		
		List<ArgumentoFormal> argumentosFormais = new ArrayList<ArgumentoFormal>();
		argumentosFormais.add(new ArgumentoFormal("y", Tipo.Inteiro));
		
		Expressao corpo = new ExpressaoSoma(new ExpRef("x"), new ExpRef("y"));
		
		return new DeclaracaoFuncao(nome, argumentosFormais, corpo);
	}
	
	public void testEscopoDinamico() {
		//em Haskell, teriamos algo como
		//let x = 10 in f2 x
		//
		//Isso levaria a um erro de tipos, uma vez que o 
		//escopo eh estatico e o a definicao f y = x + y 
		//tem um "x" <i>not bound</i>. 
		//
		
		String nome = "x";
		Expressao expNomeada = new ValorInteiro(10);
		
		List<Expressao> argumentos = new ArrayList<Expressao>();
		argumentos.add(new ExpRef(nome));
		
		Expressao corpo = new AplicacaoFuncao("f1", argumentos);
		
		ExpressaoLet let = new ExpressaoLet(nome, expNomeada, corpo);
		
		//essa expressao eh bem tipada, e tem um tipo Inteiro
		assertFalse(let.verificarTipo());
		assertEquals(Tipo.Inconsistente, let.tipo());
		
		ValorInteiro resultado = (ValorInteiro)let.avaliar();
		assertEquals(new Integer(20), resultado.getValor());
	}
	
	public void testEscopoAninhado() {
		//em Haskell, teriamos algo como
		//let x = 10 in (let x = 5 in x + 5) + x
		//o resultado da avaliacao dessa expressao 
		//deve levar a um valor 20
		
		String nome = "x";
		
		Expressao corpoInterno = new ExpressaoSoma(new ExpRef(nome), new ValorInteiro(5)); 
		ExpressaoLet letInterno = new ExpressaoLet(nome, new ValorInteiro(5), corpoInterno);
		
		
		Expressao corpoExterno = new ExpressaoSoma(letInterno, new ExpRef(nome));
		ExpressaoLet letExterno = new ExpressaoLet(nome, new ValorInteiro(10), corpoExterno);
		
		assertTrue(letExterno.verificarTipo());
		assertEquals(Tipo.Inteiro, letExterno.tipo());
		
		//o resultado da avaliacao deve ser 20
		ValorInteiro resultado = (ValorInteiro)letExterno.avaliar();
		assertEquals(new Integer(20), resultado.getValor());
	}
}
