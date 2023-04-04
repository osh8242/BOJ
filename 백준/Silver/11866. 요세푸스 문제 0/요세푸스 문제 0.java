import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			ll.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int index = k - 1;
		while (ll.size() != 1) {
			sb.append(ll.get(index)).append(", ");
			ll.remove(index);
			index += k - 1;
			if (index >= ll.size()) {
				index %= ll.size();
			}

		}
		sb.append(ll.get(0)).append(">");
		System.out.println(sb.toString());

	}

}