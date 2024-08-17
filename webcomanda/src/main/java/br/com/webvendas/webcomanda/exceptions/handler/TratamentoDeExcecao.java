package br.com.webvendas.webcomanda.exceptions.handler;

import br.com.webvendas.webcomanda.exceptions.ExcecaoDeRecursoNaoEncontrado;
import br.com.webvendas.webcomanda.exceptions.ExcecaoDeBancoDeDados;
import br.com.webvendas.webcomanda.exceptions.ExcecaoGeral;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;

@ControllerAdvice
public class TratamentoDeExcecao implements Serializable {
	
	@ExceptionHandler(ExcecaoDeRecursoNaoEncontrado.class)
	public ResponseEntity<ExcecaoGeral> recursoNaoEncontrado(
											ExcecaoDeRecursoNaoEncontrado e, 
											HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ExcecaoGeral excecaoGeral = new ExcecaoGeral(
		                          e.getMessage(),
								  status.value(),
								  request.getRequestURI()
								  );
		return ResponseEntity.status(status).body(excecaoGeral);
	}
	
	@ExceptionHandler(ExcecaoDeBancoDeDados.class)
	public ResponseEntity<ExcecaoGeral> recursoNaoConstaNoBanco(
											ExcecaoDeBancoDeDados e, 
											HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ExcecaoGeral excecaoGeral = new ExcecaoGeral(
		                          e.getMessage(),
								  status.value(),
								  request.getRequestURI()
								  );
		return ResponseEntity.status(status).body(excecaoGeral);
	}
}