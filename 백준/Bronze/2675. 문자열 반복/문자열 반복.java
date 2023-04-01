import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				for (int j = 1; j <= count; j++) {
					sb.append(str.charAt(i));
				}
			}
			System.out.println(sb.toString());
		}
	}

}
