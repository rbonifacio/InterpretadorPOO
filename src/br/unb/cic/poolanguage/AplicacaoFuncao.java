package br.unb.cic.poolanguage;

import java.util.HashMap;
import java.util.List;

import br.unb.cic.poolanguage.visitors.Visitor;

public class AplicacaoFuncao implements Expressao {

	private String nome; 
	private List<Expressao> argumentos; 
	
	@Override
	public Valor avaliar() {
		if(verificarTipo()) {
			HashMap<String, Expressao> ambiente = new HashMap<String, Expressao>();
			DeclaracaoFuncao dec = Interpretador.instance().obtemDeclaracaoFuncao(nome);
			
			int i = 0; 
			for(ArgumentoFormal arg: dec.getArgumentos()) {
				ambiente.put(arg.getNome(), argumentos.get(i++));
			}
			//TODO: o ambiente tem que ficar acessivel 
			//a funcao avaliar de alguma forma. 
			return dec.getCorpoFuncao().avaliar();
		}
		else {
			throw new RuntimeException("Erro de tipo");
		}
	}

	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verificarTipo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void aceitar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
