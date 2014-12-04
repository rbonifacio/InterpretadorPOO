package br.unb.cic.poolanguage;

import br.unb.cic.poolanguage.visitors.Visitor;

public class ExpressaoNot implements Expressao {

	private Expressao exp;
	
	public ExpressaoNot(Expressao exp) {
		this.exp = exp;
	}
	
	@Override
	public Valor avaliar() {
		if(verificarTipo()) {
			ValorBooleano valor = (ValorBooleano)exp.avaliar();
			return new ValorBooleano(!valor.getValor());
		}
		throw new RuntimeException("erro de tipos");
	}

	@Override
	public Tipo tipo() {
		if(verificarTipo()) {
			return Tipo.Booleano;
		}
		return Tipo.Inconsistente;
	}

	@Override
	public boolean verificarTipo() {
		return exp.avaliar().tipo().equals(Tipo.Booleano);
	}

	@Override
	public void aceitar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
