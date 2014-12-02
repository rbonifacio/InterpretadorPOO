package br.unb.cic.poolanguage;

import br.unb.cic.poolanguage.visitors.Visitor;

/**
 * Expressao que representa uma referencia a um 
 * nome. Util quando lidamos com argumentos de 
 * funcoes, onde no corpo da funcao podemos referenciar 
 * os argumentos. Exemplo, suponha a definicao da funcao 
 * 
 *  inc :: Int -> Int
 *  inc x = x + 1
 * 
 *  semelhante a int inc(int x) { return x + x; } em uma 
 *  linguagem imperativa. 
 *  
 *  Essa funcao tem nome inc, e um argumento "x" de tipo 
 *  inteiro. O nome da funcao referencia o argumento "x", 
 *  e tal agumento precisa ser avaliado para fazer uma 
 *  computacao. Note que uma referencia eh uma expressao, 
 *  levando a um valor. A referencia precisa fazer parte do 
 *  ambiente de execucao, caso contrario ocorre um erro de 
 *  tipo, referencia nao declarada. 
 * 
 * @author rbonifacio
 *
 */
public class ExpRef implements Expressao {

	private String nome; 
	
	public ExpRef(String nome) {
		this.nome = nome;
	}
	
	@Override
	public Valor avaliar() {
		if(verificarTipo()) {
			Expressao exp = AmbienteAvaliacao.instance().consultaExpressao(nome);
			return exp.avaliar();
		}
		else {
			throw new RuntimeException();
		}
	}

	@Override
	public Tipo tipo() {
		//Analogo a implementacao do metodo verificar tipo. 
		//Ler comentario logo abaixo. 
		
		Expressao exp = AmbienteAvaliacao.instance().consultaExpressao(nome);
		
		return exp != null ? exp.tipo() : Tipo.Inconsistente;
	}

	@Override
	public boolean verificarTipo() {
		//corresponde ao tipo da expressao referenciado 
		//por nome no ambiente de execucao. Caso a referencia 
		//nao exista, o tipo nao eh valido. Caso a referencia 
		//exista, eh o verificar tipo da expressao. 
		
		Expressao exp = AmbienteAvaliacao.instance().consultaExpressao(nome);
		
		return exp != null ? exp.verificarTipo() : false;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
