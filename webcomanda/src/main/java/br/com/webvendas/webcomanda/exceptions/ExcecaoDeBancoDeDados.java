package br.com.webvendas.webcomanda.exceptions;

public class ExcecaoDeBancoDeDados extends RuntimeException {
	
	private static final long serialVersionUID = 9L;
	
	public ExcecaoDeBancoDeDados(){
		super("operação imprópia: violação de integridade");
	}
}