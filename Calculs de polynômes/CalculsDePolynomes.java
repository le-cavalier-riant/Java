// ================================================================================================================== //
//                                                                                                                    //
//                                                Calculs de polynômes                                                //
//                                                                                                                    //
// ================================================================================================================== //

import java.io.*;
import java.util.*;

class CalculsDePolynomes {

	public static void main(String[] args) {

		Scanner lire = new Scanner(System.in);
		System.out.println("	How many polynomials do you want?");
		int nombreDePolynomes = lire.nextInt();
		String[] tableauDesPolynomes = new String[nombreDePolynomes];
		System.out.println("	How do you want to enter the polynomials?");
		System.out.println("		From file: type [F], from console: type [Any but F]");
		lire.nextLine();
		if (lire.nextLine().equals("f")) {
			try {
				System.out.println(
					"	Please make sure that the polynomials are well written in the file \"polynomes.txt\""
				);
				System.out.println("	When done, please type [Enter]");
				lire.nextLine();
				System.out.println("	File reading in process...");
				FileInputStream fichier = new FileInputStream("polynomes.txt");
				Scanner lire = new Scanner(fichier);
				int n = 0;
				while(lire.hasNextLine()) {
					tableauDesPolynomes[n] = lire.nextLine();
					n++;
				}
				lire.close();
				System.out.println("	End of file detected. Here are your polynomials:");
				for (int j = 0; j < nombreDePolynomes ; j++) {
					System.out.println("n\u00B0" + (j + 1) + ": \"" + tableauDesPolynomes[j] + "\"");
				}
			} catch(IOException e) {
				System.out.println("	There has been an error during processing. E#1");
				return;
			}
		} else {
			Scanner lirePolynomes = new Scanner(System.in);
			for (int i = 0; i < nombreDePolynomes ; i++ ) {
				try {
					System.out.println("	Please, enter your polynomial n\u00B0" + (i + 1));
					tableauDesPolynomes[i] = lirePolynomes.nextLine();
					System.out.println("	The polynomial \"" + tableauDesPolynomes[i] + "\" has been added.");
				} catch (Exception e) {
					System.out.println("	End of file detected. Here are your polynomials:");
					for (int j = 0; j < nombreDePolynomes ; j++) { // prints the polynomial for the user
						System.out.println("n\u00B0" + (j + 1) + ": \"" + tableauDesPolynomes[j] + "\"");
					}
					lirePolynomes.close();
					break;
				}
			}
		}
		System.out.println("	In order to compute the values of the entered polynomials, use the following command:");
		System.out.println("	\"-x the_value\", and replace \"the_value\" by your chosen value of x.");
		int valeur = 0;
		int somme = 0;
		float moyenne = 0;
		try {
			String[] commande = lire.nextLine().split(" "); // "-x", "a"
			valeur = Integer.parseInt(commande[1]); // "a"
			for (int k = 0; k < nombreDePolynomes ; k++ ) { // compute the values
				Polynomial.setPolynome(tableauDesPolynomes[k]);
				somme += Polynomial.compute(valeur);
			}
			moyenne = somme / nombreDePolynomes; // calculates the value of the average
			System.out.println("	The average value of the polynomials, for x = " + valeur + ", is: " + moyenne);
		} catch (Exception e) {
			System.out.println("	Sorry, there has been an error. E#2");
		}
	}

}

// ================================================================================================================== //
//                                                                                                                    //
//                                                Calculs de polynômes                                                //
//                                                                                                                    //
// ================================================================================================================== //