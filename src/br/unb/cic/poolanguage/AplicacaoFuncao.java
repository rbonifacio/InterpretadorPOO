package br.unb.cic.poolanguage;

import java.util.List;

import br.unb.cic.poolanguage.visitors.Visitor;

public class AplicacaoFuncao implements Expressao {

	public String getNome() {
		return nome;
	}

	public List<Expressao> getArgumentos() {
		return argumentos;
	}

	private String nome; 
	private List<Expressao> argumentos; 
	
	public AplicacaoFuncao(String nome, List<Expressao> argumentos) {
		this.nome = nome;
		this.argumentos = argumentos;
	}

	@Override
	public Valor avaliar() {
		if(verificarTipo()) {
			//primeiro passo: empilha um novo ambiente 
			//de execucao. Isso deve ser suficiente para 
			//implementar uma nocao de escopo aninhado. 
			
			
			DeclaracaoFuncao dec = Interpretador.instance().obtemDeclaracaoFuncao(nome);
			
			atualizaAmbiente(dec);
			
			//avaliamos o corpo da funcao no ambiente atual.
			Valor retorno = dec.getCorpoFuncao().avaliar(); 
			
			//desempilhamos e retornamos o valor resultante da avaliacao. 
			
			AmbienteAvaliacao.instance().desempilha();
			
			return retorno;
		}
		else {
			throw new RuntimeException("Erro de tipo");
		}
	}

	private void atualizaAmbiente(DeclaracaoFuncao dec) {
		AmbienteAvaliacao.instance().empilha();
		
		//Adiciona no ambiente as associacoes entre os argumentos 
		//formais e os parametros (expressoes) passados na chamada 
		//da funcao. 
		int i = 0; 
		for(ArgumentoFormal arg: dec.getArgumentos()) {
			AmbienteAvaliacao.instance().defineVariavel(arg.getNome(), argumentos.get(i++));
		}
	}

	@Override
	public Tipo tipo() {
		//caso a verificacao de tipo nao seja false, retorna o tipo do corpo 
		//da funcao. isso eh uma simplificaca, se compararmos com o sistema 
		//de tipos de Haskell.
		if(verificarTipo()) {
			DeclaracaoFuncao dec = Interpretador.instance().obtemDeclaracaoFuncao(nome);
			atualizaAmbiente(dec);
			Tipo tipo = dec.getCorpoFuncao().tipo();
			AmbienteAvaliacao.instance().desempilha();
			return tipo;
		}
		return Tipo.Inconsistente;
	}

	@Override
	public boolean verificarTipo() {
		DeclaracaoFuncao dec = Interpretador.instance().obtemDeclaracaoFuncao(nome);
	
		//funcao nao declarada
		if(dec == null) {
			return false;
		}
		atualizaAmbiente(dec);
		
		//quantidade de argumentos difere
		if(dec.getArgumentos().size() != argumentos.size()) {
			return false; 
		}
		
		//os tipos dos argumentos sao correspondentes?
		int i = 0;
		for(ArgumentoFormal argumento : dec.getArgumentos()) {
			if(argumento.getTipo() != argumentos.get(i++).tipo()) {
				return false;
			}
		}
		
		//se chegar ate aqui, a funcao foi declarada e os 
		//tipos dos argumentos sao correspondentes. precisamos 
		//apenas verificar o tipo do corpo da funcao.
		boolean res = dec.getCorpoFuncao().verificarTipo();
		
		AmbienteAvaliacao.instance().desempilha();
	
		return res;		
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
