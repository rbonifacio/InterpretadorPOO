package br.unb.cic.poolanguage;

public class IfThenElse implements Expressao {

	private Expressao condicao;
	private Expressao clausulaThen;
	private Expressao clausulaElse; 
	
	
	public IfThenElse(Expressao condicao, Expressao clausulaThen, Expressao clausulaElse) {
		this.condicao = condicao;
		this.clausulaThen = clausulaThen;
		this.clausulaElse = clausulaElse;
	}


	@Override
	public Valor avaliar() {
		if(verificarTipo()) {
			ValorBooleano valorCondicaoBooleano = (ValorBooleano)condicao.avaliar();
			if(valorCondicaoBooleano.getValor()) {
				return clausulaThen.avaliar();
			}
			else {
				return clausulaElse.avaliar();
			}
		}
		else {
			throw new RuntimeException("Condicao precisa ser um valor booleano");
		}
	}


	@Override
	public Tipo tipo() {
		if(verificarTipo()) {
			return clausulaThen.tipo();
		}
		return Tipo.Inconsistente;
	}


	@Override
	public boolean verificarTipo() {
		return (condicao.tipo() == Tipo.Booleano) &&
					(clausulaThen.tipo() == clausulaElse.tipo());
	}


	public Expressao getCondicao() {
		return condicao;
	}


	public Expressao getClausulaThen() {
		return clausulaThen;
	}


	public Expressao getClausulaElse() {
		return clausulaElse;
	}
	
	

}
