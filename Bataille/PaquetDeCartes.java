// =============================================================================================================== //
//                                                                                                                 //
//                                      Programme codé par Artus de Chavagnac                                      //
//                                                                                                                 //
//                                                  décembre 2022                                                  //
//                                                                                                                 //
// =============================================================================================================== //

import java.util.*;

class PaquetDeCartes {

	// ==== variables ====

	private ArrayList <Carte> paquet = new ArrayList <> ();
	private String etat = "visible"; // by default, the paquet is caché

	// ==== constructors ====

	PaquetDeCartes() { // 52 cartes

		for (int i = 0; i < 4; i++) {

			for (int j = 1; j < 14 ; j++) {

				Carte carte = new Carte(j, Carte.familles[i]); // Carte.familles is the array storing the familles
				this.ajouterUneCarte(carte);

			}

		}

	}

	PaquetDeCartes(PaquetDeCartes paquet) { // create a paquet from an existing paquet

		if (paquet != null) {

			this.etat = paquet.etat;
			this.paquet = paquet.paquet;

		}

	}

	PaquetDeCartes(Carte carte) { // create a paquet from a single carte (Carte object)

		this.ajouterUneCarte(carte);

	}

	PaquetDeCartes(String carte) { // create a paquet from a single carte (String)

		int force;
		String niveau = carte.split(" ")[0]; // niveau is like force but with "As", "Roi", "Dame" and "Valet"
		// if: carte = "Valet de Diamonds"
		// then: carte.split(" ")[0] --> "Valet"

		force = switch (niveau) {

			case "As" -> 1;
			case "Valet" -> 11;
			case "Dame" -> 12;
			case "Roi" -> 13;
			default -> Integer.parseInt(niveau);
			// we have to put all the stuff before "niveau" to convert from String to in

		};

		String famille = carte.split(" ")[2];
		// if: carte = "Valet de Diamonds"
		// then: carte.split(" ")[2] --> "Diamonds"

		this.ajouterUneCarte(new Carte(force, famille));

	}

	void ajouterUneCarte(Carte carte) { // add a carte to the paquet

		this.paquet.add(carte);

	}

	String enTexte() { // returns the paquet as a String

		String description = "";

		switch (etat) {

			case "premiereVisible":

				description += "[#1: " + this.paquet.get(0).enTexte() + "]";

				for (int i = 1; i < this.paquet.size(); i++) {

					description += ", [#" + (i + 1) + ": cach\u00e9e]";

				}

				break;

			case "visible":

				description += "[#1: " + this.paquet.get(0).enTexte() + "]";

				for (int i = 1; i < this.paquet.size(); i++) {

					description += ", [#" + (i + 1) + ": " + this.paquet.get(i).enTexte() + "]";

				}

				break;

			default:

				description += "[#1: cach\u00e9e]";

				for (int i = 1; i < this.paquet.size(); i++) {

					description += ", [#" + (i + 1) + ": cach\u00e9e]";

				}

		}

		return description;

	}

	Carte choisirAuHasard() { // picks a aleatoire carte from the paquet

		Random aleatoire = new Random();

		int indexAleatoire = aleatoire.nextInt(0, this.paquet.size());

		Carte carteTiree = this.paquet.get(indexAleatoire);

		this.paquet.remove(indexAleatoire);

		return carteTiree;

	}

	int compter() { // counts the valeur de the paquet using Blackjack rules

		int valeur = 0;

		for (Carte carte: this.paquet) { // for each carte de the paquet

			switch (carte.retournerLaForce()) {

				case 11, 12, 13 -> // Valet, Dame and Roi

					valeur += 10;

				case 1 -> // As

					valeur += 11;

				default -> // every other carte

					valeur += carte.retournerLaForce();
			}

		}

		return valeur;

	}

	void definirEtat(String etat) { // redefines the set de the paquet

		this.etat = etat;

	}

	void melanger() { // shuffle the paquet by picking aleatoire cartes inside

		for (int i = 0; i < this.paquet.size() * 3; i++) {

			this.paquet.add(this.choisirAuHasard());

		}

	}

	int taille() { // get the paquet size

		return this.paquet.size();

	}

	ArrayList <Carte> retournerLePaquet() { // get the paquet as an ArrayList

		return this.paquet;

	}

	void ajouterUnPaquet(PaquetDeCartes paquet) {

		this.paquet.addAll(paquet.retournerLePaquet());

	}

	void retierEtAjouter(int index, PaquetDeCartes paquet) {
	// remove a carte from the first paquet and add it to se second

		Carte carte = this.retournerLePaquet().get(index); // get the selected carte

		this.retournerLePaquet().remove(index); // remove the carte from the first paquet

		paquet.ajouterUneCarte(carte); // add the carte to the second paquet

	}

}
