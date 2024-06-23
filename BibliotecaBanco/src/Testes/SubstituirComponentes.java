package Testes;

import java.util.Arrays;

public class SubstituirComponentes {

	public class SalvarComponentes {

	    public static String[] salvarEmArray(String entrada) {
	        if (entrada == null || entrada.isEmpty()) {
	            return new String[0]; 
	        }
	        String[] componentes = entrada.split(",\\s*");
	        return componentes;
	    }
	    public static void main(String[] args) {
	        String entrada = "x, y, z";
	        String[] resultado = salvarEmArray(entrada);
	
	        for (String componente : resultado) {
	            System.out.println(componente);     
	        }
	    }
	}
}
