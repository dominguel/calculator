package suffixCalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestProgramme {
	
	/**
	 * Classe permettant � un utilisateur d'entrer une expression arithm�tique en notation infix�e,
	 * pour ensuite la convertir en notation suffix�e et finalement l'�valuer.
	 * 
	 * Restriction  l'application ne supporte que les nombres de 0 � 9.
	 * 
	 * Auteur: Lucas Domingue
	 * 
	 * 
	 * Date: 2017-04-15
	 * @throws IOException 
	 *
	 */
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Entrez une expression infix�e valide");
		System.out.println("utilisant des entiers � un seul chiffre");
		System.out.println("et les op�rateurs/notations suivants: + - * / ( )");
		System.out.println("dans la console, sans espaces.");
		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println();
		
		String expSuffx = ConvertisseurInfixeEnSuffixe.convertirEnSuffixe(input);
		System.out.println("Forme Suffix�e: " + expSuffx);
		
		double resultat = EvaluateurSuffixe.evaluerSuffixe(expSuffx);
		System.out.println("R�sultat: " + resultat);
	}

}