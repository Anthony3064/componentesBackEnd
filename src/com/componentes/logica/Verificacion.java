package com.componentes.logica;

public class Verificacion {
	
	public static boolean VerificarString(String string) {
		if(string == null || string.isEmpty()) {
			return false; 
		}else {
			return true; 
		}
	}
}
