package br.unb.cic.poolanguage;

public abstract class ValorParametrizado<T> extends Valor {

	private T valor;
	
	public ValorParametrizado(T valor) {
		this.valor = valor;
	}
	
	
	public T getValor() {
		return valor;
	}
}
