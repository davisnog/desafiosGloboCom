package com.davinogueira.desafiosGloboCom;

public class Principal {

	public static void main(String[] args) {
		Desafios desafios = new Desafios();
		
		String palavra = "pneumoultramicroscopicossilicovulcanoconiotico";
		
		desafios.imprimeFrequenciaOrdenado(palavra);
		desafios.imprimeFrequenciaOrdenadoJava8(palavra);
	}
}
