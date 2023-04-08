import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer, TreeSet<Integer>> tree = new TreeMap<>();
		for (int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(!tree.containsKey(y)) {
				TreeSet<Integer> temp = new TreeSet<>();
				temp.add(x);
				tree.put(y, temp);
			} else {
				tree.get(y).add(x);
			}
		}
		
		for(Integer y : tree.keySet()) {
			for(Integer x : tree.get(y)) {
				sb.append(x + " " + y + "\n");
			}
		}
		System.out.println(sb.toString());
	}

}