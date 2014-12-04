package br.unb.cic.poolanguage.visitors;

import br.unb.cic.poolanguage.AplicacaoFuncao;
import br.unb.cic.poolanguage.ExpRef;
import br.unb.cic.poolanguage.ExpressaoAnd;
import br.unb.cic.poolanguage.ExpressaoLet;
import br.unb.cic.poolanguage.ExpressaoOr;
import br.unb.cic.poolanguage.ExpressaoSoma;
import br.unb.cic.poolanguage.IfThenElse;
import br.unb.cic.poolanguage.ValorBooleano;
import br.unb.cic.poolanguage.ValorInteiro;

/**
 * Um adaptador que simplifica a interface 
 * do visitor. Os demais visitors devem herdar 
 * desse adaptador e implementar apenas os 
 * metodos do visitor que possuem interesse.
 * @author rbonifacio
 *
 */
public class VisitorAdapter implements Visitor {

	@Override
	public void visitar(ValorBooleano v) { }

	@Override
	public void visitar(ValorInteiro v) { }

	@Override
	public void visitar(ExpressaoSoma soma) { }

	@Override
	public void visitar(IfThenElse ite) { }

	@Override
	public void visitar(ExpRef ref) { }

	@Override
	public void visitar(AplicacaoFuncao app) {	}

	@Override
	public void visitar(ExpressaoLet expressaoLet) { }

	@Override
	public void visitar(ExpressaoOr expressaoOr) { }

	@Override
	public void visitar(ExpressaoAnd expressaoAnd) {	}

}
