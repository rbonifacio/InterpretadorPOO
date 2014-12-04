package br.unb.cic.poolanguage.visitors;

import br.unb.cic.poolanguage.AplicacaoFuncao;
import br.unb.cic.poolanguage.ExpRef;
import br.unb.cic.poolanguage.Expressao;
import br.unb.cic.poolanguage.ExpressaoSoma;
import br.unb.cic.poolanguage.IfThenElse;
import br.unb.cic.poolanguage.ValorBooleano;
import br.unb.cic.poolanguage.ValorInteiro;

public class Metrics extends VisitorAdapter {

	private int nosVisitados;
	
	public Metrics() {
		nosVisitados = 0;
	}
	
	@Override
	public void visitar(ValorBooleano v) {
		nosVisitados++;
	}

	@Override
	public void visitar(ValorInteiro v) {
		nosVisitados++;
	}

	@Override
	public void visitar(ExpressaoSoma soma) {
		nosVisitados++;
		soma.getLhs().aceitar(this);
		soma.getRhs().aceitar(this);
	}

	@Override
	public void visitar(IfThenElse ite) {
		nosVisitados++;
		ite.getCondicao().aceitar(this);
		ite.getClausulaThen().aceitar(this);
		ite.getClausulaElse().aceitar(this);
	}
	
	public int getNosVisitados() {
		return nosVisitados;
	}

	@Override
	public void visitar(ExpRef ref) {
		nosVisitados++;
	}

	@Override
	public void visitar(AplicacaoFuncao app) {
		nosVisitados++;
		for(Expressao exp : app.getArgumentos()) {
			exp.aceitar(this);
		}
	}	
}
