package br.unb.cic.poolanguage;

public class ExpressaoSoma extends ExpressaoBinaria {

	public ExpressaoSoma(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}

	

	public Tipo tipo() {
		if(verificarTipo()) {
			return Tipo.Inteiro;
		}
		return Tipo.Inconsistente;
	}
	
	public boolean verificarTipo() {
		Valor valorLHS = lhs.avaliar();
		Valor valorRHS = rhs.avaliar();
		
		return (valorLHS instanceof ValorInteiro) && (valorRHS instanceof ValorInteiro);
	}
	
	public Valor avaliar() {
		if(verificarTipo()) {
			ValorInteiro valor1 = (ValorInteiro) lhs.avaliar();
			ValorInteiro valor2 = (ValorInteiro) rhs.avaliar();
			
			return new ValorInteiro(valor1.getValor() + valor2.getValor());
		}
		//TODO: implementar uma checagem de tipos adequada
		throw new RuntimeException("Erro de tipos!!!!");
	}
}
