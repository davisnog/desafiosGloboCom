package com.davinogueira.desafiosGloboCom;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DesafiosTest {

	private Desafios desafios;
	
	@Before
	public void setUp() throws Exception {
		this.desafios = new Desafios();
	}

	@After
	public void tearDown() throws Exception {
		this.desafios = null;
	}

	@Test
	public void deveRetornarPing() {
		String palavra = desafios.pingPong(21);
		
		assertEquals("ping", palavra);
	}
	
	@Test
	public void deveRetornarPong() {
		String palavra = desafios.pingPong(25);
		
		assertEquals("pong", palavra);
	}
	
	@Test
	public void deveRetornarPingPong() {
		String palavra = desafios.pingPong(15);
		
		assertEquals("ping pong", palavra);
	}
	
	@Test
	public void deveRetornarVazio() {
		String palavra = desafios.pingPong(41);
		
		assertEquals("", palavra);
	}
	
	@Test
	public void deveRetornarDuasLetras(){
		Map<String, Integer> frequencia = desafios.frequencia("ana");
		Map<String, Integer> frequencia2 = desafios.frequencia("Atenção");
		
		int resultado = frequencia.get("a");
		int resultado2 = frequencia2.get("a");
		
		assertEquals(2, resultado);
		assertEquals(2, resultado2);
	}
	
	@Test
	public void deveRetornarNoveLetras(){
		String palavra = "pneumoultramicroscopicossilicovulcanoconiotico";
		Map<String, Integer> frequencia = desafios.frequencia(palavra);
		
		int resultado = frequencia.get("o");
		
		assertEquals(9, resultado);
	}
	
	@Test
	public void deveRetornarUmaLetras(){
		String palavra = "davi";
		Map<String, Integer> frequencia = desafios.frequencia(palavra);
		
		int resultado = frequencia.get("d");
		
		assertEquals(1, resultado);
	}
	
	@Test
	public void deveRetornoar3628800NoFatorialDe10NoRecursivo(){
		long esperado = 3628800;
		
		long calculado = desafios.fatorialRecursivo(10);
		
		assertEquals(esperado, calculado);
	}
	
	@Test
	public void deveRetornoar3628800NoFatorialDe10NoIterativo(){
		long esperado = 3628800;
		
		long calculado = desafios.fatorialIterativo(10);
		
		assertEquals(esperado, calculado);
	}
}
