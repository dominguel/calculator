package suffixCalc;

public class ConvertisseurInfixeEnSuffixe {

	public static String convertirEnSuffixe(String expInfx) {
		
		Pile<Character> pileSuffixe = new Pile<Character>();
		pileSuffixe.empiler('(');
		
		expInfx += ")";
		String expSuffx = "";
		
		char courant;
		int i = 0;
		while(!pileSuffixe.vide()) {
			
			//probleme a cette ligne du a la var i rattachee a la pile plutot qu'a expInfx?
			courant = expInfx.charAt(i);
			
			//operateur
			if(estUnOperateur(courant)) {
				
				//tant que le dessus est un operateur (juste pour etre certain)
				while(estUnOperateur(pileSuffixe.voir())) {

					//si priorite >= courant
					if(prioriteEgaleOuGrande(pileSuffixe.voir(), courant)) {
						//ajouter dessus a l'expression
						expSuffx += pileSuffixe.depiler();
					} else {
						break;
					}
				}
				
				//apres avoir regarde les operateurs de la pile, y mettre courant
				pileSuffixe.empiler(courant);
				
			//parenthese gauche
			} else if(courant == '(') {
				
				pileSuffixe.empiler(courant);
				
			//parenthese droite
			} else if(courant == ')') {
				
				//tant que le dessus n'est pas une parenthese gauche
				while(pileSuffixe.voir() != '(') {
					
					//si operateur
					if(estUnOperateur(pileSuffixe.voir())) {
						//ajouter dessus a l'expression
						expSuffx += pileSuffixe.depiler();
					}
				}
				
				//depiler sans recipient supprime l'element
				pileSuffixe.depiler();
				
			/*chiffre (seule possibilite si expInfix ne contient pas de lettres)
			*d'ou l'importance de desinfecter les entrees de donnees
			*mais bon... c'est juste un TP*/
			} else {
				
				expSuffx += courant;
			}
			
			//incrementeur de la boucle while
			i++;
		}
		
		return expSuffx;
	}
	
	// operatur = {+, -, *, /}
	public static boolean estUnOperateur(char eval) {
		
		if(eval == '+' || eval == '-' || eval == '*' || eval == '/') {
			return true;
		}
		return false;
	}

	//true si priorite op1 >= op2
	public static boolean prioriteEgaleOuGrande(char op1, char op2) {

		if(op1 == '/' || op1 == '*') {
			
			return true;
		} else if(op1 == '+' || op1 == '-'){
			
			if(op2 == '+' || op2 == '-') {
				
				return true;
			}
		}
		return false;
	}
}