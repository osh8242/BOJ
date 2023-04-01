import java.util.HashMap;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		HashMap<String, String> data = new HashMap<>();
		data.put("12345678", "ascending");
		data.put("87654321", "descending");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().replaceAll(" ", "");
		if (data.get(str) != null) {
			System.out.println(data.get(str));
		} else {
			System.out.println("mixed");
		}

	}

}
