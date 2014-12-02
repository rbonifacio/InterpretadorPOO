package br.unb.cic.poolanguage;

import java.util.List;

/**
 * Representa uma declaracao de funcao 
 * em uma linguagem funcional. Toda declaracao 
 * de funcao tem um nome, uma lista com os argumentos 
 * formais e um corpo de funcao, que eh uma expressao. 
 * 
 * @author rbonifacio
 */
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
