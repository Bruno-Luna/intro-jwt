package com.luna.jwt.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.Date;

public class TokenJwt {

	private Key chave;
	
	private String jwt;
	
	public TokenJwt(Key chave) {
		this.chave = chave;
	}
	
	 public String gerarToken(String nomeUsuario, Date dataExpiracao) {
	        jwt = Jwts.builder()
	                .setHeaderParam("typ","JWT")
	                .setSubject(nomeUsuario)
	                .setIssuer("Java developer")
	                .setIssuedAt(new Date())
	                .setExpiration(dataExpiracao)
	                .signWith(SignatureAlgorithm.HS256, chave)
	                .compact();
	        return jwt;
	    }

	 
	 public boolean validarToken() {
	        try {
	            Jwts.parser().setSigningKey(chave).parseClaimsJws(jwt);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
}
