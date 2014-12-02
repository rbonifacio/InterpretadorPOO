package br.unb.cic.poolanguage;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TesteAplicacaoFuncao extends TestCase {

	public void setUp() {
		/* 
		 * antes da chamada de cada metodo, inicializa as 
		 * declaracoes de funcoes. para os testes, apenas 
		 * a declaracao da seguinte funcao eh implementada:
		 *  inc :: Int -> Int
		 *  inc x = x + 1
		 *  
		 *  ou, em uma linguagem imperativa int inc(int x) { return x + 1; }
		 *  
		 * essa declaracao instancia uma funcao de nome "inc", com um 
		 * argumento "x" de tipo Inteiro e um corpo como uma Expressao 
		 * do tipo Soma, cujo primeiro componente eh uma referencia a "x" e 
		 * o segundo eh o valor inteiro.
		 */
		String nome = "inc";
		
		List<ArgumentoFormal> argumentos = new ArrayList<ArgumentoFormal>();
		argumentos.add(new ArgumentoFormal("x", Tipo.Inteiro));
		
		Expressao corpo = new ExpressaoSoma(new ExpRef("x"), new ValorInteiro(1));
		DeclaracaoFuncao dec = new DeclaracaoFuncao(nome, argumentos, corpo);
		
		//essa declaracao eh disponibilizadao no interpretador.
		Interpretador.instance().addDeclaracao(dec);
	}
	
	public void testFuncaoInc() {
		List<Expressao> argumentos = new ArrayList<Expressao>();
		
		argumentos.add(new ValorInteiro(5));
		AplicacaoFuncao app = new AplicacaoFuncao("inc", argumentos);
		
		assertTrue(app.verificarTipo());
		assertEquals(Tipo.Inteiro, app.tipo());
		
		ValorInteiro valor = (ValorInteiro)app.avaliar();
		
		assertEquals(new Integer(6), valor.getValor());
	}
	public void testFuncaoNaoDeclarada() {
		//a inicializacao de listas em Java eh "old fashioned"
		//aqui eh possivel sentir muita falta de Python ou 
		//Haskell (claro).
		
		List<Expressao> argumentos = new ArrayList<Expressao>();
		
		argumentos.add(new ValorInteiro(5));
		argumentos.add(new ExpressaoSoma(new ValorInteiro(5), new ValorInteiro(3)));
		
		//essa aplicacao de funcao seria algo equivalente a:
		// f 5 (5 + 3)
		//mas note que a funcao "f" nao foi declarada.
		AplicacaoFuncao app = new AplicacaoFuncao("f", argumentos);
		
		assertFalse(app.verificarTipo());
		assertEquals(Tipo.Inconsistente, app.tipo());
	}
	
}
