package suffixCalc;


public class Pile<E> {
	private int maxElements=1000;
	private E elements[];
	private int sommet;
	
	//constructeur
	@SuppressWarnings("unchecked")
	public Pile() {
			elements = (E[ ]) new Object[maxElements];
			sommet = -1;
	}
	
	//ajoute l'element au dessus de la pile
	public void empiler(E nouvElem) {
		if (sommet == (maxElements-1)) {
			System.out.println("Desole, la pile est pleine!");
		} else {
			//on empile l'élément
			sommet = sommet + 1;
			elements[sommet] = nouvElem;
		}
	}
	
	//revoie (enleve) l'element du dessus de la pile
	public E depiler() {
		if (sommet < 0) {
			System.out.println("Errreur: la pile est vide, on ne peut pas depiler!");
			return (E) null;
		} else {			
			E elemDuHaut = (E) elements[sommet];
			sommet = sommet - 1;
			return elemDuHaut;
		}
	}
	
	//true si pile est vide
	public boolean vide(){
		return sommet==-1;
	}
	
	//depiler() sans enlever l'element
	public E voir(){
		return(E) elements[sommet];
	}
	
}

