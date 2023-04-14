// =============================================================================================================== //
//                                                                                                                 //
//                                      Programme codé par Artus de Chavagnac                                      //
//                                                                                                                 //
//                                                  décembre 2022                                                  //
//                                                                                                                 //
// =============================================================================================================== //

class Carte {

	private final int force;
	private final String famille;
	static boolean unicode = false; // turn this one "true" in order to print the unicodes symbols

	static String[] familles = {"Piques", "Coeurs", "Carreaux", "Tr\u00e8fles"};
	// this array store the familles values, we will use it later, in other classes

	Carte (int force, String famille) {

		this.force = force;
		this.famille = famille;

	}

	String enTexte() { // returns the card as a String

		String familleOuUnicode;

		if (unicode) {

				familleOuUnicode = switch (this.famille) {

					case "Piques" -> "♠";
					case "Coeurs" -> "♥";
					case "Carreaux" -> "♦";
					default -> "♣";

				};

			} else {

				familleOuUnicode = this.famille;

			}

		return switch (this.force) {

			case 1 -> "As de " + familleOuUnicode;
			case 11 -> "Valet de " + familleOuUnicode;
			case 12 -> "Dame de " + familleOuUnicode;
			case 13 -> "Roi de " + familleOuUnicode;
			default -> this.force + " de " + familleOuUnicode;

		};

	}

	int retournerLaForce() {

		return this.force;

	}

}
