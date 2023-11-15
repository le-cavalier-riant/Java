import java.lang.Math;

class Somme {

	public static void main(String[] args) {

		double s = 0;
		int n = 20;
		for (int i = 0; i < n ; i++) {
			s += i / Math.pow(10, i);
			System.out.println(s);
		}

	}

}
