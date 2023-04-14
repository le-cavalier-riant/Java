import java.util.*;

class Tri {

	public static void main(String[] args) {

		String separateur = "========================================";
		Scanner lire = new Scanner(System.in); // necessaire pour lire les entrées

		List <Integer> listeDesNombres = new LinkedList <Integer>();
		// cette liste va contenir les nombres

		System.out.println("Veuillez entrer le 1er nombre (non nul)");

		int nouveauNombre = lire.nextInt();  // lis l'entrée (entiers seulement)

		if (nouveauNombre == 0) { // 0 en 1ère entrée

			System.out.println("Désolé il y a eu un erreur, n'entrez pas \"0\".");

		} else {

			listeDesNombres.add(nouveauNombre);

			while (nouveauNombre != 0) {

				System.out.println("Please, enter your next number:");
				nouveauNombre = lire.nextInt();  // lire user input (integer only)

				if (nouveauNombre != 0) {

					listeDesNombres.add(nouveauNombre);

				}

			}

			System.out.println(separateur);
			System.out.println("	Sequence = " + listeDesNombres);
			System.out.println(separateur);

			int somme = 0;
			int constant = 0;
			int croissant = 0;
			int decroissant = 0;

			for (int i = 0; i < listeDesNombres.size() - 1; i++) {

				somme += listeDesNombres.get(i);

				if (listeDesNombres.get(i) == listeDesNombres.get(i + 1)) {

					constant += 1;

				}

				if (listeDesNombres.get(i) <= listeDesNombres.get(i + 1)) {

					croissant += 1;

				}

				if (listeDesNombres.get(i) >= listeDesNombres.get(i + 1)) {

					decroissant += 1;

				}

			}

			somme += listeDesNombres.get(listeDesNombres.size() - 1);
			double moyenne = (double) somme / listeDesNombres.size();
			System.out.println("	Avegarde = " + moyenne);
			System.out.println(separateur);

			if (listeDesNombres.size() > 1) {

				int dexiemePlusGrand = listeDesNombres.get(1);
				int plusGrand = listeDesNombres.get(0);
				int dexiemePlusPetit = listeDesNombres.get(1);
				int plusPetit = listeDesNombres.get(0);

				for (int nombre : listeDesNombres) {

					if (nombre > plusGrand) {

						dexiemePlusGrand = plusGrand;
						plusGrand = nombre;

					} else if (nombre > dexiemePlusGrand) {

						dexiemePlusGrand = nombre;

					}

					if (nombre < plusPetit) {

						dexiemePlusPetit = plusPetit;
						plusPetit = nombre;

					} else if (nombre < dexiemePlusPetit) {

						dexiemePlusPetit = nombre;
					}

				}

				System.out.println("	Second biggest = " + dexiemePlusGrand);
				System.out.println(separateur);
				System.out.println("	Second smallest = " + dexiemePlusPetit);
				System.out.println(separateur);

			} else {

				System.out.println("	Sorry, there is no second second biggest or smallest element.");
				System.out.println(separateur);

			}

			System.out.print("	The sequence is ");

			if (constant == listeDesNombres.size() - 1) {

				System.out.println("constant.");
				System.out.println(separateur);

			} else if (croissant == listeDesNombres.size() - 1) {

				System.out.println("growing.");
				System.out.println(separateur);

			} else if (decroissant == listeDesNombres.size() - 1) {

				System.out.println("descending.");
				System.out.println(separateur);

			} else {

				System.out.println("not monotonous.");
				System.out.println(separateur);

			}

		}

	}

}
