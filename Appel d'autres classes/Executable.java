class Executable {

	public static void main(String[] args) {

		Principale.methodeStatique();
		Principale objet = new Principale(5);
		objet.attribut3 = "Test";
		objet.methodePublique();

	}

}
