package suffixCalc;

public class EvaluateurSuffixe {
	
	public static double evaluerSuffixe(String expSuffx) {
		
		char courant;
		Pile<Double> valeursActives = new Pile<Double>();
		
		for(int i = 0; i < expSuffx.length(); i++) {
			
			courant = expSuffx.charAt(i);
			
			//operateur
			if(ConvertisseurInfixeEnSuffixe.estUnOperateur(courant)) {
				
				double x = valeursActives.depiler();
				double y = valeursActives.depiler();
				double res = resultat(y, courant, x);
				valeursActives.empiler(res);
				
			//chiffre
			} else {
				
				valeursActives.empiler((double) Character.getNumericValue(courant));
			}
		}
		
		return valeursActives.depiler();
	}
	
	//utilisation de double a cause de la division
	public static double resultat(double operande1, char operateur, double operande2) {
		
		switch(operateur) {
		
		case '+':
			return operande1 + operande2;
		case '-':
			return operande1 - operande2;
		case '*':
			return operande1 * operande2;
		case '/':
			return operande1 / operande2;
		}
		
		//ligne obligatoire pour eviter une erreur du compilateur
		return 0;
	}
 }