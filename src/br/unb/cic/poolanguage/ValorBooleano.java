package br.unb.cic.poolanguage;

public class ValorBooleano extends ValorParametrizado<Boolean>{

	public ValorBooleano(Boolean valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.Booleano;
	}

}
