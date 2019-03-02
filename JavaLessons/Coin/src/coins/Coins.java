package coins;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coins {
	private Map<Integer, String> coinnames = new HashMap<>();
	public Coins() {
		coinnames.put(1, "penny");
		coinnames.put(10, "dime");
		coinnames.put(25, "quarter");
		coinnames.put(50, "half-dolar");
		coinnames.put(50, "ÎåÃ«");
		System.out.println(coinnames.keySet().size());
		System.out.println(coinnames);
		for (Integer k : coinnames.keySet()) {
			System.out.println(coinnames.get(k));
		}
	}
	public String getName(int amount) {
		if (coinnames.containsKey(amount)) {
			return coinnames.get(amount);
		} else {
			return "not found";
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int amount  = in.nextInt();
		Coins coin = new Coins(); 
		System.out.println(coin.getName(amount));
		in.close();
	}

}
