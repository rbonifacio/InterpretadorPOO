package br.unb.cic.poolanguage;

import java.util.HashMap;

import br.unb.cic.poolanguage.visitors.Visitor;

public class ExpRef implements Expressao {

	private String nome; 
	
	@Override
	public Valor avaliar() {
		if(verificarTipo()) {
			HashMap<String, Expressao> ambiente = getAmbiente();
			return ambiente.get(nome).avaliar();
		}
		else {
			throw new RuntimeException();
		}
	}

	private HashMap<String, Expressao> getAmbiente() {
		return null;
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
