package br.unb.cic.poolanguage;

import br.unb.cic.poolanguage.visitors.Visitor;

public class ExpressaoOr extends ExpressaoBinaria {

	public ExpressaoOr(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}

	@Override
	public Valor avaliar() {
		if(verificarTipo()) {
			ValorBooleano v1 = (ValorBooleano)lhs.avaliar();
			ValorBooleano v2 = (ValorBooleano)lhs.avaliar();
		
			return new ValorBooleano(v1.getValor() || v2.getValor());
		}
		else {
			throw new RuntimeException("erro de tipos");
		}
	}

	@Override
	public Tipo tipo() {
		return verificarTipo() ? Tipo.Booleano : Tipo.Inconsistente;
	}

	@Override
	public boolean verificarTipo() {
		Valor v1 = lhs.avaliar();
		Valor v2 = lhs.avaliar();
		return (v1.tipo() == Tipo.Booleano) && (v2.tipo() == Tipo.Booleano);
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
