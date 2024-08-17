package br.com.webvendas.webcomanda.exceptions;

public class ExcecaoDeRecursoNaoEncontrado extends RuntimeException {
	
	private static final long serialVersionUID = 9L;
	
	public ExcecaoDeRecursoNaoEncontrado(){
		super("recurso não encontrado");
	}
}