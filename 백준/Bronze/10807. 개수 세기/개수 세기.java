import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (v == Integer.parseInt(st.nextToken())) {
				count++;
			}
		}
		System.out.println(count);

	}

}