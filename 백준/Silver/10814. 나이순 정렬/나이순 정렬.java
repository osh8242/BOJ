import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer, String> tree = new TreeMap<>();
		for (int i = 0 ; i < n ; i++) {
			String[] temp = br.readLine().split(" ");
			if(!tree.containsKey(Integer.parseInt(temp[0]))) {
				tree.put(Integer.parseInt(temp[0]), temp[1]);
			} else {
				tree.put(Integer.parseInt(temp[0]), tree.get(Integer.parseInt(temp[0]))+","+temp[1]);
			}			
		}
		for (Map.Entry<Integer, String> user : tree.entrySet()) {
			String[] names = user.getValue().split(",");
			for (int i = 0 ; i < names.length ; i++) {
				sb.append(user.getKey()+ " " + names[i]+"\n");
			}
		}
		System.out.println(sb.toString());
	}

}
