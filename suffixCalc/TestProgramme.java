package suffixCalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestProgramme {
	
	/**
	 * Classe permettant à un utilisateur d'entrer une expression arithmétique en notation infixée,
	 * pour ensuite la convertir en notation suffixée et finalement l'évaluer.
	 * 
	 * Restriction  l'application ne supporte que les nombres de 0 à 9.
	 * 
	 * Auteur: Lucas Domingue
	 * 
	 * 
	 * Date: 2017-04-15
	 * @throws IOException 
	 *
	 */
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Entrez une expression infixée valide");
		System.out.println("utilisant des entiers à un seul chiffre");
		System.out.println("et les opérateurs/notations suivants: + - * / ( )");
		System.out.println("dans la console, sans espaces.");
		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println();
		
		String expSuffx = ConvertisseurInfixeEnSuffixe.convertirEnSuffixe(input);
		System.out.println("Forme Suffixée: " + expSuffx);
		
		double resultat = EvaluateurSuffixe.evaluerSuffixe(expSuffx);
		System.out.println("Résultat: " + resultat);
	}

}