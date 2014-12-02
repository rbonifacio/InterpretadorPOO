package br.unb.cic.poolanguage;

import java.util.HashMap;

public class Interpretador {

	private static Interpretador instance; 
	
	private Interpretador() {
		declaracoes = new HashMap<String, DeclaracaoFuncao>();
	}
	
	public static Interpretador instance() {
		if(instance == null) {
			instance = new Interpretador();
		}
		return instance; 
	}
	
	private HashMap<String, DeclaracaoFuncao> declaracoes;
	
	public Valor avaliar(Expressao exp) {
		return exp.avaliar();
	}
	
	public void addDeclaracao(DeclaracaoFuncao funcao) {
		declaracoes.put(funcao.getNome(), funcao);
	}
	
	public DeclaracaoFuncao obtemDeclaracaoFuncao(String nome) {
		return declaracoes.get(nome);
	}
}
