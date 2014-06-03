package br.unb.cic.poolanguage;

import br.unb.cic.poolanguage.visitors.Visitor;

public class ValorInteiro extends ValorParametrizado<Integer>{

	public ValorInteiro(Integer valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.Inteiro;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);	
	}
}
