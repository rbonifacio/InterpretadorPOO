package br.unb.cic.poolanguage.visitors;

import br.unb.cic.poolanguage.ExpressaoSoma;
import br.unb.cic.poolanguage.IfThenElse;
import br.unb.cic.poolanguage.ValorBooleano;
import br.unb.cic.poolanguage.ValorInteiro;

public class PrettyPrinter extends Visitor {

	@Override
	public void visitar(ValorBooleano v) {
		if(v.getValor()) {
			System.out.println("Verdadeiro");
		}
		else {
			System.out.println("Falso");
		}
	}

	@Override
	public void visitar(ValorInteiro v) {
		System.out.println(v.getValor());
	}

	@Override
	public void visitar(ExpressaoSoma soma) {
		System.out.print("("); 
		this.visitar(soma.getLhs());
		System.out.println(" + ");
		this.visitar(soma.getRhs());
		System.out.println(")");
	}

	@Override
	public void visitar(IfThenElse ite) {
		System.out.println("if(");
		visitar(ite.getCondicao());
		System.out.println(")");
		System.out.println("then {");
		visitar(ite.getClausulaThen());
		System.out.println("}");
		System.out.println("else{");
		visitar(ite.getClausulaElse());
		System.out.println("}");
	}

}
