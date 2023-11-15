import java.util.Scanner;

class Messages {

	public static void main(String args[]) {

		Scanner lire = new Scanner(System.in);
		String ename;
		int eid, sid;
		Map <String,Integer> carte = new HashMap <String,Integer>();
		while (lire.hasNextLine()) {
			String [] ligne = lire.nextLine().split("\\s+");
			if (ligne[4].contains("sshd") && ligne[5].contains("Accept")) {
				if (carte.containsKey(ligne[10])) {
					carte.replace(ligne[10],carte.get(ligne[10]) + 1);
				} else {
					carte.put(ligne[10],1);
				}
			}
		}
		imprimer(carte);
		Map <String, Integer> carteTriee = trierParValeurs(carte);
		imprimer(carteTriee);

	}

	// codezup.com/ways-to-sort-a-carte-in-java-with-examples
	static Map <String, Integer> trierParValeurs(Map <String, Integer> unsortMap) {

		// Convert Map to List of Map
		List <Map.Entry <String, Integer>> list = new LinkedList <Map.Entry <String, Integer>>(unsortMap.entrySet());
		// Sort list with Collections.sort(),provide a custom ComparatorTry switch the o1 o2 position for a different order
		Collections.sort(
			list, new Comparator <Map.Entry <String, Integer>>() {
				int compare(Map.Entry <String, Integer> o1, Map.Entry <String, Integer> o2) {
					return (o1.getValue()).compareTo(o2.getValue());
				}
			}
		);
		// Loop the sorted list and put it into a new insertion order Map LinkedHashMap
		Map <String, Integer> carteTriee = new LinkedHashMap <String, Integer>();
		for (Map.Entry <String, Integer> entry : list) {
			carteTriee.put(entry.getKey(), entry.getValue());
		}
		return carteTriee;

	}

	static <K, V> void imprimer(Map <K, V> carte) {
		for (Map.Entry <K, V> entry : carte.entrySet()) {System.out.println(entry.getValue() + " " + entry.getKey());}
	}

}
