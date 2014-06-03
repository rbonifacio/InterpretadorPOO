package br.unb.cic.poolanguage;

/**
 * Representa um valor abstrato, pode ser 
 * um valor inteiro, um valor booleano ou 
 * um valor de um tipo complexo qualquer. 
 * 
 * @author rbonifacio
 */
public abstract class Valor implements Expressao {
	
	public Valor avaliar() {
		return this;
	}
	
	@Override
	public boolean verificarTipo() {
		return true;
	}
	
}
