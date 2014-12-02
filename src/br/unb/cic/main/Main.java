package br.unb.cic.main;

import br.unb.cic.poolanguage.Expressao;
import br.unb.cic.poolanguage.IfThenElse;
import br.unb.cic.poolanguage.ValorBooleano;
import br.unb.cic.poolanguage.ValorInteiro;
import br.unb.cic.poolanguage.visitors.Metrics;
import br.unb.cic.poolanguage.visitors.PrettyPrinter;
import br.unb.cic.poolanguage.visitors.Visitor;

public class Main {

	public static void main(String[] args) {
		Expressao exp = new IfThenElse(new ValorBooleano(true), new ValorInteiro(5), new ValorInteiro(10));
		
		Visitor pp = new PrettyPrinter();
		Metrics metrics = new Metrics();
		
		exp.aceitar(pp);
		exp.aceitar(metrics);
		
		System.out.println("Nos visitados: " + metrics.getNosVisitados());
	}

}
