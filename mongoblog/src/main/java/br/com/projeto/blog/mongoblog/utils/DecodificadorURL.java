package br.com.projeto.blog.mongoblog.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodificadorURL {

	public static String decodificarParametroDeRequisicao(String texto) {
		try {
			return URLDecoder.decode(texto, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}