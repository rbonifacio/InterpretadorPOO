package br.unb.cic.poolanguage;

import br.unb.cic.poolanguage.visitors.Visitor;

public interface Expressao {
	public Valor avaliar();
	public Tipo tipo();
	public boolean  verificarTipo();
	public void aceitar(Visitor v);
}
