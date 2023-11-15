// ================================================================================================================= //
//                                                                                                                   //
// ================================================================================================================= //

// modificateurs d’accès de classe :
// 		public
// 			la classe est accessible par n’importe quelle autre classe
// 		par défaut (rien)
// 			la classe n’est accessible que par les classes du même package (dossier)

// modificateurs d’accès d'attributs, méthodes et constructeurs :
// 		public
// 			le code est accessible à toutes les classes
// 		private
// 			le code n’est accessible que dans la classe déclarée (même pas les sous-classes)
// 		protected
// 			le code est accessible dans le même package et les sous-classes
// 		par défaut (rien)
// 			le code n’est accessible que dans le même package

// modificateurs d'état de classe :
// 		final
// 			la classe ne peut pas être héritée (modifiée) par une autre classe
// 		abstract
// 			la classe ne peut pas créer d'objets (classeAbstraite.objet1)

// modificateurs d'état d'attributs et méthodes :
// 		final
// 			ne peut plus être modifié/réécrit
// 		static
// 			appartient à la classe et non à un objet de cette classe
// 		abstract
// 			seulement pour une classe abstraite, sert à définir les méthodes en avance, il faudra les "@override" en quelque sorte, on ne peut plus changer la valeur de retour, ni les paramètres d'entrée
// 		transient
// 			les attributs et méthodes sont ingorés lors de la sérialisation de l'objet les contenant
// 		synchronized
// 			les méthodes ne sont accessibles qu'à un seul thread à la fois
// 		volatile
// 			la valeur d'un attribut n'est pas mise en cache thread-localement et est toujours lue dans la "mémoire principale"

import java.util.Arrays; // pour println une array

class Java {

	public static void main(String[] args) {

		int heure = 20, jour = 4;
		String texte = "donne moi l'index du mot.";
		String[] voitures = {"Volvo","BMW","Ford","Mazda"};

		System.out.println("La longeur de la cha\u00eene \"texte\" est : " + texte.length());
		System.out.println(texte.indexOf("mot"));

		String resultat = (heure < 18)? "Bonjour." : "Bonsoir.";

		for (String voiture:voitures) {System.out.println(voiture);}
			// parcourt tous les éléments de la chaine "voitures"

		System.out.println(Arrays.toString(voitures));
		voitures[0] = "Opel";

		for (int h = 0; h < voitures.length; h++) {System.out.println(voitures[h]);}

		System.out.println(String.format("%s de %s", "prout", "gindoux"));

	}

}

// ================================================================================================================= //
//                                                                                                                   //
// ================================================================================================================= //