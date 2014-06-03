package br.unb.cic.poolanguage;

public interface Expressao {
	public Valor avaliar();
	public Tipo tipo();
	public boolean  verificarTipo();
}
