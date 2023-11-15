// ================================================================================================================== //
//                                                                                                                    //
//                                                       Dames                                                        //
//                                                                                                                    //
// ================================================================================================================== //

class Plateau {

	Cellule[][] grille = new Cellule[10][10];
	String colones = "	       A       B       C       D       E       F       G       H       I       J";

	Plateau() {

		boolean estBlanc = true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Cellule cellule = new Cellule(estBlanc, "Vide", true);
				grille[i][j] = cellule;
				estBlanc = !estBlanc;
			}
			estBlanc = !estBlanc;
		}

	}

	void imprimer() {

		int numeroLigne = 0;
		String numeroAffiche;
		System.out.println();
		System.out.println(colones);
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 4; k++) {
				String ligne = "";
				for (int j = 0; j < 10; j++) {ligne += grille[i][j].enChaine()[k];}
				if (numeroLigne % 4 == 1) {
					if (numeroLigne == 37) {numeroAffiche = " 10";} else {numeroAffiche = " " + (i + 1) + " ";}
				} else {
					numeroAffiche = "   ";
				}
				System.out.println("	" + numeroAffiche + ligne + numeroAffiche);
			numeroLigne++;
			}
		}
		System.out.println(colones);

	}

	static Plateau ajouterPions(Plateau plateau) {

		String etatPionAvant = "Pion";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				if (etatPionAvant == "Pion") {plateau.grille[i][j].etat = "Vide";} else {plateau.grille[i][j].etat = "Pion";}
				plateau.grille[i][j].estPieceBlanche = false;
				if (etatPionAvant == "Pion") {etatPionAvant = "Vide";} else {etatPionAvant = "Pion";}
			}
			if (etatPionAvant == "Pion") {etatPionAvant = "Vide";} else {etatPionAvant = "Pion";}
		}
		for (int i = 6; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (etatPionAvant == "Pion") {plateau.grille[i][j].etat = "Vide";} else {plateau.grille[i][j].etat = "Pion";}
				plateau.grille[i][j].estPieceBlanche = true;
				if (etatPionAvant == "Pion") {etatPionAvant = "Vide";} else {etatPionAvant = "Pion";}
			}
			if (etatPionAvant == "Pion") {etatPionAvant = "Vide";} else {etatPionAvant = "Pion";}
		}
		return plateau;

	}

	void deplacement(int ancienneOrdonnee, int ancienneAbscisse, int nouvelleOrdonnee, int nouvelleAbscisse) {

		grille[nouvelleOrdonnee][nouvelleAbscisse].etat = grille[ancienneOrdonnee][ancienneAbscisse].etat;
		grille[ancienneOrdonnee][ancienneAbscisse].etat = "Vide";
		grille[nouvelleOrdonnee][nouvelleAbscisse].estPieceBlanche = grille[ancienneOrdonnee][ancienneAbscisse].estPieceBlanche;
	}

}

// ================================================================================================================== //
//                                                                                                                    //
//                                                       Dames                                                        //
//                                                                                                                    //
// ================================================================================================================== //