package br.com.projeto.blog.mongoblog.exceptions;

public class ExcecaoDeDocumentoMongodbNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExcecaoDeDocumentoMongodbNaoEncontrado(String mensagem){
		super(mensagem);
	}
	
}