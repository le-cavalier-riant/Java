class Principale { // tous les objets de cette classe auront comme attributs les suivants :

	int attribut1;
	private final int attribut2; // privé
	String attribut3 = "Bonjour !";

	Principale(int parametre) { // constructeur, s'exécute pour chaque objet créé

	// necessite d'être paramétrée lors de la création d'un objet
	// sans "void" mais sans "return" quand même

		attribut1 = 2 * parametre;
		attribut2 = 10 * parametre - 5;

	}

	static void methodeStatique() { // static = sans créer d'objet de classe "Principale"

		System.out.println("Salut tout le monde ! Statiquement :)");

	}

	void methodePublique() { // pas static = il faut créer un objet de classe "Principale"

		System.out.println("Saaaaaalut le public !");
		System.out.println("1 : " + attribut1); // moi, je peux utiliser les attributs, car je necessite un objet :)
		System.out.println("2 : " + attribut2);
		System.out.println("3 : " + attribut3);

	}

}
