// =============================================================================================================== //
//                                                                                                                 //
//                                      Programme codé par Artus de Chavagnac                                      //
//                                                                                                                 //
//                                                  décembre 2022                                                  //
//                                                                                                                 //
// =============================================================================================================== //

import java.util.Scanner;
import java.io.*;

class Bataille {

	private static int compteTour = 1;
	private static String clair = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	// used to clair the console by passing many lines

	static PaquetDeCartes premierPaquet = new PaquetDeCartes(); // create a new full 52 cards deck
	static PaquetDeCartes gagnePremier = new PaquetDeCartes((PaquetDeCartes) null); // will contain the won cards of player 1

	static PaquetDeCartes secondPaquet = new PaquetDeCartes((PaquetDeCartes) null); // create a new empty deck
	static PaquetDeCartes gagneSecond = new PaquetDeCartes((PaquetDeCartes) null); // will contain the won cards of player 2

	static PaquetDeCartes enJeu = new PaquetDeCartes((PaquetDeCartes) null); // will store the cards during egalite

	static Scanner lire = new Scanner(System.in);


	static void tour(boolean egalite) { // PLAYER 1 vs. PLAYER 2

		System.out.println("\n	=== Let's start tour n\u00B0" + compteTour + ". ===");
		System.out.println("\n	=== PLAYER 1, your tour. ===");
		System.out.println("\nYour deck: " + premierPaquet.enTexte()); //
		System.out.println("\n === Now, chose the card you will use (type the index). ===");

		int indexJoueur1 = lire.nextInt() - 1;

		while (indexJoueur1 < 0 || indexJoueur1 >= premierPaquet.taille()) {
		// the user used an index out of the deck

			System.out.println("\n	There is no such card, please chose a corect card.");
			indexJoueur1 = lire.nextInt() - 1;

		}

		int force1 = premierPaquet.retournerLePaquet().get(indexJoueur1).retournerLaForce(); // the force of the selected card

		System.out.println("OK, you just chose the card: " + premierPaquet.retournerLePaquet().get(indexJoueur1).enTexte() + ".");

		try { // we have to use try/catch to prevent an error

			Thread.sleep(1000); // wait for 1000 ms so 1 s

		} catch (InterruptedException e) {

			//

		}

		System.out.println(clair);
		// we have to pass many lines so that the next player cannot see the previous card and deck

		System.out.println("\n	=== tour n\u00B0" + compteTour + ". ===");
		System.out.println("\n	=== PLAYER 2, your tour. ===");
		System.out.println("\nYour deck: " + secondPaquet.enTexte());
		System.out.println("\n === Now, chose the card you will use (type the index). ===");

		int indexJoueur2 = lire.nextInt() - 1;

		while (indexJoueur2 < 0 || indexJoueur2 >= secondPaquet.taille()) {
		// the user used an index out of the deck

			System.out.println("\n	There is no such card, please chose a corect card.");
			indexJoueur2 = lire.nextInt() - 1;

		}

		int force2 = secondPaquet.retournerLePaquet().get(indexJoueur2).retournerLaForce(); // the force of the selected card

		System.out.println("OK, you just chose the card: " + secondPaquet.retournerLePaquet().get(indexJoueur2).enTexte() + ".");

		try { // we have to use try/catch to prevent an error

			Thread.sleep(1000); // wait for 1000 ms so 1 s

		} catch (InterruptedException e) {

			//

		}

		System.out.println(clair);

		if (!egalite) { // normal game

			if (force1 > force2) { // PLAYER 1 has a bigger card than PLAYER 2

				System.out.println("\n	" + premierPaquet.retournerLePaquet().get(indexJoueur1).enTexte() + " is stonger than " + secondPaquet.retournerLePaquet().get(indexJoueur2).enTexte() + ".");

				premierPaquet.retierEtAjouter(indexJoueur1, gagnePremier);
				secondPaquet.retierEtAjouter(indexJoueur2, gagnePremier);
				// both chosen cards are going into the won cards deck of PLAYER 1

				System.out.println("\n	=== PLAYER 1 won! ===");

			} else if (force2 > force1) { // PLAYER 2 has a bigger card than PLAYER 1

				System.out.println("\n	" + premierPaquet.retournerLePaquet().get(indexJoueur1).enTexte() + " is weaker than " + secondPaquet.retournerLePaquet().get(indexJoueur2).enTexte() + ".");

				premierPaquet.retierEtAjouter(indexJoueur1, gagneSecond);
				secondPaquet.retierEtAjouter(indexJoueur2, gagneSecond);
				// both chosen cards are going into the won cards deck of PLAYER 2

				System.out.println("\n	=== PLAYER 2 won! ===");

			} else { // egalite

				System.out.println("\n	" + premierPaquet.retournerLePaquet().get(indexJoueur1).enTexte() + " is equal to " + secondPaquet.retournerLePaquet().get(indexJoueur2).enTexte() + ".");

				premierPaquet.retierEtAjouter(indexJoueur1, enJeu);
				secondPaquet.retierEtAjouter(indexJoueur2, enJeu);	
				// both chosen cards are going into the storage deck enJeu

				System.out.println("\n	=== Equality! ===");

				compteTour++;

				tour(true);

			}

		} else {

			if (force1 > force2) { // PLAYER 1 has a bigger card than PLAYER 2

				premierPaquet.retierEtAjouter(indexJoueur1, gagnePremier);
				secondPaquet.retierEtAjouter(indexJoueur2, gagnePremier);
				// both chosen cards are going into the won cards deck of PLAYER 1

				System.out.println("\n	=== PLAYER 1 won! ===");

				gagnePremier.ajouterUnPaquet(enJeu); // add the card from the egalite

			} else if (force2 > force1) { // PLAYER 2 has a bigger card than PLAYER 1

				premierPaquet.retierEtAjouter(indexJoueur1, gagneSecond);
				secondPaquet.retierEtAjouter(indexJoueur2, gagneSecond);
				// both chosen cards are going into the won cards deck of PLAYER 2

				System.out.println("\n	=== PLAYER 2 won! ===");

				gagneSecond.ajouterUnPaquet(enJeu); // add the card from the egalite

			} else { // egalite

				premierPaquet.retierEtAjouter(indexJoueur1, enJeu);
				secondPaquet.retierEtAjouter(indexJoueur2, enJeu);
				// both chosen cards are going into the storage deck enJeu

				System.out.println("\n	=== Equality! ===");

				compteTour++;

				tour(true);

			}

		}

		compteTour++;

	}

