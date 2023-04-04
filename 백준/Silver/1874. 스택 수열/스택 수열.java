import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int pos = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > pos) {
				int step = num - pos;
				for (int a = 1; a <= step; a++) {
					pos++;
					st.add(pos);
					sb.append("+\n");
				}
				st.pop();
				sb.append("-\n");
				continue;
			} else if (st.get(st.size() - 1) == num) {
				st.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb.toString());

	}

}