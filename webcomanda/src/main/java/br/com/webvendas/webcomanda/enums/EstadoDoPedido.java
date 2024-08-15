package br.com.webvendas.webcomanda.enums;

public enum EstadoDoPedido {
	
	FEITO(1),
	PAGO(2),
	CANCELADO(3);
	
	private int code;
	
	private EstadoDoPedido(int code){
		
		this.code = code;
	}
	
	public int getCode(){
		
		return code;
	}
	
	public static EstadoDoPedido valueOf(int code){
		
		for(EstadoDoPedido value: EstadoDoPedido.values()){
			
			if(value.getCode() == code){
				return value;
			}
		}
		throw new IllegalArgumentException("código inválido");
	}
	
}
