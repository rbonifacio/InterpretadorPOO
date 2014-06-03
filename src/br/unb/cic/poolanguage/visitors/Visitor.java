package br.unb.cic.poolanguage.visitors;

import br.unb.cic.poolanguage.ExpressaoSoma;
import br.unb.cic.poolanguage.IfThenElse;
import br.unb.cic.poolanguage.ValorBooleano;
import br.unb.cic.poolanguage.ValorInteiro;

public interface Visitor {
	public abstract void visitar(ValorBooleano v);
	public abstract void visitar(ValorInteiro v);
	public abstract void visitar(ExpressaoSoma soma);
	public abstract void visitar(IfThenElse ite);
	
}
