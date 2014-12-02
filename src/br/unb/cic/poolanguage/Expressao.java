package br.unb.cic.poolanguage;

import br.unb.cic.poolanguage.visitors.Visitor;

/**
 * Uma interface para implementar expressoes em 
 * uma linguagem de programacao funcional, com 
 * suporte a um conjunto limitado de tipos. 
 * 
 * Note que essa implementacao combina tanto o 
 * padrao de projeto Interpreter quanto o padrao 
 * de projeto Visitor. 
 * 
 * @author rbonifacio
 */
public interface Expressao {
	public Valor avaliar();
	public Tipo tipo();
	public boolean  verificarTipo();
	public void aceitar(Visitor v);
}
