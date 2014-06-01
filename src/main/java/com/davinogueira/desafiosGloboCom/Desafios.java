package com.davinogueira.desafiosGloboCom;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.IntStream;

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
	
	public Map<Character, Integer> frequencia(String palavra){
		Map<Character, Integer> valores = new HashMap<>();
		
		String normaliza = Normalizer.normalize(palavra, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]","").toLowerCase();
		
		for(int i = 0; i < palavra.length(); i++){
			Character letra = normaliza.charAt(i);
			
			if(!valores.containsKey(letra)){
				valores.put(letra, 1);
			} else {
				Integer quantidade = valores.get(letra);
				valores.put(letra, quantidade + 1);
			}
		}
		
		return valores;
	}
	
	public Map<Character, Integer> frequenciaJava8(String palavra){
		String normaliza = Normalizer.normalize(palavra, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]","").toLowerCase();
		
		List<String> ls = Arrays.asList(normaliza);
		
		Map<Character, Integer> count = ls.stream()
				.flatMap(line -> IntStream.range(0, line.length()).mapToObj(line::charAt))
				.filter(Character::isLetter).
                map(Character::toLowerCase).
                collect(TreeMap::new, (m, c) -> m.merge(c, 1, Integer::sum), Map::putAll);
		
		return count;
	}
	
	public void imprimeFrequenciaOrdenado(String palavra){
		Map<Character, Integer> frequencia = frequencia(palavra);
		List<Entry<Character, Integer>> frequenciaList = new ArrayList<>(frequencia.entrySet());
		
		Collections.sort(frequenciaList, new Comparator<Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1,
					Entry<Character, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		for(Entry<Character, Integer> freq : frequenciaList){
			System.out.println(freq.getKey() + " : " + freq.getValue());
		}
		System.out.println();
	}
	
	public void imprimeFrequenciaOrdenadoJava8(String palavra){
		Map<Character, Integer> frequencia = frequenciaJava8(palavra);
		
		frequencia.entrySet().stream().
        sorted((l, r) -> l.getValue().compareTo(r.getValue())).
        forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
	}
	
	
}
