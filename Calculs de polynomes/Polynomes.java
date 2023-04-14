// =============================================================================================================== //
//                                                                                                                 //
//                                       Program coded by Artus de Chavagnac                                       //
//                                                                                                                 //
//                                                  November 2022                                                  //
//                                                                                                                 //
//                                        ČVUT - AE 2B 32 PRI - Programming                                        //
//                                                                                                                 //
// =============================================================================================================== //

class Polynomes {

	private static int[] coefficient = new int[10];
	// this array will contain the coefficient of the polynomial

	private static int[] puissance = new int[10];
	// this array will contain the powers of x of the polynomial

	private static String polynome = "x^2+x+1"; // the default polynomial

	public static void setPolynome(String poly) { // sets the polynomial using given string

		polynome = poly;

	}

	static float compute(float x) {

		int y = 0;

		String[] polynomeSepare = polynome.split("\\+"); // "a.x^b" (we have to put "\\+"" to use "+")

		for (int i = 0; i < polynomeSepare.length; i++) { // here we have to use .length and not .length()

			if (polynomeSepare[i].length() == 1) { // "x" or "a"

				if (polynomeSepare[i].equals("x")) { // "x" => "1.x^1"

					coefficient[i] = 1;
					puissance[i] = 1;

				} else { // "a" => "a.x^0"

					coefficient[i] = Integer.parseInt(polynomeSepare[i]);
					puissance[i] = 0;

				}

			} else if (polynomeSepare[i].length() == 3) { // "a.x" or "x^b"

				boolean point = polynomeSepare[i].indexOf(".") == 1;

				if (point) { // "a.x" => "a.x^1"

					String[] termePetit = polynomeSepare[i].split("\\."); // "a", "x"
					coefficient[i] = Integer.parseInt(termePetit[0]); // "a"

					puissance[i] = 1;

				} else { // "x^b" => "1.x^b"

					coefficient[i] = 1;

					String[] termePetit = polynomeSepare[i].split("\\^"); // "x", "b"
					puissance[i] = Integer.parseInt(termePetit[1]); // "b"

				}

			} else { // "a.x^b"

				String[] terme = polynomeSepare[i].split("\\."); // "a", "x^b" (same thing here for ".")

				coefficient[i] = Integer.parseInt(terme[0]); // "a"

				String[] xEtPuissance = terme[1].split("\\^"); // "x", "b" (same here for "^")
				puissance[i] = Integer.parseInt(xEtPuissance[1]); // "b"

			}

			y += coefficient[i] * Math.pow(x, puissance[i]);

		}

		return y;

	}

}