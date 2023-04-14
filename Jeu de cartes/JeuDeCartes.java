import java.util.Random;
import java.util.Arrays;

class JeuDeCartes {

	public static void main(String[] args) {

		int tailleDeLaMain = 5;

		Random aleatoire = new Random();

		Carte[] main = new Carte[tailleDeLaMain]; // contient les cartes

		for (int i = 0; i < tailleDeLaMain; i++) {

			Carte carte = new Carte(1 + aleatoire.nextInt(12), Carte.familles[aleatoire.nextInt(3)], true);
			main[i] = carte;

		}

		System.out.println("	Voici votre main :");

		for (int i = 0; i < tailleDeLaMain; i++) {


			main[i].imprimer();
			System.out.println(main[i].texte());

		}

	}

}
