package pe.com.microservice.taxiboot.service.util;

public class Util {

	public static String completar(int numero) {
		
		String valor = String.valueOf(numero);
		if(valor.length()==1)	valor = "00000".concat(valor);
		else if(valor.length()==2)	valor = "0000".concat(valor);
		else if(valor.length()==3)	valor = "000".concat(valor);
		else if(valor.length()==4)	valor = "00".concat(valor);
		else if(valor.length()==5)	valor = "0".concat(valor);
		return valor;
	}
	
}
