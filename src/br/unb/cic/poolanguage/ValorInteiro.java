package br.unb.cic.poolanguage;

public class ValorInteiro extends ValorParametrizado<Integer>{

	public ValorInteiro(Integer valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.Inteiro;
	}
}
