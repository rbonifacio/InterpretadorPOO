package br.unb.cic.poolanguage.visitors;

import br.unb.cic.poolanguage.AplicacaoFuncao;
import br.unb.cic.poolanguage.ExpRef;
import br.unb.cic.poolanguage.Expressao;
import br.unb.cic.poolanguage.ExpressaoSoma;
import br.unb.cic.poolanguage.IfThenElse;
import br.unb.cic.poolanguage.ValorBooleano;
import br.unb.cic.poolanguage.ValorInteiro;

public class PrettyPrinter extends VisitorAdapter {

	private int indentacao = 0;
	
	public void incrementa() {
		indentacao++;
	}
	
	public void decrementa() {
		indentacao--;
	}
	
	@Override
	public void visitar(ValorBooleano v) {
		if(v.getValor()) {
			imprimeString("Verdadeiro");
		}
		else {
			imprimeString("Falso");
		}
	}

	@Override
	public void visitar(ValorInteiro v) {
		imprimeString(v.getValor().toString());
	}

	@Override
	public void visitar(ExpressaoSoma soma) {
		imprimeString("("); 
		soma.getLhs().aceitar(this);
		imprimeString(" + ");
		soma.getRhs().aceitar(this);
		imprimeString(")");
	}

	@Override
	public void visitar(IfThenElse ite) {
		imprimeString("if(");
		
		ite.getCondicao().aceitar(this);
		imprimeString(")");
		incrementa();
		quebraLinha();
		imprimeString("then {");
		incrementa();
		quebraLinha();
		ite.getClausulaThen().aceitar(this);
		decrementa();
		quebraLinha();
		imprimeString("}");
		imprimeString("else{");
		incrementa();
		quebraLinha();
		ite.getClausulaElse().aceitar(this);
		decrementa();
		quebraLinha();
		imprimeString("}");
		decrementa();
		quebraLinha();}
	
	public void imprimeString(String str) {
		for(int i = 0; i < indentacao; i++) {
			System.out.print(" ");
		}
		System.out.print(str);
	}
	
	public void quebraLinha() {
		System.out.println("");
	}

	@Override
	public void visitar(ExpRef ref) {
		System.out.println(ref.getNome());
	}

	@Override
	public void visitar(AplicacaoFuncao app) {
		System.out.print(app.getNome());
		for(Expressao e: app.getArgumentos()) {
			e.aceitar(this);
		}
	}
}
