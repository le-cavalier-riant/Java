// ================================================================================================================== //
//                                                                                                                    //
//                                                       Dames                                                        //
//                                                                                                                    //
// ================================================================================================================== //

import java.util.Scanner;
import java.lang.Thread;

class Dames {

	static int pause = 1500; // millisecondes
	static int tour = 0;
	static boolean tourBlanc = true;

	static void attendre() {try {Thread.sleep(pause);} catch (InterruptedException e) {}}

	static Plateau plateauAvecPions() {

		Plateau plateau = new Plateau();
		return Plateau.ajouterPions(plateau);

	}

	static int lettreEnEntier(String lettre) {

		lettre = lettre.toUpperCase();
		return switch (lettre) {
			case "A" ->	0;
			case "B" -> 1;
			case "C" -> 2;
			case "D" -> 3;
			case "E" -> 4;
			case "F" -> 5;
			case "G" -> 6;
			case "H" -> 7;
			case "I" -> 8;
			case "J" -> 9;
			default -> {
				System.out.println("	D\u00e9sol\u00e9, la lettre n'est pas reconnue.");
				yield -1;
			}
		};

	}

	static void erreurManche(Plateau plateau) {

		System.out.println("	Veuillez r\u00e9essayer.");
		attendre();
		plateau.imprimer();
		manche(plateau);

	}

	static boolean deplacementLegal(int ancienneOrdonnee, int ancienneAbscisse, int nouvelleOrdonnee, int nouvelleAbscisse) {

		int differenceOrdonnee = nouvelleOrdonnee - ancienneOrdonnee;
		int differenceAbscisse = nouvelleAbscisse - ancienneAbscisse;
		return Math.abs(differenceOrdonnee) == 1 && Math.abs(differenceAbscisse) == 1;

	}

	static void manche(Plateau plateau) {

		Scanner lire = new Scanner(System.in);
		String joueur;
		joueur = "NOIR";
		if (tourBlanc) {
			joueur = "BLANC";
		}

		System.out.println("\n	Tour n\u00b0" + (tour + 1) + "	[ Joueur " + joueur + " ] Quel pion voulez-vous d\u00e9placer ? (Lettre, chiffre)");
		String[] anciennesCoordonneesString = lire.nextLine().split(", ");
		int ancienneOrdonnee = Integer.parseInt(anciennesCoordonneesString[1]) - 1;
		int ancienneAbscisse = lettreEnEntier(anciennesCoordonneesString[0]);
		if (ancienneAbscisse < 0 || ancienneOrdonnee > 9) {
			System.out.println("	D\u00e9sol\u00e9, la cellule vis\u00e9e est hors du plateau !");
			erreurManche(plateau);
			return;
		}
		if (plateau.grille[ancienneOrdonnee][ancienneAbscisse].etat == "Vide") {
			System.out.println("	D\u00e9sol\u00e9, la cellule selectionn\u00e9e est vide.");
			erreurManche(plateau);
			return;
		}
		if (plateau.grille[ancienneOrdonnee][ancienneAbscisse].estPieceBlanche != tourBlanc) {
			System.out.println("	D\u00e9sol\u00e9, la pi\u00e8ce selectionn\u00e9e n'est pas de la bonne couleur.");
			erreurManche(plateau);
			return;
		}

		System.out.println("			[ Joueur " + joueur + " ] O\u00f9 voulez-vous le d\u00e9placer ? (abscice, ordonn\u00e9e)");
		String[] nouvellesCoordonneesString = lire.nextLine().split(", ");
		int nouvelleOrdonnee = Integer.parseInt(nouvellesCoordonneesString[1]) - 1;
		int nouvelleAbscisse = lettreEnEntier(nouvellesCoordonneesString[0]);
		if (nouvelleOrdonnee < 0 || nouvelleAbscisse > 9) {
			System.out.println("	D\u00e9sol\u00e9, la cellule vis\u00e9e est hors du plateau !");
			erreurManche(plateau);
			return;
		}
		if (plateau.grille[nouvelleOrdonnee][nouvelleAbscisse].estPieceBlanche == plateau.grille[ancienneOrdonnee][ancienneAbscisse].estPieceBlanche && plateau.grille[nouvelleOrdonnee][nouvelleAbscisse].etat != "Vide") {
				System.out.println("\n	D\u00e9sol\u00e9, la cellule vis\u00e9e est occup\u00e9e.");
			return;
		}
		if (!deplacememLegal(ancienneOrdonnee, ancienneAbscisse, nouvelleOrdonnee, nouvelleAbscisse)) {
			System.out.println("	D\u00e9sol\u00e9, ce d\u00e9placement est interdit.");
			erreurManche(plateau);
			return;
		}
		plateau.deplacement(ancienneOrdonnee, ancienneAbscisse, nouvelleOrdonnee, nouvelleAbscisse);
		plateau.imprimer();
		tour++;
		tourBlanc = !tourBlanc;

	}

	public static void main(String[] args) {

		Plateau plateauDeJeu = plateauAvecPions();
		plateauDeJeu.imprimer();
		boolean partieFinie = false;
		while (!partieFinie || tour > 5) {
			manche(plateauDeJeu);
		}
		System.out.println("	Partie termin\u00e9e !");

	}

}

// ================================================================================================================== //
//                                                                                                                    //
//                                                       Dames                                                        //
//                                                                                                                    //
// ================================================================================================================== //