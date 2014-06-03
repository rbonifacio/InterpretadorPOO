package br.unb.cic.poolanguage;

public abstract class ExpressaoBinaria implements Expressao {

	protected Expressao lhs;
	protected Expressao rhs; 
	
	public ExpressaoBinaria(Expressao lhs, Expressao rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expressao getLhs() {
		return lhs;
	}

	public Expressao getRhs() {
		return rhs;
	}
	
	
}
