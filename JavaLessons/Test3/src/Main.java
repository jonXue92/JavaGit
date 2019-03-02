import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number = 0;
		Map<Integer, String> cityID = new HashMap<>();
		Map<String, Map<String, Integer>> cityDistMartix = new HashMap<>();
		String city = in.next();
		while (!city.equals("###")) {
			cityID.put(number, city);
			Map<String, Integer> cityDist = new HashMap<>();
			cityDistMartix.put(city, cityDist);
			number++;
			city = in.next();
		}
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				int dist = in.nextInt();
				cityDistMartix.get(cityID.get(i)).put(cityID.get(j), dist);
			}
		}
		String city1 = in.next();
		String city2 = in.next();
		System.out.println(cityDistMartix.get(city1).get(city2));
		in.close();
	}

}