	static void tourOrdinateur(boolean egalite) { // PLAYER vs. COMPUTER

		System.out.println("\n	=== Let's start tour n\u00B0" + compteTour + ". ===");
		System.out.println("\n	=== PLAYER, your tour. ===");
		System.out.println("\nYour deck: " + premierPaquet.enTexte()); //
		System.out.println("\n === Now, chose the card you will use (type the index). ===");

		int indexJoueur = lire.nextInt() - 1;

		while (indexJoueur < 0 || indexJoueur >= premierPaquet.taille()) {
		// the user used an index out of the deck

			System.out.println("\n	There is no such card, please chose a corect card.");
			indexJoueur = lire.nextInt() - 1;

		}

		int forceJoueur = premierPaquet.retournerLePaquet().get(indexJoueur).retournerLaForce(); // the force of the selected card

		System.out.println("OK, you just chose the card: " + premierPaquet.retournerLePaquet().get(indexJoueur).enTexte() + ".");

		int indexOrdinateur = 0;
		int forceOrdinateur = secondPaquet.retournerLePaquet().get(indexOrdinateur).retournerLaForce(); // the force of the selected card

		try { // we have to use try/catch to prevent an error

			Thread.sleep(1000); // wait for 1000 ms so 1 s

		} catch (InterruptedException e) {

			//

		}

		System.out.println(clair);

		if (!egalite) { // normal game

			if (forceJoueur > forceOrdinateur) { // PLAYER has a bigger card than COMPUTER

				System.out.println("\n	" + premierPaquet.retournerLePaquet().get(indexJoueur).enTexte() + " is stonger than " + secondPaquet.retournerLePaquet().get(indexOrdinateur).enTexte() + ".");

				premierPaquet.retierEtAjouter(indexJoueur, gagnePremier);
				secondPaquet.retierEtAjouter(indexOrdinateur, gagnePremier);
				// both chosen cards are going into the won cards deck of PLAYER

				System.out.println("\n	=== PLAYER won! ===");

			} else if (forceOrdinateur > forceJoueur) { // COMPUTER has a bigger card than PLAYER

				System.out.println("\n	" + premierPaquet.retournerLePaquet().get(indexJoueur).enTexte() + " is weaker than " + secondPaquet.retournerLePaquet().get(indexOrdinateur).enTexte() + ".");

				premierPaquet.retierEtAjouter(indexJoueur, gagneSecond);
				secondPaquet.retierEtAjouter(indexOrdinateur, gagneSecond);
				// both chosen cards are going into the won cards deck of COMPUTER

				System.out.println("\n	=== COMPUTER won! ===");

			} else { // egalite

				System.out.println("\n	" + premierPaquet.retournerLePaquet().get(indexJoueur).enTexte() + " is equal to " + secondPaquet.retournerLePaquet().get(indexOrdinateur).enTexte() + ".");

				premierPaquet.retierEtAjouter(indexJoueur, enJeu);
				secondPaquet.retierEtAjouter(indexOrdinateur, enJeu);
				// both chosen cards are going into the storage deck enJeu

				System.out.println("\n	=== Equality! ===");

				compteTour++;

				tourOrdinateur(true);

			}

		} else {

			if (forceJoueur > forceOrdinateur) { // PLAYER has a bigger card than COMPUTER

				premierPaquet.retierEtAjouter(indexJoueur, gagnePremier);
				secondPaquet.retierEtAjouter(indexOrdinateur, gagnePremier);
				// both chosen cards are going into the won cards deck of PLAYER

				System.out.println("\n	=== PLAYER won! ===");

				gagnePremier.ajouterUnPaquet(enJeu); // add the card from the egalite

			} else if (forceOrdinateur > forceJoueur) { // COMPUTER has a bigger card than PLAYER

				System.out.println("\n	" + premierPaquet.retournerLePaquet().get(indexJoueur).enTexte() + " is equal to " + secondPaquet.retournerLePaquet().get(indexOrdinateur).enTexte() + ".");

				premierPaquet.retierEtAjouter(indexJoueur, gagneSecond);
				secondPaquet.retierEtAjouter(indexOrdinateur, gagneSecond);
				// both chosen cards are going into the won cards deck of COMPUTER

				System.out.println("\n	=== COMPUTER won! ===");

				gagneSecond.ajouterUnPaquet(enJeu); // add the card from the egalite

			} else { // egalite

				premierPaquet.retierEtAjouter(indexJoueur, enJeu);
				secondPaquet.retierEtAjouter(indexOrdinateur, enJeu);
				// both chosen cards are going into the storage deck enJeu

				System.out.println("\n	=== Equality! ===");

				compteTour++;

				tour(true);

			}

		}

		compteTour++;

	}

