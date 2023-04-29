import java.util.HashMap;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		HashMap<Character, Integer> count = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		for (int i = 0; i < str.length(); i++) {
			if (!count.containsKey(str.charAt(i))) {
				count.put(str.charAt(i), 1);
			} else {
				count.put(str.charAt(i), count.get(str.charAt(i)) + 1);
			}
		}
		int max = 0;
		boolean isDuplicate = false;
		char ch = ' ';
		for (char c : count.keySet()) {
			if (count.get(c) < max) {
				continue;
			} else if (count.get(c) > max) {
				ch = c;
				max = count.get(c);
				isDuplicate = false;
			} else if (count.get(c) == max) {
				isDuplicate = true;
			}
		}
		if (isDuplicate) {
			System.out.println("?");
		} else {
			System.out.println(ch);
		}

	}

}
