package br.unb.cic.poolanguage;

public class ExpressaoSoma extends ExpressaoBinaria {

	public ExpressaoSoma(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}

	@Override
	public Valor avaliar() {
		Valor v1 = lhs.avaliar();
		Valor v2 = rhs.avaliar();
		
		if(v1 instanceof ValorInteiro && v2 instanceof ValorInteiro) {
			ValorInteiro valor1 = (ValorInteiro) v1;
			ValorInteiro valor2 = (ValorInteiro) v2;
			
			return new ValorInteiro(valor1.getValor() + valor2.getValor());
		}
		//TODO: implementar uma checagem de tipos adequada
		throw new RuntimeException("Erro de tipos!!!!");
	}

}
