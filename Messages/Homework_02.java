import java.util.*;

public class SortByValues {

	public static void main(String[] args) {

		Map<String, Integer> unSortedMap = new HashMap<>();
		unSortedMap.put("K", 12);
		unSortedMap.put("I", 2);
		unSortedMap.put("U", 9);
		unSortedMap.put("N", 1);
		unSortedMap.put("A", 4);
		unSortedMap.put("E", 3);
		System.out.println("Map Before Sorting");
		System.out.println(unSortedMap);
		System.out.println("Map After Sorting");
		System.out.println("Sorted Map......By Value");
		Map<String, Integer> sortedMap = sortByValue(unSortedMap);
		printMap(sortedMap);

	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

		// Convert Map to List of Map
		List<Entry<String, Integer>> list =	new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());
		// Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(
			list, new Comparator<Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					return (o1.getValue()).compareTo(o2.getValue());
				}
			}
		);
		// Loop the sorted list and put it into a new insertion order Map LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {sortedMap.put(entry.getKey(), entry.getValue());}
		return sortedMap;

	}

	public static <K, V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
	}

}

public class Homework_02 {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		int eid, sid;
		String ename;
		Map<String, Integer> map = new HashMap<String, Integer>();
		while (scanner.hasNextLine()) {
			String [] line = scanner.nextLine().split("\\s+");
			if (line[4].contains("sshd") && line[5].contains("Accept")) {
				if (map.containsKey(line[10])) {
					map.replace(line[10], map.get(line[10]) + 1);
				} else {
					map.put(line[10], 1);
				}
			}

		}

		printMap(map);
		Map<String, Integer> sortedMap = sortByValue(map);
		printMap(sortedMap);

		// codezup.com/ways-to-sort-a-map-in-java-with-examples/ 

		private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

		// "Homework_02.java" 69L, 2515C
		// the strange usage of <?> is Generics:

		}

	}

}