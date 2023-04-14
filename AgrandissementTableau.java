import java.util.Arrays;

class AgrandissementTableau {

	static float[] agrandir(float[] tableau) { // méthode qui ajoute la moyenne des 2 nombres adjacents

		float[] nouveauTableau = new float[(tableau.length * 2) - 1];

		for (int i = 0; i < tableau.length - 1; i++) {

			nouveauTableau[2 * i] = tableau[i];

			float moyenne = (tableau[i] + tableau[i + 1]) / 2; 

			nouveauTableau[2 * i + 1] = moyenne;

		}

		nouveauTableau[nouveauTableau.length - 1] = tableau[tableau.length - 1];
		// la dernière valeur ne peut pas être calculée, il n'y a pas de prochain nombre

		return nouveauTableau;

	}

	static void imprimer(float[] tableau) { // imprime le tableau entré

		System.out.println(Arrays.toString(tableau));
		// nous devons utiliser la méthode "Arrays.toString()" pour imprimer un tableau

	}

	public static void main(String[] args) {

		float[] tableau = {0.01f, 1, 2, 3.5f, 4}; // tableau à agrandir
		// nous devons mettre "f" après "0.01" et "3.5" pour préciser qu'il s'agit d'un flotant (et non d'un double)

		System.out.print("tableau : ");

		imprimer(tableau);

		System.out.print("nouveau tableau : ");

		imprimer(agrandir(tableau));

	}

}
