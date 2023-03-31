import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int x = Integer.parseInt(st1.nextToken());
		int count = 0;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int a = Integer.parseInt(st2.nextToken());
			if (x > a) {
				sb.append(a + " ");
			}
		}
		System.out.println(sb.toString().trim());

	}

}