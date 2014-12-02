package br.unb.cic.poolanguage;

import java.util.List;

public class DeclaracaoFuncao {

	private String nome; 
	private List<ArgumentoFormal> argumentos;
	private Expressao corpoFuncao;
	
	public DeclaracaoFuncao(String nome, List<ArgumentoFormal> argumentos, Expressao corpo) {
		this.nome = nome;
		this.argumentos = argumentos;
		this.corpoFuncao = corpo;
	}
	public String getNome() {
		return nome;
	}
	
	public List<ArgumentoFormal> getArgumentos() {
		return argumentos;
	}
	
	public Expressao getCorpoFuncao() {
		return corpoFuncao;
	}
}
