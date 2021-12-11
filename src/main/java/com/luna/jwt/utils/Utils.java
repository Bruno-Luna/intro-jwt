package com.luna.jwt.utils;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Utils {

	 public static Key gerarChave() {
	        String keyString = "GyhHEYyLLJUKJeABcqo0YO+QUd6ERarphT2go9S2i94="; //keyString = 'Java Developer' após SHA-256 e EncodeBase64;
	        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "HmacSHA256");
	        return key;
	    }

	    public static Date definirDataDeExpiracao(long tempoEmMinutos) {
	        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(tempoEmMinutos);
	        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	    }  //tempo que o token irá expirar, sendo assim perderá sua validade.
}
