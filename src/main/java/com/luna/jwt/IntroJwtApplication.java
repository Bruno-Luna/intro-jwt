package com.luna.jwt;

import java.util.Date;

import com.luna.jwt.jwt.TokenJwt;
import com.luna.jwt.utils.Utils;

public class IntroJwtApplication {

		public static void main(String args[]) throws InterruptedException {
	        TokenJwt token = new TokenJwt(Utils.gerarChave());

	        System.out.println("\t*** Gerando o JSON Web Token ***");
	        Date dataDeExpiracao = Utils.definirDataDeExpiracao(60L); //60minutos para expirar o token
	        String jwt = token.gerarToken("Bruno Luna", dataDeExpiracao);

	        System.out.println("\nJWT: " + jwt);
	        
	        	
	        System.out.println("\n\t :: Aguarde alguns segundos. Estamos verificando a validade do token ::\n");
	        Thread.sleep(8000L); //faz a aplicação dormir por 'x' tempo - é medido em milisegundos
	        
	        if(token.validarToken()) {
	        	System.out.println("Token válido ✔");
	        } else {
	        	System.out.println("Token inválido ❌");
	        }
		}

}
