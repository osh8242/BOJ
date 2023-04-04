import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= n; test_case++) {
			Stack<Character> st = new Stack<Character>();
			String temp = br.readLine();
			for (int i = 0; i < temp.length(); i++) {
				st.add(temp.charAt(i));
				if (st.size() >= 2) {
					while (st.size() >= 2 && st.get(st.size() - 2) == '(' && st.get(st.size() - 1) == ')') {
						st.pop();
						st.pop();
					}
				}
			}
			if (st.size() == 0) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}

		}
		System.out.println(sb.toString());

	}

}