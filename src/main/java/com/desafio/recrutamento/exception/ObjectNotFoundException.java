package com.desafio.recrutamento.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public ObjectNotFoundException(String mensagem, Throwable causaDoErro) {
		super(mensagem, causaDoErro);
	}

}
