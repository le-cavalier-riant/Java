// ================================================================================================================== //
//                                                                                                                    //
//                                                       Dames                                                        //
//                                                                                                                    //
// ================================================================================================================== //

class Cellule {

	boolean estBlanc;
	String etat;
	boolean estPieceBlanche;

	Cellule(boolean estBlanc, String etat, boolean estPieceBlanche) {

		this.estBlanc = estBlanc;
		this.etat = etat;
		this.estPieceBlanche = estPieceBlanche;

	}

	String[] enChaine() {

		String[] lignes = new String[4];
		String couleurPion;
		if (estPieceBlanche) {couleurPion = "@";} else {couleurPion = "*";}
		String decalageGauche = " ";
		String couleurCellule;
		if (estBlanc) {couleurCellule = "#";} else {couleurCellule = ".";}
		if (etat == "Vide") {
			lignes[0] = decalageGauche + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule;
			lignes[1] = decalageGauche + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule;
			lignes[2] = decalageGauche + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule;
			lignes[3] = decalageGauche + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule + couleurCellule;
		} else {
			lignes[0] = decalageGauche + couleurCellule + couleurPion + couleurPion + couleurPion + couleurPion + couleurPion + couleurCellule;
			lignes[1] = decalageGauche + couleurPion + couleurPion + couleurPion + couleurPion + couleurPion + couleurPion + couleurPion;
			lignes[2] = decalageGauche + couleurPion + couleurPion + couleurPion + couleurPion + couleurPion + couleurPion + couleurPion;
			lignes[3] = decalageGauche + couleurCellule + couleurPion + couleurPion + couleurPion + couleurPion + couleurPion + couleurCellule;
		}
		if (etat == "Dame") {
			lignes[0] = new StringBuilder(lignes[0]).replace(2, 7, "DDDDD").toString();
			lignes[1] = new StringBuilder(lignes[1]).replace(1, 2, "D").replace(7, 8, "D").toString();
			lignes[2] = new StringBuilder(lignes[2]).replace(1, 2, "D").replace(7, 8, "D").toString();
			lignes[3] = new StringBuilder(lignes[3]).replace(2, 7, "DDDDD").toString();
		}
		return lignes;

	}

}

// ================================================================================================================== //
//                                                                                                                    //
//                                                       Dames                                                        //
//                                                                                                                    //
// ================================================================================================================== //