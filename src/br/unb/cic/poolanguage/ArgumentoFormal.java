package br.unb.cic.poolanguage;

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
