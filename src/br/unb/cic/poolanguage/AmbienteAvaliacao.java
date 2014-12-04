package br.unb.cic.poolanguage;

import java.util.HashMap;
import java.util.Stack;

/**
 * O ambiente de avaliacao eh um singleton, 
 * que representa uma pilha de mapeamentos entre 
 * nomes e expressoes (com o uso de um hashmap). 
 * Dependendo da forma de localizacao de um determinado 
 * nome, podemos implementar diferentes estrategias de 
 * escopo. 
 * 
 * @author rbonifacio
 */
public class AmbienteAvaliacao {

	private Stack<HashMap<String, Expressao>> ambiente;
	
	private static AmbienteAvaliacao instance;
	
	public static AmbienteAvaliacao instance() {
		if(instance == null) {
			instance = new AmbienteAvaliacao();
		}
		return instance; 
	}
	
	private AmbienteAvaliacao() {
		ambiente = new Stack<HashMap<String,Expressao>>();
	}
	
	public void empilha() {
		ambiente.push(new HashMap<String, Expressao>());
	}

	public void desempilha() {
		if(!ambiente.empty()) {
			ambiente.pop();
		}
	}
	
	public void defineVariavel(String nome, Expressao exp) {
		if(ambiente.empty()) {
			empilha();
		}
		ambiente.peek().put(nome, exp);
	}
	
	public Expressao consultaExpressao(String nome) {
		if(ambiente.empty()) {
			return null;
		}
		else {
			return ambiente.peek().get(nome);
		}
	}

	public void reinicializar() {
		ambiente.clear();
	}
}
