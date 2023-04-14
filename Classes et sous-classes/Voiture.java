// maintenants que la classe "Vehicule" est crée, nous allons lui donner une sous-classe qui ve reprendre ses attributs

class Voiture extends Vehicule { // sous-classe de Vehicule, qui l'étend

	private String modele = "Mustang"; // attribut de la clase "Voiture" seulement

	public static void main(String[] args) {

		Voiture maVoiture = new Voiture(); // crée un objet de la classe "Voiture"

		maVoiture.klaxon(); // effectue la méthode "klaxon()" de la classe "Voiture"

		System.out.println(maVoiture.marque + " " + maVoiture.modele);
		// ici l'on peut utiliser "marque" car il s'agit d'un objet de la classe 'maman' "Vehicule" mais aussi "modele" car "maVoiture" est de classe "Voiture"

	}

}
