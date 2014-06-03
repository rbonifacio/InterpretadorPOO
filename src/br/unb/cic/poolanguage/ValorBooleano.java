package br.unb.cic.poolanguage;

import br.unb.cic.poolanguage.visitors.Visitor;

public class ValorBooleano extends ValorParametrizado<Boolean>{

	public ValorBooleano(Boolean valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.Booleano;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