	public static void main(String[] args) {

		premierPaquet.melanger();

		int firstSize = premierPaquet.taille(); // 52

		for (int i = 0; i < firstSize / 2; i++) { // we remove te first half of the deck

			premierPaquet.retierEtAjouter(0, secondPaquet);
			// each iteration, we remove the first card of premierPaquet and give it to secondPaquet

		}

		// we now have two decks of 26 cards

		System.out.println(clair);
		System.out.println("\n		Bienvenue dans la ...\n");

		System.out.println("	_____      _    ________    _      __  __      __     ______");
		System.out.println("	||  \\\\    /|\\      ||      /|\\     ||  ||      ||     ||    ");
		System.out.println("	||__//   // \\\\     ||     // \\\\    ||  ||      ||     ||___ ");
		System.out.println("	||  \\\\  //===\\\\    ||    //===\\\\   ||  ||      ||     ||    ");
		System.out.println("	||__// //     \\\\   ||   //     \\\\  ||  ||____  ||____ ||____");

		System.out.println("\n	Veuillez choisir le mode de jeu en tapant :");
		System.out.println("\n	Joeur 1 contre Joueur 2:  [J] + [C] + [J]");
		System.out.println("	Joueur contre Ordinateur:    [J] + [C] + [O]");

		boolean ordinateur;

		switch (lire.nextLine()) {

			case "jcj":

				ordinateur = false;

				System.out.println("\n	OK, let's start PLAYER 1 vs. PLAYER 2. Good luck!");

				while (premierPaquet.taille() > 0) { // we repeat tour until the deck is empty

					tour(false);

				}

				break;

			case "jco":

				ordinateur = true;

				System.out.println("\n	OK, let's start PLAYER vs. COMPUTER. Good luck!");

				while (premierPaquet.taille() > 0) { // we repeat tour until the deck is empty

					tourOrdinateur(false);

				}

				break;

			default:

				ordinateur = false;

		}

		lire.close();

		int scorePremier = gagnePremier.compter();
		int scoreSecond = gagneSecond.compter();

		System.out.println("\n\n\n === The game is finished. ===");

		if (!ordinateur) {

			System.out.println("\n === PLAYER 1, you scored " + scorePremier + " points. ===");
			System.out.println("\n === PLAYER 2, you scored " + scoreSecond + " points. ===");

			if (scorePremier > scoreSecond) { // PLAYER 1 won

				System.out.println("\n === Congratulations PLAYER 1, you won the game! ===");

			} else if (scoreSecond > scorePremier) { // PLAYER 2 won

				System.out.println("\n === Congratulations PLAYER 2, you won the game! ===");

			} else { // egalite

				System.out.println("\n === Unbelievable!! Equality!! ===");

			}

		} else {

			System.out.println("\n === PLAYER, you scored " + scorePremier + " points. ===");
			System.out.println("\n === COMPUTER, scored " + scorePremier + " points. ===");

			if (scorePremier > scoreSecond) { // PLAYER won

				System.out.println("\n === Congratulations PLAYER, you won the game! ===");

			} else if (scoreSecond > scorePremier) { // COMPUTER won

				System.out.println("\n === Sorry, COMPUTER won the game! ===");

			} else { // egalite

				System.out.println("\n === Unbelievable!! Equality!! ===");

			}

		}

	}

}
