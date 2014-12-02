package br.unb.cic.poolanguage;

/**
 * Representa um argumento formal, usado na 
 * declaracao de funcoes. Todo argumento 
 * envolve um nome e um tipo. Nossa linguagem 
 * eh muito disciplinada em relacao a tipos. 
 * 
 * @author rbonifacio
 */
public class ArgumentoFormal {
	private String nome;
	private Tipo tipo;
	
	public ArgumentoFormal(String nome, Tipo tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public Tipo getTipo() {
		return tipo;
	}
}
