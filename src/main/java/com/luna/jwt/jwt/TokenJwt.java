package com.luna.jwt.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.Date;

public class TokenJwt {

	private Key chave;
	
	private String jwt;
	
	//construtor. Sem a chave não fará a geração do json web-token
	public TokenJwt(Key chave) {
		this.chave = chave;
	}
	
	 public String gerarToken(String nomeUsuario, Date dataExpiracao) {
		 //classe Jwts
	        jwt = Jwts.builder()
	        		//Criação das partes do JWT
	        		//Header
	                .setHeaderParam("typ","JWT")
	                
	                //corpo (payload)
	                .setSubject(nomeUsuario)
	                .setIssuer("Luna©")
	                .setIssuedAt(new Date())
	                .setExpiration(dataExpiracao)
	                
	                //Assinatura do token(algoritmo + chave)
	                .signWith(SignatureAlgorithm.HS256, chave)
	                .compact(); //construirá o jwt
	        return jwt;
	    }

	 //fará a validação do token, caso não seja a exceção será lançada(false)
	 public boolean validarToken() {
	        try {
	            Jwts.parser().setSigningKey(chave).parseClaimsJws(jwt);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	 
	 public String recuperarSubjectToken() {
		 Jws<Claims> claimsJws = Jwts.parser().setSigningKey(chave).parseClaimsJws(jwt);
		 return claimsJws.getBody().getSubject();
	 }
	 
	 public String recuperarIssueToken() {
		 Jws<Claims> claimsJws = Jwts.parser().setSigningKey(chave).parseClaimsJws(jwt);
		 return claimsJws.getBody().getIssuer();
	 }
	 
	 public String recuperarDateToken() {
		 Jws<Claims> claimsJws = Jwts.parser().setSigningKey(chave).parseClaimsJws(jwt);
		 return claimsJws.getBody().getIssuedAt().toLocaleString();
	 }
}
