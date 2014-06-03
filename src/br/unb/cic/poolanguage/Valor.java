package br.unb.cic.poolanguage;

/**
 * Representa um valor abstrato, pode ser 
 * um valor inteiro, um valor booleano ou 
 * um valor de um tipo complexo qualquer. 
 * 
 * @author rbonifacio
 */
public class Valor implements Expressao {
	
	public Valor avaliar() {
		return this;
	}
	
}
