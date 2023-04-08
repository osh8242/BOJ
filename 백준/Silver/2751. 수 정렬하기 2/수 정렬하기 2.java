import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeSet<Integer> tree = new TreeSet<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0 ; i < n ; i++) {
			int temp = Integer.parseInt(br.readLine());
			tree.add(temp);
		}
		for (Integer num : tree) {
			sb.append(num+"\n");
		}
		System.out.println(sb.toString());
	}

}
