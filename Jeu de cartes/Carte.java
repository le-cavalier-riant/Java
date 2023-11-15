class Carte { // création des cartes (objets de la classe "Carte")

	private int force; // 1 --> 13
	private char icone; // '^', 'v', 'x', '&'
	private String famille; // "piques", "coeurs", "carreaux", "trèfle"
	private boolean visible; // true, false
	private String dos =
		" -------\n" +
		"|\\-----/|\n" +
		"| |   | |\n" +
		"| | ~ | |\n" +
		"| |   | |\n" +
		"|/-----\\|\n" +
		" -------";
	private String trait = " -------";
	private String vide = "|       |";
	private String[] dessin = new String[7];

	static String[] familles = {"piques", "coeurs", "carreaux", "trèfles"};

	Carte(int force, String famille, boolean visible) {

		if (force < 14 && force > 0) {

			this.force = force;

		} else {

			System.out.println("E1");

		}

		if (famille.equals("piques")) {

			this.famille = famille;
			this.icone = '^';

		} else if (famille.equals("coeurs")) {

			this.famille = famille;
			this.icone = 'v';

		} else if (famille.equals("carreaux")) {

			this.famille = famille;
			this.icone = 'x';

		} else if (famille.equals("trèfles")) {

			this.famille = famille;
			this.icone = '&';

		} else {

			System.out.println("E2");
		}

		this.visible = visible;

	}

	void imprimer() {

		dessin[0] = trait;
		dessin[6] = trait;

		if (this.visible) {

			String un = "|   " + this.icone + "   |";
			String deux = "|  " + this.icone + " " + this.icone + "  |";
			int ligne = 0;

			// ========== ligne 1 ==========
			ligne = 1;

			if (this.force == 13) {

				dessin[ligne] = "|R   WW |";

			} else if (this.force == 12) {

				dessin[ligne] = "|D   ~~ |";

			} else if (this.force == 11) {

				dessin[ligne] = "|V      |";

			} else if (this.force == 10) {

				dessin[ligne] = "|" + this.force + "" + this.icone + " " + this.icone + "  |";

			} else if (this.force > 6) {

				dessin[ligne] = "|" + this.force + " " + this.icone + " " + this.icone + "  |";

			} else {

				dessin[ligne] = "|" + this.force + "      |";
			}

			// ========== ligne 2 ==========
			ligne = 2;

			if (this.force == 1) {

				dessin[ligne] = vide;

			} else if (this.force == 12) {

				dessin[ligne] = "| \\  {]\\|";

			} else if (this.force == 11 || this.force == 13) {

				dessin[ligne] = "| \\  {] |";

			} else if (this.force < 4) {

				dessin[ligne] = un;

			} else {

				dessin[ligne] = deux;
			}

			// ========== ligne 3 ==========
			ligne = 3;

			if (this.force == 10 || this.force == 6) {

				dessin[ligne] = "|  " + this.icone + " " + this.icone + "  |";

			} else if (this.force == 7) {

				dessin[ligne] = "|       |";

			} else if (this.force > 10) {

				dessin[ligne] = "|| |" + this.icone + "| ||";

			} else if ((this.force % 2) == 1) {

				dessin[ligne] = un;

			} else {

				dessin[ligne] = vide;

			}

			// ========== ligne 4 ==========
			ligne = 4;

			if (this.force == 1) {

				dessin[ligne] = vide;

			} else if (this.force == 7) {

				dessin[ligne] = un;

			} else if (this.force < 4) {

				dessin[ligne] = un;

			} else if (this.force > 10) {

				dessin[ligne] = "| [}  \\ |";

			} else {

				dessin[ligne] = deux;

			}

			// ========== ligne 5 ==========
			ligne = 5;

			if (this.force == 13) {

				dessin[ligne] = "| MM   R|";

			} else if (this.force == 12) {

				dessin[ligne] = "|\\~~   D|";

			} else if (this.force == 11) {

				dessin[ligne] = "|      V|";

			} else if (this.force == 10) {

				dessin[ligne] = "|  " + this.icone + " " + this.icone + "" + this.force + "|";

			} else if (this.force > 6 && this.force < 10) {

				dessin[ligne] = "|  " + this.icone + " " + this.icone + " " + this.force + "|";

			} else {

				dessin[ligne] = "|      " + this.force + "|";

			}

			for (int i = 0; i < 7; i++) {

				System.out.println(dessin[i]);

			}

		} else {

			System.out.println(dos);

		}

	}


	String texte() {

		if (visible) {

			String description = "";

			if (this.force == 13) { // force

				description += "Roi";

			} else if (this.force == 12) {

				description += "Dame";;

			} else if (this.force == 11) {

				description += "Valet";

			} else if (this.force == 1) {

				description += "As";

			} else {

				description += force;

			}

			description += " de " + this.famille;

			return description;

		} // pas besoi de "else" car il y a "return"

		return "caché";

	}

}
