package com.davinogueira.desafiosGloboCom;

import java.util.HashMap;
import java.util.Map;

public class Desafios {

	public String pingPong(int numero){
		boolean multiploDeTres = numero % 3 == 0;
		boolean multiploDeCinco = numero % 5 == 0; 
		
		if(multiploDeTres && multiploDeCinco){
			return "ping pong";
		} else if(multiploDeTres){
			return "ping";
		} else if(multiploDeCinco){
			return "pong";
		}
		return "";
	}
	
	public void imprimePingPong(){
		for(int i = 0; i <= 100; i++){
			String palavra = pingPong(i);
			
			if(palavra.isEmpty()){
				System.out.println("numero: " + i);
			} else {
				System.out.println(palavra);
			}
		}
	}
	
	public long fatorialRecursivo(long numero){
		if(numero <= 0){
			return 1;
		} else {
			return fatorialRecursivo(numero -1) * numero;
		}
	}
	
	public long fatorialIterativo(long numero){
		long retorno = 1;
		for(int i = 1; i <= numero; i++){
			retorno = retorno * i;
		}
		return retorno;
	}
	
	public Map<String, Integer> frequencia(String palavra){
		Map<String, Integer> valores = new HashMap<String, Integer>();
		
		for(int i = 0; i < palavra.length(); i++){
			String letra = String.valueOf(palavra.charAt(i));
			
			if(!valores.containsKey(letra)){
				valores.put(letra, 1);
			} else {
				Integer quantidade = valores.get(letra);
				valores.put(letra, quantidade + 1);
			}
		}
		
		return valores;
	}
	
}
