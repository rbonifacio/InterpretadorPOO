package br.unb.cic.main;

import br.unb.cic.poolanguage.Expressao;
import br.unb.cic.poolanguage.IfThenElse;
import br.unb.cic.poolanguage.ValorBooleano;
import br.unb.cic.poolanguage.ValorInteiro;
import br.unb.cic.poolanguage.visitors.PrettyPrinter;

public class Main {

	public static void main(String[] args) {
		Expressao exp = new IfThenElse(new ValorBooleano(true), new ValorInteiro(5), new ValorInteiro(10));
		
		PrettyPrinter pp = new PrettyPrinter();
		
		exp.aceitar(pp);
	}

}
