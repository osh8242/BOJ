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
			if(!tree.containsKey(x)) {
				TreeSet<Integer> temp = new TreeSet<>();
				temp.add(y);
				tree.put(x, temp);
			} else {
				tree.get(x).add(y);
			}
		}
		
		for(Integer x : tree.keySet()) {
			for(Integer y : tree.get(x)) {
				sb.append(x + " " + y + "\n");
			}
		}
		System.out.println(sb.toString());
	}

}
