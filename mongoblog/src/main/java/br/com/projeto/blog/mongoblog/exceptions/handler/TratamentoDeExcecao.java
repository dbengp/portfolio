package br.com.projeto.blog.mongoblog.exceptions.handler;

import br.com.projeto.blog.mongoblog.exceptions.ExcecaoDeDocumentoMongodbNaoEncontrado;
import br.com.projeto.blog.mongoblog.exceptions.ExcecaoGeral;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;

@ControllerAdvice
public class TratamentoDeExcecao implements Serializable {
	
	@ExceptionHandler(ExcecaoDeDocumentoMongodbNaoEncontrado.class)
	public ResponseEntity<ExcecaoGeral> documentoMongodbNaoEncontrado(
											ExcecaoDeDocumentoMongodbNaoEncontrado e, 
											HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ExcecaoGeral excecaoGeral = new ExcecaoGeral(
		                          e.getMessage(),
								  status.value(),
								  request.getRequestURI()
								  );
		return ResponseEntity.status(status).body(excecaoGeral);
	}
	
}