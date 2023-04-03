import java.util.Stack;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			switch (temp.charAt(1)) {
			case 'u': {
				st.push(Integer.parseInt(temp.substring(5)));
				break;
			}
			case 'i': {
				sb.append(st.size() + "\n");
				break;
			}
			case 'm': {
				sb.append(st.isEmpty() ? 1 : 0).append("\n");
				break;
			}
			case 'o': {
				switch (temp.charAt(0)) {
				case 'p': {
					if (st.size() == 0) {
						sb.append("-1\n");
						break;
					}
					sb.append(st.pop() + "\n");
					break;
				}
				case 't': {
					if (st.size() == 0) {
						sb.append("-1\n");
						break;
					}
					sb.append(st.get(st.size() - 1) + "\n");
				}
				}
			}

			}
		}
		System.out.println(sb.toString());
	}

}
