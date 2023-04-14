class Privee {

	private static String nom = "Artus de Chavagnac";
	// le nom est privé donc non accessible/modifiable sanf dans la classe Privee

	static String obtenirNom() { // getter, publique donc tout le mond y a accès

	// retourne le nom alors qu'il est privé
		return nom;

	}

	static void definirNom(String nouveauNom) { // setter, publique aussi

	// change le nom alors qu'il est privé
		nom = nouveauNom;

	}

	public static void main(String[] args) {

		// ici l'on a accès au nom
		System.out.println(nom);

	}

}